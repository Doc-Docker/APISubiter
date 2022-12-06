<template>
  <div class="ListagemEmpresas">
    <h3>Empresas</h3>
      <div class="container">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Nome</th>
              <th scope="col">Endereço</th>
              <th scope="col">CNPJ</th>
              <th scope="col">Contato</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(empresa, i) in empresas" :key="i">
              <td>{{ empresa.id }}</td>
              <td>{{ empresa.name }}</td>
              <td>{{ empresa.endereco }}</td>
              <td>{{ empresa.cnpj }}</td>
              <td>{{ empresa.contato }}</td>
              <td>
                <button class="btn btn-danger" @click="deletar(empresa.id)">
                  Deletar
                </button>
                <b-button variant="outline-primary" v-b-modal.modal @click="editar(empresa)">Editar</b-button>
              </td>
            </tr>
          </tbody>
        </table>

        <b-modal id="modal" title="Editar Empresa">
          <form @submit.prevent="salvar">
            <div class="mb-3 mt-3">
              <div class="row">
                <div class="col-md-6">
                  <h3>empresas</h3>
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
                    v-model="empresa.name"
                  />
                </div>
              </div>
            </div>
      
            <div class="mb-5">
              <div class="row">
                <div class="col-md-6">
                  <label for="exampleFormControlTextarea1" class="form-label"
                    >Endereço</label
                  >
                  <textarea
                    class="form-control"
                    v-model="empresa.endereco"
                    rows="3"
                  ></textarea>
                </div>
              </div>
            </div>

            <div class="mb-5">
              <div class="row">
                <div class="col-md-6">
                  <label for="exampleFormControlTextarea1" class="form-label"
                    >Cnpj</label
                  >
                  <textarea
                    class="form-control"
                    v-model="empresa.cnpj"
                    rows="3"
                  ></textarea>
                </div>
              </div>
            </div>

            <div class="mb-5">
              <div class="row">
                <div class="col-md-6">
                  <label for="exampleFormControlTextarea1" class="form-label"
                    >Contato</label
                  >
                  <textarea
                    class="form-control"
                    v-model="empresa.contato"
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
  import Empresa from "../services/empresas";
  import Vue from 'vue'
  import { BootstrapVue } from 'bootstrap-vue'
  import 'bootstrap/dist/css/bootstrap.css'
  import 'bootstrap-vue/dist/bootstrap-vue.css'

  Vue.use(BootstrapVue)

  export default {
    name: "ListagemempresasView",
  
    data() {
      return {
        empresas: [],
        empresa: {
          id: "",
          name: "",
          endereco: "",
          cnpj: "",
          contato: "",
        },
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;


        Empresa.listar(token).then((resposta) => {
          this.empresas = resposta.data;
        });
      },
      deletar(id) {
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;

        Empresa.deletar(id, token).then(() => {
          this.listar();
          alert("Deletado com Sucesso");
        });
      },
      editar(empresa) {
        this.empresa = empresa;
      },
      salvar(){
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;
        Empresa.atualizar(this.empresa, token).then(()=>{
        this.empresa = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },
    },
  };
  </script>
  
<style scoped>
  .ListagemEmpresas{
  background-color: rgb(143, 36, 36);
  background-size: cover;
  text-align: center;
  padding: 24rem;
}

table {
  background-color: rgb(214, 211, 211);

}
</style>
  