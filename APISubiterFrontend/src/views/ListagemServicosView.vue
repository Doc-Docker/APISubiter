<template>
  <div class="mb-3 mt-3">
    
    <table class="table table-striped table-bordered">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Tipo de serviço</th>
          <th scope="col">Descrição</th>
          <th scope="col">Empresa</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(servico, i) in servicos" :key="i">
          <td>{{ servico.id }}</td>
          <td>{{ servico.tipo_servico }}</td>
          <td>{{ servico.descricao }}</td>
          <td>{{ servico.empresa }}</td>
          <td>
            <button class="btn btn-primary m-1" @click="editar(servico)">Editar</button>

            <button class="btn btn-danger" @click="deletar(servico.id)">
              Deletar
            </button>
            
          </td>
        </tr>
      </tbody>
    </table>

  <!---->

  <form @submit.prevent="salvar">

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
      <button class="btn btn-success">Salvar</button>
    </form>

  </div>
</template>

<script>
import Servico from "../services/servicos";

export default {
  name: "ListagemServicosView",

  data() {
    return {
      servicos: [],
      servico: {
        id: "",
        tipo_servico: "",
        descricao: "",
        empresa: "",
      },
    };
  },
  mounted() {
    this.listar();
  },
  methods: {
    listar() {
      Servico.listar().then((resposta) => {
        this.servicos = resposta.data;
      });
    },
    deletar(id) {
      Servico.deletar(id).then(() => {
        this.listar();
        alert("Deletado com Sucesso");
      });
    },
    editar(servico) {
      this.servico = servico;
    },

    salvar(){
      Servico.atualizar(this.servico).then(()=>{
        this.servico = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    }
  },
};
</script>

