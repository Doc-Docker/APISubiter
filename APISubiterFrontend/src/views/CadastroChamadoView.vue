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
            <input type="text" class="form-control" v-model="chamado.nomeUsu" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Título do chamado</label>
            <input type="text" class="form-control" v-model="chamado.titulo" />
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput1" class="form-label">Descrição do chamado</label>
            <textarea class="form-control" v-model="chamado.descricao" ></textarea>
          </div>
        </div>
      </div>

      <div class="mb-3">
        <div class="row">
          <div class="col-md-6">
            <label for="exampleFormControlInput2" class="form-label">Criticidade do chamado</label>
            <select class="form-control" default="" v-model="chamado.criticidade" >
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
            <label for="exampleFormControlInput2" class="form-label">Tipo do chamado</label>
            <select class="form-control" default="" v-model="chamado.tipo" @change="mostrarAgendamento()" >
              <option id="INSTAL" value="INSTAL" >Instalação</option>
              <option id="MANUT" value="MANUT" >Manutenção</option>
              <option id="SUPORT" value="SUPORT" >Suporte</option>
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
                    <date-picker type="datetime" valueType="format"></date-picker>
                </div>
                </div>
            </div>

            <div class="mb-3">
                <div class="row">
                <div class="col-md-6">
                    <label for="exampleFormControlInput1" class="form-label">Endereço</label>
                    <textarea class="form-control" ></textarea>
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

import DatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';

export default {
  name: "CadastroUsuarioView",

  components: { DatePicker },

  data() {
    return {
      mostrar: false,
      chamado: {
        usuarioChamado: "",
        tipoChamado: "",
        tituloChamado: "",
        descricaoChamado: "",
        criticidadeChamado: "",
        situacaoChamado: "A"
      }
    };
  },

  methods: {
    salvar(){
      console.log(this.chamado);
    },

    mostrarAgendamento(){
      if(this.chamado.tipo === 'INSTAL' || this.chamado.tipo === 'MANUT'){
        this.mostrar = true
      }else{
        this.mostrar = false
      }
    }
    
  }
};
</script>