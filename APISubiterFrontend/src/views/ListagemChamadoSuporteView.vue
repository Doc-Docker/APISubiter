<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Chamados Suporte</h3>
        </div>
      </div>

  
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome Usuário</th>
            <th scope="col">Data Abertura</th>
            <th scope="col">Descrição do Chamado</th>
            <th scope="col">Status</th>
            <th scope="col">Tipo de Chamado</th>
            <th scope="col">Criticidade</th>
            <th scope="col">Data Encerramento</th>
            <th scope="col">Solução</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(chamado_suporte, i) in chamado_suportes" :key="i">
            <td>{{ chamado_suporte.id }}</td>
            <td>{{ chamado_suporte.usuarioChamado.name }}</td>
            <td>{{ chamado_suporte.dataChamado }}</td>
            <td></td>
            <td>{{ chamado_suporte.descricaoChamado }}</td>
            <td>{{ chamado_suporte.situacaoChamado }}</td>
            <td>{{ chamado_suporte.tipoChamado.nome }}</td>
            <td>{{ chamado_suporte.criticidadeChamado }}</td>
            <td>{{ chamado_suporte.encerramentoChamado }}</td>
            <td>{{ chamado_suporte.solucaoChamado }}</td>
            <td>
              <button class="btn btn-danger" @click="deletar(chamado_suporte.id)">
                Deletar
              </button>
              <button class="btn" @click="editar(chamado_suporte)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
    
  
    <form @submit.prevent="salvar">
        <div class="mb-3 mt-3">
          <div class="row">
            <div class="col-md-6">
              <h3>Chamados</h3>
            </div>  
          </div>
        </div>
 

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Status</label
              >
              <input
                type="text"
                class="form-control"
                v-model=" chamado_suporte.situacaoChamado"
              />
            </div>
          </div>
        </div>

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Solução</label
              >
              <input
                type="text"
                class="form-control"
                v-model=" chamado_suporte.solucaoChamado"
              />
            </div>
          </div>
        </div>

          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Data Encerramento</label
              >
              <input
                type="date"
                class="form-control"
                v-model=" chamado_suporte.encerramentoChamado"
              />
            </div>
          </div>
        <br>



        <button class="btn btn-success">Salvar</button>


      </form>
  
    </div>
  </template>
  
  <script>
  import Chamado_Suporte from "../services/chamado_suporte.js";
  
  export default {
    name: "ChamadoSuporteView",
  
    data() {
      return {
        chamado_suportes: [],
        chamado_suporte: {
          id: "",
          name: "",
          dataChamado: "",
          descricaoChamado: "",
          situacaoChamado: "",
          tipoChamado: "",
          criticidadeChamado: ""
        },
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {
        Chamado_Suporte.listar().then((resposta) => {
          this.chamado_suportes = resposta.data;
        });
      },
      deletar(id) {
        Chamado_Suporte.deletar(id).then(() => {
          this.listar();
          alert("Deletado com Sucesso");
        });
      },
      editar(chamado_suporte) {
        this.chamado_suporte = chamado_suporte;
      },
      salvar(){
      Chamado_Suporte.atualizar(this.chamado_suporte).then(()=>{
        this.chamados_suportes = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },
    },
  };
  </script>