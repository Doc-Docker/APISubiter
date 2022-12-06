<template>
  <div class="ListagemChamadoCliente">
    <h3>Chamado Cliente</h3>
    <div class="container">
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
            <td v-if="chamado_cliente.encerramentoChamado === null">
              <b-button  @click="finalizar(chamado_cliente)">Finalizar</b-button>
            </td>
          </tr>
        </tbody>
      </table>
      <b-modal id="solucao" title="BootstrapVue">
        {{ solucao }}
      </b-modal>
    </div>
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
        criticidadeChamado: "",
        dataChamado: "",
        assuntoChamado:"",
        descricaoChamado: "",
        situacaoChamado: "F",
        solucaoChamado: "",
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
    finalizar(chamado_cliente) {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      this.chamado_cliente.criticidadeChamado = chamado_cliente.criticidadeChamado;
      this.chamado_cliente.dataChamado = chamado_cliente.dataChamado;
      this.chamado_cliente.assuntoChamado = chamado_cliente.assuntoChamado;
      this.chamado_cliente.descricaoChamado = chamado_cliente.descricaoChamado;
      this.chamado_cliente.solucaoChamado = chamado_cliente.solucaoChamado;
      Chamado_Cliente.atualizar(this.chamado_cliente, chamado_cliente.id, token).then(()=>{
          alert('Atualizado com sucesso!');
          this.limparFormularios();
          this.listar();
        })
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
.ListagemChamadoCliente{
  background-color: rgb(143, 36, 36);
  background-size: cover;
  text-align: right;
  padding: 24rem;
}
table {
  background-color: rgb(214, 211, 211);
  /* margin-left: 50px;
  padding: 1.30rem;
  width: 90%;
  border-collapse: collapse;
  border: 2px solid black;
  text-align: center;
  table-layout: fixed; */
}
td,
th {
  border: 1px solid black;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>