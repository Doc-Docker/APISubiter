<template>
  <div class="cadastroEmpresas">
    <div class="container">
    <div class="card">
    <form @submit.prevent="salvar">
    <div class="col-lg-12">
    <div class="p-4">
  
      <div class="font-title">
        <h3>Empresa</h3>
      </div>

      <div class="font-body">
        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control"  v-model="empresa.nome" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Nome da empresa</label>
              </div>
            </div>
          </div>
        </div>

        

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" v-model="empresa.endereco" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Endereço</label>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" v-model="empresa.cnpj" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Cnpj</label>
              </div>
              
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control" v-model="empresa.contato" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Contato</label>
              </div>
            </div>
          </div>
        </div>

       
        <center><button class="btn btn-success btn-salvar">Salvar</button></center>

      </div>
      </div>
    </div>
    </form>
    </div>
    </div>
  </div>
</template>

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

<style scoped>
.cadastroEmpresas {
  padding: 5rem;
  background-color:#e63808;
  background-size:cover
}

.card {
  position:relative;
  display:flex;
  flex-direction:column;
  min-width:0;
  word-wrap:break-word;
  background-color:#ffffff;
  background-clip:border-box;
  border:1px solid #e63808;
  border-radius:.35rem;
  color: #000000;
}

.font-title {
  font: Roboto;
  font-weight:500;
  text-align:center;
  margin-bottom: 30px
}

.font-body {
  font: Inter;
  font-weight:500
}

.container {
  min-width:992px!important
}

.btn-salvar {
  background-color: #6CEC90;
  border: 2px solid #6CEC90;
  width: 150px;
  border-radius: 13px
}

.color {
  background-color: #838384;
  border: 1px solid #292A2F;
  border-radius: 13px
}

.form-group {
  position: relative;
  margin-bottom: 1.5rem;
}

.form-control-placeholder {
  position: absolute;
  top: 0;
  padding: 7px 0 0 10px;
  transition: all 200ms;
  opacity: 0.9;
  color: rgb(2, 2, 2);
}

.form-control:focus + .form-control-placeholder,
.form-control:valid + .form-control-placeholder {
  font-size: 100%;
  transform: translate3d(0, -100%, 0);
  opacity: 1;
  top:5px;
}

.form-control {
  border: 0;
  outline: 0;
  border-bottom: 2px solid rgb(255, 38, 0);
  font-size: 16px;
  color: #CCC;
  background-color: transparent; 
}

.form-control:focus {
  border: 0;
  color: #FFF;
  background-color: #e63808;
  border-color: #FFF;
  outline: 0;
  border-bottom: 2px solid #FFF;
  box-shadow: 0 0 0 0.2rem transparent;
}
</style>

