<template>
  <div class="ListagemEquipamento">
    <h3>Equipamentos</h3>
    <div class="container">
      <table class="table table-striped table-bordered" style="text-align: center">
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
              <b-button variant="outline-primary" v-b-modal.modal-1 @click="editar(equipamento)">Editar</b-button>
            </td>
          </tr>
        </tbody>
      </table>

      <b-modal id="modal-1" title="Editar Chamado">
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
      </b-modal>
    </div>
  </div>
</template>

<script>
  import Equipamento from "../services/equipamentos";
  import Vue from 'vue'
  import { BootstrapVue } from 'bootstrap-vue'
  import 'bootstrap/dist/css/bootstrap.css'
  import 'bootstrap-vue/dist/bootstrap-vue.css'

  Vue.use(BootstrapVue)

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

<style scoped>
.ListagemEquipamento{
  background-color: rgb(143, 36, 36);
  background-size: cover;
  text-align: center;
  padding: 24rem;
}
table {
  background-color: rgb(214, 211, 211);
  margin-left: 50px;
  padding: 1.30rem;
  width: 90%;
  border: 2px solid black;
  border-collapse: collapse;
  text-align: center;
  table-layout: fixed;
}
</style>