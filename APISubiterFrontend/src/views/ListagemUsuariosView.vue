<template>
  <div class="mb-3 mt-3">
    <div class="row">
      <div class="col-md-6">
        <h3>Usuários</h3>
      </div>
    </div>

    <table class="table table-bordered">
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
          <td>{{ usuario.id }}</td>
          <td>{{ usuario.nome }}</td>
          <td>{{ usuario.email }}</td>
          <td>{{ usuario.empresa }}</td>
          <td>{{ usuario.tipo }}</td>
          <td style="text-align: center">
            <button
              style="margin-right: 20px"
              class="btn btn-primary"
              @click="editar(usuario)"
            >
              Editar
            </button>
            <button class="btn btn-danger" @click="deletar(usuario.id)">
              Deletar
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Usuario from "../services/usuarios";

export default {
  name: "ListagemUsuariosView",

  data() {
    return {
      usuarios: [],
      usuario: {
        nome: "",
        email: "",
        senha: "",
        empresa: "",
        tipo: "",
      },
    };
  },

  mounted() {
    this.listar();
  },

  methods: {
    listar() {
      Usuario.listar().then((resposta) => {
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
  },
};
</script>
