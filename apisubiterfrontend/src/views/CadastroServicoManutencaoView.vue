<template>
  <div class="cadastroServicos">
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
  name: "CadastroServicosManutencaoView",

  data(){
    return{
        servico:{
            tipo_servico:'Manutencao',
            descricao:'',
            empresa:''
        }
    }
  },
  methods:{
    salvar(){
      Servico.salvar(this.servico).then(resposta => {
        alert('Salvo com sucesso' + resposta)
      })
      
    }
  }
};
</script>