<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Equipamentos</h3>
        </div>
      </div>
  
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">Fabricante</th>
            <th scope="col">Descrição</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(equipamento, i) in equipamentos" :key="i">
            <td>{{ equipamento.id }}</td>
            <td>{{ equipamento.nomeEquipamento }}</td>
            <td>{{ equipamento.fabricante }}</td>
            <td>{{ equipamento.descricao }}</td>
            <td>
              <button class="btn btn-danger" @click="deletar(equipamento.id)">
                Deletar
              </button>
              <button class="btn" @click="editar(equipamento)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
  
  
    <form @submit.prevent="salvar">
        <div class="mb-3 mt-3">
          <div class="row">
            <div class="col-md-6">
              <h3>Equipamentos</h3>
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
                v-model="equipamento.nomeEquipamento"
              />
            </div>
          </div>
        </div>
  
  
        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Fabricante</label
              >
              <textarea
                class="form-control"
                v-model="equipamento.fabricante"
                rows="3"
              ></textarea>
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
                v-model="equipamento.descricao"
                rows="3"
              ></textarea>
            </div>
          </div>
        </div>
        <button>Salvar</button>
      </form>
  
    </div>
  </template>
  
  <script>
  import Equipamento from "../services/equipamentos";
  
  export default {
    name: "ListagemequipamentosView",
  
    data() {
      return {
        equipamentos: [],
        equipamento: {
          id: "",
          nome: "",
          fabricante: "",
          descricao: "",
        },
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {

        let token = JSON.parse(localStorage.getItem("authUser")).access_token;

        Equipamento.listar(token).then((resposta) => {
          this.equipamentos = resposta.data;
        });
      },
      deletar(id) {
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;

        Equipamento.deletar(id, token).then(() => {
          this.listar();
          alert("Deletado com Sucesso");
        });
      },
      editar(equipamento) {
        this.equipamento = equipamento;
      },
      salvar(){
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Equipamento.atualizar(this.equipamento, token).then(()=>{
        this.equipamento = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },

    },
  };
  </script>
  
  