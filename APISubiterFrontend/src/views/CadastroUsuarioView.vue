<template>
  <div class="cadastroUsuarios">
    <form @submit.prevent="salvar">
      <div class="mb-3 mt-3">
        <div class="row">
          <div class="col-md-6">
            <h3>Usuários</h3>
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Nome</label>
            <input type="text" class="form-control" v-model="usuario.name" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput2" class="form-label">E-mail</label>
            <input type="text" class="form-control"  v-model="usuario.email"/>
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Senha</label>
            <input type="password" class="form-control"  v-model="usuario.password"/>
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Empresa</label>
            <br>
            <select class="col-md-12" v-model="usuario.empresa.id" default="" >
              <option v-for="(empresa, e) in empresas" :key="e" v-bind:value="empresa.id" >{{empresa.name}}</option>
            </select>
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
      

      <button class="btn btn-success">Salvar</button>
    </form>
  </div>
</template>

<style scoped>
.cadastroUsuarios {
  padding: 1.25rem;
}
</style>

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