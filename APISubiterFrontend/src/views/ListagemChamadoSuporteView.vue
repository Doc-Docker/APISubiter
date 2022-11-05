<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Chamados Suporte</h3>
        </div>
      </div>

  
      <table class="table table-striped table-bordered" style="text-align: center" >
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome Usuário</th>
            <th scope="col">Data Abertura</th>
            <th scope="col">Descrição do Chamado</th>
            <th scope="col">Status</th>
            <th scope="col">Tipo de Chamado</th>
            <th scope="col">Criticidade</th>
            <th scope="col">Solução</th>
            <th scope="col">Data Encerramento</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(chamado, i) in chamados" :key="i">
            <td>{{ chamado.id }}</td>
            <td>{{ chamado.usuarioChamado.name }}</td>
            <td>{{ chamado.dataChamado }}</td>
            <td>{{ chamado.descricaoChamado }}</td>
            <td>{{ chamado.situacaoChamado }}</td>
            <td>{{ chamado.tipoChamado.nome }}</td>
            <td>{{ chamado.criticidadeChamado }}</td>
            <td>{{ chamado.solucaoChamado }}</td>
            <td>{{ chamado.encerramentoChamado }}</td>
            <td>
              <button class="btn btn-success" @click="editar(chamado)" style="margin-bottom: 5px">Aceitar</button>
              <button class="btn btn-danger" @click="encerrar(chamado)" style="margin-bottom: 5px">
                Encerrar
              </button>
              <button class="btn btn-danger" @click="deletar(chamado.id)" hidden >
                Deletar
              </button>
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
 

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Status</label
              >
              <input
                type="text"
                class="form-control"
                v-model=" chamado.situacaoChamado"
              />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Solução</label
              >
              <input
                type="text"
                class="form-control"
                v-model=" chamado.solucaoChamado"
              />
            </div>
          </div>
        </div>

        <button class="btn btn-success">Salvar</button>

      </form>
  
    </div>
  </template>
  
  <script>
  import chamado from "../services/chamado_suporte.js";
  
  export default {
    name: "ChamadoSuporteView",
  
    data() {
      return {
        chamados: [],
        chamado: {
          id: "",
          usuarioChamado: {
            id: ""
          },
          tipoChamado: {
            id: ""
          },
          assuntoChamado: "",
          descricaoChamado: "",
          criticidadeChamado: "",
          situacaoChamado: "",
          solucaoChamado: ""
        },
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;

        chamado.listar(token).then((resposta) => {
          this.chamados = resposta.data;
        });
      },
      deletar(id) {
        chamado.deletar(id).then(() => {
          this.listar();
          alert("Deletado com Sucesso");
        });
      },
      editar(chamado) {
        this.chamado = chamado;
        this.chamado.situacaoChamado = "Em andamento";
      },
      salvar(){
        console.log(this.chamado);
        chamado.atualizar(this.chamado).then(()=>{
          alert('Atualizado com sucesso!');
          this.limparFormularios();
          this.listar();
        })
      },
      encerrar(chamado) {
        this.chamado = chamado;
        var data = new Date();
        data = data.toLocaleDateString();
        this.chamado.encerramentoChamado = data;
        this.chamado.situacaoChamado = "Encerrado";
        this.salvar();
      },
      limparFormularios() {
        this.chamado.solucaoChamado = "";
        this.chamado.situacaoChamado = "";
      }
    },
  };
  </script>