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
            <label for="exampleFormControlInput1" class="form-label"
              >Nome</label
            >
            <input type="text" class="form-control" v-model="usuario.nome" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput2" class="form-label"
              >E-mail</label
            >
            <input type="text" class="form-control" v-model="usuario.email" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label"
              >Senha</label
            >
            <input type="password" class="form-control" v-model="usuario.senha" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label"
              >Empresa</label
            >
            <select class="form-control" v-model="usuario.empresa" default="" >
              <option id="1">Subiter</option>
              <option id="2">Syndarma</option>
              <option id="3">FMM</option>
            </select>
          </div>
        </div>
      </div>


      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label"
              >Tipo usuário</label
            >
            <select class="form-control" v-model="usuario.tipo" default="" >
              <option id="CLI">Cliente</option>
              <option id="SUPORTE">Suporte</option>
              <option id="ADMIN">Administrador</option>
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

export default {
  name: "CadastroUsuarioView",

  data() {
    return {
      usuario: {
        nome: "",
        email: "",
        senha: "",
        empresa: "",
        tipo: ""
      },
    };
  },

  methods: {
    salvar(){
      Usuario.salvar(this.usuario).then(() => {
        alert('Salvo com sucesso')
      })
    }
  }
};
</script>