<template>
  <div class="cadastroUsuarios">
    <div class="container">
    <div class="card">
    <form @submit.prevent="salvar">
    <div class="col-lg-12">
    <div class="p-4">
  
      <div class="font-title">
        <h3>Usuários</h3>
      </div>

      <div class="font-body">
        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control"  v-model="usuario.name" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Nome</label>
              </div>
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" v-model="usuario.email" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">E-mail</label>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" v-model="usuario.password" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Senha</label>
              </div>
              
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <select class="form-control" required v-model="usuario.empresa.id" default="">
                  <option v-for="(empresa, e) in empresas" :key="e" v-bind:value="empresa.id" >{{empresa.name}}</option>
                </select>
                <label class="form-control-placeholder" for="exampleFormControlInput1">Empresa</label>
              </div>
            </div>
          </div>
        </div>

        <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Tipo usuário</label>
            <select class="form-control" v-model="tipoUsuario" default="" >
              <option id="SUPORTE">suporte</option>
              <option id="ADMIN">client</option>
            </select>
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

import Usuario from "../services/usuarios";
import Empresa from "../services/empresas";

export default {
  name: "CadastroUsuarioView",

  data() {
    return {
      empresas: [],
      usuario: {
        name: "",
        email:"",
        password:"",
        empresa: {
          "id" : ""
        }
      },
      tipoUsuario:""
    };
  },

  mounted() {
    this.listarEmpresas();
  },

  methods: {
    salvar(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Usuario.salvar(this.usuario, token, this.tipoUsuario).then(() => {
        alert('Salvo com sucesso')
      });
    },

    listarEmpresas(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Empresa.listar(token).then((resp) => {
        this.empresas = resp.data;
      })
    }
  }
};
</script>

<style scoped>
.cadastroUsuarios {
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

