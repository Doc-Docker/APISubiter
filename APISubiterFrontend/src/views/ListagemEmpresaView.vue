<template>
    <div class="empresas">
      <div class="row">
        <div class="col-md-6">
          <h3>Empresas</h3>
        </div>
      </div>
  
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
              <button class="btn" @click="editar(empresa)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>

      
  
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

  
    </div>
  </template>
  
  <script>
  import Empresa from "../services/empresas";
  
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
  
  