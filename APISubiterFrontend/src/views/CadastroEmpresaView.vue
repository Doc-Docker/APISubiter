<template>
    <div class="cadastroempresas">
      <form @submit.prevent="salvar">
        <div class="mb-3 mt-3">
          <div class="row">
            <div class="col-md-6">
              <h3>Empresas</h3>
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

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Cnpj</label
              >
              <input
                type="text"
                class="form-control"
                v-model="empresa.cnpj"
              />
            </div>
          </div>
        </div>

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Contato</label
              >
              <input
                type="text"
                class="form-control"
                v-model="empresa.contato"
              />
            </div>
          </div>
        </div>

        <button>Salvar</button>
      </form>
  
      
    </div>
  </template>
  
  <style scoped>
  .cadastroempresas {
    padding: 1.25rem;
  }
  </style>
  
  <script>
  import Empresa from '../services/empresas'
  
  export default{
    name: "CadastroEmpresaView",
  
    data(){
      return{
          empresa:{
              name:'',
              endereco:'',
              cnpj:'',
              contato:''
          }
      }
    },
    methods:{
      salvar(){
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;
        Empresa.salvar(this.empresa, token).then(() => {
          alert('Salvo com sucesso')
        })
        
      }
    }
  };
  </script>