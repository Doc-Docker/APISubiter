<template>
  <div class="cadastroServicos">
    <form @submit.prevent="salvar">
      <div class="mb-3 mt-3">
        <div class="row">
          <div class="col-md-6">
            <h3>Serviço de inspeção</h3>
          </div>  
        </div>
      </div>



      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label"
              >Empresa</label
            >
            <select v-model="servico.empresaServico" class="form-select" aria-label="Default select example" >
              <option v-for="(empresa, e) in empresas" :key="e" v-bind:value="empresa" >{{empresa.name}}</option>
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
              v-model="servico.descricao"
              rows="3"
            ></textarea>
          </div>
        </div>
      </div>
      <button>Salvar</button>
    </form>
    
  </div>
</template>

<style scoped>
.cadastroServicos {
  padding: 1.25rem;
}
</style>

<script>
import Servico from '../services/servicos'
import Empresa from "../services/empresas";

export default{
  name: "CadastroServicosManutencaoView",

  data(){
    return{
        servico: {
        tipoServico: {
          id:"1"
        },
        descricao: "",
        empresaServico: {
          id:""
        }
      },
      TiposServicos:[],
      empresas: [],
      erros: []
    }
  },
  mounted() {
    this.listarEmpresas();
  },
  methods:{
    salvar(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;

      Servico.salvar(this.servico, token).then(() => {
        alert('Salvo com sucesso')
        

      })
      
    },
    listarEmpresas() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Empresa.listar(token).then((resposta) => {
        this.empresas = resposta.data;
      });
    }
  }
};
</script>