<template>
  <div class="cadastroChamado">
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
            <label for="exampleFormControlInput1" class="form-label">Nome do usuário</label>
            <input type="text" class="form-control" v-model="nome" disabled />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Título do chamado</label>
            <input type="text" class="form-control" v-model="chamado.assuntoChamado" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Descrição do chamado</label>
            <textarea class="form-control" v-model="chamado.descricaoChamado" ></textarea>
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput2" class="form-label">Criticidade do chamado</label>
            <br>
            <select default="" v-model="chamado.criticidadeChamado" class="form-control">
              <option id="B">Baixo</option>
              <option id="M">Médio</option>
              <option id="A">Alto</option>
            </select>
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Tipo do chamado</label>
            <select class="form-control" v-model="chamado.tipoChamado.id" default="" @change="mostrarAgendamento()" >
              <option v-for="tipo in tiposChamado" v-bind:key="tipo.id" v-bind:value="tipo.id">
                {{ tipo.nome }}
              </option>
            </select>
          </div>
        </div>
      </div>

        <template v-if="mostrar">
            <div class="mb-3">
                <div class="row">
                <div class="col-md-6">
                    <label for="exampleFormControlInput1" class="form-label">Data</label>
                    <br>
                    <date-picker type="datetime" valueType="format" v-model="data"></date-picker>
                </div>
                </div>
            </div>

            <div class="mb-3">
                <div class="row">
                <div class="col-md-6">
                    <label for="exampleFormControlInput1" class="form-label">Endereço</label>
                    <textarea class="form-control" v-model="endereco"></textarea>
                </div>
                </div>
            </div>
        </template>

      <button class="btn btn-success">Salvar</button>
    </form>
  </div>
</template>

<style scoped>
.cadastroChamado {
  padding: 1.25rem;
}
</style>

<script>

import Chamado from "../services/chamado";

import DatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';

export default {
  name: "CadastroUsuarioView",

  components: { DatePicker },

  data() {
    return {
      tiposChamado: [],
      mostrar: false,
      nome: "usuario.cliente",
      data: "",
      endereco: "",
      chamado: {
        usuarioChamado: {
          id: 1
        },
        tipoChamado: {
          id: ""
        },
        assuntoChamado: "",
        descricaoChamado: "",
        criticidadeChamado: "",
        situacaoChamado: "A",
        solucaoChamado: "Ainda não possui solução"
      }
    };
  },

  mounted() {
    this.listarTiposChamado();
  },

  methods: {
    salvar(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Chamado.salvar(this.chamado, token).then(() => {
        alert('Salvo com sucesso');
        this.limparFormularios();
      });
    },

    mostrarAgendamento(){
      if(this.chamado.tipoChamado.id === 1 || this.chamado.tipoChamado.id === 2){
        this.mostrar = true
      }else{
        this.mostrar = false
      }
    },

    listarTiposChamado(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      Chamado.listarTipoServico(token).then((resp) => {
        this.tiposChamado = resp.data;
      })
    },

    limparFormularios() {
      this.chamado.descricaoChamado = "";
      this.chamado.assuntoChamado = "";
      this.data = "";
      this.endereco = "";
      this.chamado.criticidadeChamado = "";
      this.chamado.tipoChamado = "";
    }
    
  }
};
</script>