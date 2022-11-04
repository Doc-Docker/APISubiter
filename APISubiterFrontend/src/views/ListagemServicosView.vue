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
          <td>{{ servico.tipoServico.nome }}</td>
          <td>{{ servico.descricao }}</td>
          <td>{{ servico.empresaServico.name }}</td>
          <td>
            <button class="btn btn-primary m-1" @click="editar(servico, servico.empresaServico.name)">Editar</button>

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
             <select v-model="servico.empresaServico.name" class="form-select" aria-label="Default select example" >
              <option v-for="(empresa, e) in empresas" :key="e" v-bind:value="empresa.name" >{{empresa.name}}</option>
            </select>
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
import Empresa from "../services/empresas";


export default {
  name: "ListagemServicosView",

  data() {
    return {
      servicos: [],
      empresas: [],
      servico: {
        id:"",
        tipoServico: {},
        descricao: "",
        empresaServico: {}
      },
      servicoDto: {
        id:"",
        descricao: "",
        empresaServico: {
          id:""
        },
        tipoServico: {
          id:""
        }
      },
    };
  },
  mounted() {
    this.listar();
    this.listarEmpresas();
  },
  methods: {
    listar() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;

      Servico.listar(token).then((resposta) => {
        this.servicos = resposta.data;

        console.log(token)
      });
    },
    deletar(id) {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Servico.deletar(id, token).then(() => {
        this.listar();
        alert("Deletado com Sucesso");
      });
    },
    editar(servico, nomeEmpresaServico) {
      this.servico = servico;

      this.servico.empresaServico.name = nomeEmpresaServico;
    },
  
    salvar(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      this.servicoDto.id = this.servico.id
      this.servicoDto.descricao = this.servico.descricao
      this.servicoDto.empresaServico.id = this.servico.empresaServico.id
      this.servicoDto.tipoServico.id = this.servico.tipoServico.id

      if(this.servico.tipoServico == 'Manutenção'){
        this.servico.tipoServico.id = 3
      }
      else if(this.servico.tipoServico == 'Instalação'){
        this.servico.tipoServico.id = 2
      }
      Servico.atualizar(this.servicoDto, token).then(()=>{
        this.servico = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },

    listarEmpresas() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Empresa.listar(token).then((resposta) => {
        this.empresas = resposta.data;
      });
    }
  },
};
</script>

