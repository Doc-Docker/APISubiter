<template>
  <div class="ListagemUsuario">
    <h3>Usuários</h3>
    <div class="container">
      <table class="table table-bordered" style="text-align: center">
        <thead>
          <tr style="text-align: center">
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">E-mail</th>
            <th scope="col">Empresa</th>
            <th scope="col">Tipo</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(usuario, i) in usuarios" :key="i">
            <td style="text-align: center">{{ usuario.id }}</td>
            <td>{{ usuario.name }}</td>
            <td style="text-align: center"> - </td>
            <td>{{ usuario.empresa.name }}</td>
            <td style="text-align: center"> - </td>
            <td style="text-align: center">
              <button
                style="margin-right: 20px"
                class="btn btn-primary"
                v-b-modal.modal
                @click="editar(usuario)">
                Editar
              </button>
               
              <button class="btn btn-danger" @click="deletar(usuario.id)" disabled>
                Deletar
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <br>

      <b-modal id="modal" title="Editar Usuário">
        <form @submit.prevent="salvar">
          <div class="mb-3 mt-3">
            <div class="row">
              <div class="col-md-6">
                <h3>Editar usuários</h3>
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
                <input type="text" class="form-control" />
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="row">
              <div class="col-md-6">
                <label for="exampleFormControlInput1" class="form-label">Senha</label>
                <input type="password" class="form-control" />
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="row">
              <div class="col-md-6">
                <label for="exampleFormControlInput1" class="form-label">Empresa</label>
                <select class="form-control" v-model="usuario.empresa.id" default=empresa >
                  <option v-for="empresa in empresas" v-bind:key="empresa.id" v-bind:value="empresa.id">
                    {{ empresa.name }}
                  </option>
                </select>
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="row">
              <div class="col-md-6">
                <label for="exampleFormControlInput1" class="form-label">Tipo usuário</label>
                <select class="form-control" default="" >
                  <option id="CLI">Cliente</option>
                  <option id="SUPORTE">Suporte</option>
                  <option id="ADMIN">Administrador</option>
                </select>
              </div>
            </div>
          </div>
          <button class="btn btn-success" disabled >Salvar edição</button>
        </form>
      </b-modal>
    </div>
  </div>
</template>

<script>
import Usuario from "../services/usuarios";
import Empresa from "../services/empresas";
import Vue from 'vue'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

export default {
  name: "ListagemUsuariosView",

  data() {
    return {
      usuarios: [],
      empresas: [],
      usuario: {
        nome: "",
        email: "",
        senha: "",
        empresa: "",
        tipo: "",
      },
      empresa: ""
    };
  },

  mounted() {
    this.listar();
    this.listarEmpresas();
  },

  methods: {
    listar() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Usuario.listar(token).then((resposta) => {
        this.usuarios = resposta.data;
      });
    },
    deletar(id) {
      Usuario.deletar(id).then(() => {
        this.listar();
        alert("Deletado com Sucesso");
      });
    },
    editar(usuario) {
      this.usuario = usuario;
    },
    buscarEmpresa(id) {
      Empresa.buscar(id).then((resp) => {
        this.empresa = resp.data;
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
.ListagemUsuario{
  background-color: rgb(143, 36, 36);
  background-size: cover;
  text-align: center;
  padding: 24rem;
}
table {
  background-color: rgb(214, 211, 211);
  margin-left: 50px;
  padding: 1.30rem;
  width: 90%;
  border: 2px solid black;
  border-collapse: collapse;
  text-align: center;
  table-layout: fixed;
}
</style>