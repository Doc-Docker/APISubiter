<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Chamados</h3>
        </div>
      </div>
  
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome Usuário</th>
            <th scope="col">Data de Inicio Atendimento</th>
            <th scope="col">Descrição do Chamado</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(Chamado_Suporte, i) in Chamados_Suporte" :key="i">
            <td>{{ Chamado_Suporte.id }}</td>
            <td>{{ Chamado_Suporte.User }}</td>
            <td>{{ Chamado_Suporte.DataInicio }}</td>>
            <td>{{ Chamado_Suporte.DescriptionTask }}</td>
            <td>{{ Chamado_Suporte.SituationOrder }}</td>
            <td>{{ Chamado_Suporte.Status }}</td>
            <td>
              <button class="btn btn-danger" @click="deletar(Chamado_Suporte.id)">
                Deletar
              </button>
              <button class="btn" @click="editar(Chamado_Suporte.id)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
  
  
    <form @submit.prevent="salvar">
        <div class="mb-3 mt-3">
          <div class="row">
            <div class="col-md-6">
              <h3>Chamados</h3>
            </div>  
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Nome</label
              >
              <input
                type="text"
                class="form-control"
                v-model="Chamado_Suporte.User"
              />
            </div>
          </div>
        </div>
  
        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Situação do Chamados</label
              >
              <select v-model="Chamado_Suporte.SituationOrder" class="form-select" aria-label="Default select example" >
                <option v-for="(Chamado_Suporte, e) in Chamados_Suporte" :key="e" v-bind:value="Chamado_Suporte.id" >{{Chamado_Suporte.SituationOrder}}</option>
              </select>
            </div>
          </div>
        </div>

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Descrição</label
              >
              <textarea
                class="form-control"
                v-model="Chamado_Suporte.DescriptionTask"
                rows="3"
              ></textarea>
            </div>
          </div>
        </div>

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Aceitar Chamado</label
              >
              <select v-model="Chamado_Suporte.Status" class="form-select" aria-label="Default select example" >
                <option v-for="(Chamado_Suporte, e) in Chamados_Suporte" :key="e" v-bind:value="Chamado_Suporte.Status" >{{Chamado_Suporte.Status}}</option>
              </select>
            </div>
          </div>
        </div>

        <button>Salvar</button>
      </form>
  
    </div>
  </template>
  
  <script>
  import Chamado_Suporte from "../services/suporte.js";
  
  export default {
    name: "ListagemChamadosView",
  
    data() {
      return {
        Chamados_Suporte: [],
        Chamado_Suporte: {
          id: "",
          Nome: "",
          Descricao: "",
        },
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {
        Chamado_Suporte.listar().then((resposta) => {
          this.Chamado_Suporte = resposta.data;
        });
      },
      deletar(id) {
        Chamado_Suporte.deletar(id).then(() => {
          this.listar();
          alert("Deletado com Sucesso");
        });
      },
      editar(Chamado_Suporte) {
        this.Chamado_Suporte = Chamado_Suporte;
      },
      salvar(){
      Chamado_Suporte.atualizar(this.Chamado_Suporte).then(()=>{
        this.Chamado_Suporte = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },
    },
  };
  </script>