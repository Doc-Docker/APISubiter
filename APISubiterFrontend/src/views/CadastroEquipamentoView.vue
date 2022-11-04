<template>
    <div class="cadastroequipamentos">
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

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Descrição</label
              >
              <input
                type="text"
                class="form-control"
                v-model="equipamento.descricao"
              />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Equipamentos Série</label
              >
              <input
                type="text"
                class="form-control"
                v-model="equipamento.equipamentoSerie.id"
              />
            </div>
          </div>
        </div>

        <button>Salvar</button>
      </form>
  
      
    </div>
  </template>
  
  <style scoped>
  .cadastroequipamentos {
    padding: 1.25rem;
  }
  </style>
  
  <script>
  import Equipamento from '../services/equipamentos'
  
  export default{
    name: "CadastroEquipamentoView",
  
    data(){
      return{
          equipamento:{
              nomeEquipamento:'',
              fabricante:'',
              descricao:'',
              equipamentoSerie:{
                id: ''

              }
          }
      }
    },
    methods:{
      salvar(){
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;

        Equipamento.salvar(this.equipamento, token).then(() => {
          alert('Salvo com sucesso')
        })
        
      }
    }
  };
  </script>