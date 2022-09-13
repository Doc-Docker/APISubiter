<template>
  <div class="cadastroServicos">
    <div v-for="(erro, e) in erros" :key="e" class="alert alert-danger" role="alert">
      
    </div>
    <form @submit.prevent="salvar">
      <div class="mb-3 mt-3">
        <div class="row">
          <div class="col-md-6">
            <h3>Serviço de instalação</h3>
          </div>  
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label"
              >Empresa</label
            >
            <input
              type="text"
              class="form-control"
              v-model="servico.empresa"
            />
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

export default{
  name: "CadastroServicosInstalacaoView",

  data(){
    return{
        servico:{
            tipo_servico:'Instalacao',
            descricao:'',
            empresa:''
        },
        erros:[]
    }
  },
  methods:{
    salvar(){
      Servico.salvar(this.servico).then(() => {
        this.servico = {}
        alert('Salvo com sucesso')
        this.erros = []
      }).catch( e => {
        console.log(e.response.status)
      })
      
    }
  }
};
</script>