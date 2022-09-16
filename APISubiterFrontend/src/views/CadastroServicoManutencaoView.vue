<template>
  <div class="cadastroServicos">
    <form @submit.prevent="salvar">
      <div class="mb-3 mt-3">
        <div class="row">
          <div class="col-md-6">
            <h3>Serviço de manutenção</h3>
          </div>  
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlTextarea1" class="form-label"
              >Id Serviço</label
            >
            <input
              class="form-control"
              type="text"
              v-model="servico.tipoServico"
              disabled
            >
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
              <option v-for="(empresa, e) in empresas" :key="e" v-bind:value="empresa.id" >{{empresa.name}}</option>
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
        tipoServico: "3",
        descricao: "",
        empresaServico: ""
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
      Servico.salvar(this.servico).then(() => {
        alert('Salvo com sucesso')
        
        this.servico = {}
        this.servico.tipoServico = 3;
      })
      
    },
    listarEmpresas() {
      Empresa.listar().then((resposta) => {
        this.empresas = resposta.data;
      });
    }
  }
};
</script>