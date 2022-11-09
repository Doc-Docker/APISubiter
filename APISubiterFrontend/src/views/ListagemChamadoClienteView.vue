<template>
  <div class="mb-3 mt-3">
    <div class="row">
      <div class="col-md-6">
        <h3>Chamado Cliente</h3>
      </div>
    </div>
    <table class="table table-striped table-bordered" style="text-align: center">
      <thead>
        <tr>
          <th scope="col">Nome Usuário</th>
          <th scope="col">Tipo de Chamado</th>
          <th scope="col">Criticidade</th>
          <th scope="col">Data de Chamado</th>
          <th scope="col">Descrição</th>
          <th scope="col">Situação Chamado</th>
          <th scope="col">Solução</th>
          <th scope="col">Data Encerramento</th>
          <th scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(chamado_cliente, i) in chamado_clientes" :key="i">
          <td>{{ chamado_cliente.usuarioChamado.name }}</td>
          <td>{{ chamado_cliente.tipoChamado.nome }}</td>
          <td>{{ chamado_cliente.criticidadeChamado }}</td>
          <td>{{ chamado_cliente.dataChamado }}</td>
          <td>{{ chamado_cliente.descricaoChamado }}</td>
          <td>{{ chamado_cliente.situacaoChamado }}</td>
          <td>
            <b-button v-b-modal.solucao @click="popularModal(chamado_cliente.solucaoChamado)" variant="warning">Visualizar</b-button>
          </td>
          <td>{{ chamado_cliente.encerramentoChamado }}</td>
          <td>
            <button class="btn btn-danger" @click="deletar(chamado_cliente.id)" style="margin-bottom: 5px" hidden>
              Deletar
            </button>
            <b-button variant="outline-primary" v-b-modal.modal-1 @click="editar(chamado_cliente)">Editar Chamado</b-button>
          </td>
        </tr>
      </tbody>
    </table>
    <div>
    </div>

    <b-modal id="modal-1" title="Editar Chamado">
      <form @submit.prevent="salvar">
        <div class="mb-3 mt-3">
          <div class="row">
            <div class="col-md-6">
              <h3>Chamado Cliente</h3>
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label">Nome do Usuário</label>
              <input type="text" class="form-control" v-model="chamado_cliente.usuarioChamado.name" disabled />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput2" class="form-label">Criticidade do chamado</label>
              <br>
              <select class="form-control" v-model="chamado_cliente.criticidadeChamado">
                <option id="B">Baixo</option>
                <option id="M">Médio</option>
                <option id="A">Alto</option>
              </select>
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label">Descrição</label>
              <input type="text" class="form-control" v-model="chamado_cliente.descricaoChamado" />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label">Situação</label>
              <input type="text" class="form-control" v-model="chamado_cliente.situacaoChamado" disabled />
            </div>
          </div>
        </div>

        <button class="btn btn-success">Salvar</button>
      </form>
    </b-modal>
    <b-modal id="solucao" title="BootstrapVue">
      {{ solucao }}
    </b-modal>

  </div>
</template>
  
<script>
import Chamado_Cliente from "../services/chamado_cliente";

import Vue from 'vue'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

export default {
  name: "ChamadoClienteView",

  data() {
    return {
      chamado_clientes: [],
      chamado_cliente: {
        id: "",
        usuarioChamado: "",
        tipoChamado: "",
        criticidadeChamado: "",
        dataChamado: "",
        descricaoChamado: "",
        situacaoChamado: "",
        encerramentoChamado: "",
      },
      solucao: ""
    };
  },
  mounted() {
    this.listar();
  },
  methods: {
    listar() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;

      Chamado_Cliente.listar(token).then((resposta) => {
        const resp = resposta.data;
        const result = resp.filter(resp => resp.usuarioChamado.name === "Victor");
        this.chamado_clientes = result;
      });
    },
    deletar(id) {
      Chamado_Cliente.deletar(id).then(() => {
        this.listar();
        alert("Deletado com Sucesso");
      });
    },
    editar(chamado_cliente) {
      this.chamado_cliente = chamado_cliente;
    },
    popularModal(solucao) {
      this.solucao = solucao;
    },
    salvar() {
      console.log(this.chamado_cliente)
      Chamado_Cliente.atualizar(this.chamado_cliente).then(() => {
        alert('Atualizado com sucesso!');
        this.limparFormularios();
        this.listar();
      })
    },
    limparFormularios() {
      this.chamado_cliente.usuarioChamado = "";
      this.chamado_cliente.criticidadeChamado = "";
      this.chamado_cliente.descricaoChamado = "";
      this.chamado_cliente.situacaoChamado = "";
    }
  },
};
</script>

<style scoped>
table {
  margin-left: 50px;
  padding: 1.30rem;
  width: 90%;
  border-collapse: collapse;
  border: 1px solid black;
  text-align: center;
  table-layout: fixed;
}

td,
th {
  border: 1px solid black;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
  
  