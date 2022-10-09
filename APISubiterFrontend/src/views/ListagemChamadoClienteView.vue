<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Chamado Cliente</h3>
        </div>
      </div>
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th scope="col">#ID</th>
            <th scope="col">Nome do Usuário</th>
            <th scope="col">Tipo de Chamado</th>
            <th scope="col">Criticidade</th>
            <th scope="col">Data de Chamado</th>
            <th scope="col">Descrição</th>
            <th scope="col">Situação Chamado</th>
            <th scope="col">Solução</th>
            <th scope="col">Encerramento</th>

          </tr>
        </thead>
        <tbody>
          <tr v-for="(chamado_cliente, i) in chamado_clientes" :key="i">
            <td>{{ chamado_cliente.id }}</td>
            <td>{{ chamado_cliente.usuarioChamado.name }}</td>
            <td>{{ chamado_cliente.tipoChamado.nome }}</td>
            <td>{{ chamado_cliente.criticidadeChamado }}</td>
            <td>{{ chamado_cliente.dataChamado }}</td>
            <td>{{ chamado_cliente.descricaoChamado }}</td>
            <td>{{ chamado_cliente.situacaoChamado }}</td>
            <td>{{ chamado_cliente.solucaoChamado }}</td>
            <td>{{ chamado_cliente.encerramentoChamado }}</td>
            <td>
              <button class="btn btn-danger" @click="deletar(chamado_cliente.id)">
                Deletar
              </button>
              <button class="btn" @click="editar(chamado_cliente)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
    <div>
    </div>
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
              <label for="exampleFormControlInput1" class="form-label"
                >Nome do Usuário</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.usuarioChamado.name"
              />
            </div>
          </div>
        </div>

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
            <label for="exampleFormControlInput2" class="form-label">Criticidade do chamado</label>
            <br>
            <select class="col-md-12"  v-model="chamado_cliente.criticidadeChamado">
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
              <label for="exampleFormControlInput1" class="form-label"
                >Descrição</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.descricaoChamado"
              />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Situação</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.situacaoChamado"
              />
            </div>
          </div>
        </div>
        

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Encerramento</label
              >
              <input
                type="date"
                class="form-control"
                v-model="chamado_cliente.encerramentoChamado"
              />
            </div>
          </div>
        </div>
        <button>Salvar</button>
      </form>
  
    </div>
  </template>
  
  <script>
  import Chamado_Cliente from "../services/chamado_cliente";
  
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
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {
        Chamado_Cliente.listar().then((resposta) => {
          this.chamado_clientes = resposta.data;
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
      salvar(){
        console.log(this.chamado_cliente)
        Chamado_Cliente.atualizar(this.chamado_cliente).then(()=>{
        this.chamado_cliente = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },
    },
  };
  </script>
  
  