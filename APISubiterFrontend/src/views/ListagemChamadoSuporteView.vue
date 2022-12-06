<template>
  <div class="ListagemChamadosSuporte">
    <h3>Chamados Suporte</h3>
    <div class="Container">
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
            <th scope="col">Local Atendimento</th>
            <th scope="col"></th>
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
            <td v-if="chamado.agendamento !== null">{{ chamado.agendamento.localAtendimento }}</td>
            <td v-else></td>
            <td>
              <b-button v-if="chamado.agendamento===null"  v-b-modal.modalAgendar  @click="populaChamado(chamado)" variant="warning" style="margin-top: 5px" >Agendar</b-button>
              
              <b-button @click="populaChamado(chamado)" v-b-modal.modal variant="info">Editar Solução</b-button>
            </td>
          </tr>
        </tbody>
      </table>
  
      <b-modal id="modal" hide-footer title="Editar chamado">
        <form @submit.prevent="salvar">
          <div class="mb-3">
            <div class="row">
              <div class="col-md-12">
                <label for="exampleFormControlTextarea1" class="form-label"
                  >Solução</label
                >
                <textarea
                  type="text"
                  class="form-control"
                  v-model=" chamado.solucaoChamado"
                />
              </div>
            </div>
          </div>
          <button class="btn btn-success">Salvar</button>
        </form>
      </b-modal>

      <b-modal id="modalAgendar" hide-footer title="Agendamento">
        <form @submit.prevent="salvarAgendamento">
          <div class="mb-3">
            <div class="row">
              <div class="col-md-6">
                <br>
                <input type="text" class="form-control" v-model="chamado.id" disabled/>
              </div>
            </div>
          </div>
        
          <h6>Data do agendamento</h6>
          <div class="mb-3">
            <div class="row">
              <div class="col-md-6">
                <br>
                <date-picker type="datetime" valueType="format" v-model="agendamento.dataHora"></date-picker>
              </div>
            </div>
          </div>

          <h6>Nome Cliente</h6>
          <div class="mb-3">
            <div class="row">
              <div class="col-md-6">
                <br>
                <input type="text" class="form-control" v-model="agendamento.pessoas"/>
              </div>
            </div>
          </div>

          <h6>Descrição do Serviço</h6>
          <div class="mb-3">
            <div class="row">
              <div class="col-md-12">
                <textarea
                  type="text"
                  class="form-control"
                  v-model=" agendamento.descricao"
                />
              </div>
            </div>
          </div>

          <h6>Local do Atendimento</h6>
          <div class="mb-3">
            <div class="row">
              <div class="col-md-12">
                <textarea
                  type="text"
                  class="form-control"
                  v-model=" agendamento.localAtendimento"
                />
              </div>
            </div>
          </div>

          <h6>Numero </h6>
          <div class="mb-3">
            <div class="row">
              <div class="col-md-12">
                <select v-model="agendamento.numerosSerie" class="form-select" aria-label="Default select example" >
                  <option v-for="(equipamento, e) in equipamentos" :key="e" v-bind:value="equipamento.id" >{{equipamento.equipamento.nomeEquipamento}}</option>
                </select>
              </div>
            </div>
          </div>
          <button class="btn btn-success">Salvar</button>
        </form>
      </b-modal>
    </div>
  </div>
</template>

<script>
import chamado from "../services/chamado_suporte.js";
import DatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';
import Vue from 'vue'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

export default {
  name: "ChamadoSuporteView",
  components: { DatePicker },

  data() {
    return {
      chamados: [],
      equipamentos:[],
      agendamento: {
        chamadoAgendamento: {
          id:""
        },
        dataHora:"",
        pessoas : "",
        descricao:"",
        localAtendimento:"",
        numerosSerie:""
      },
      chamado:{},
      chamadoDto:{
        criticidadeChamado:"",
        dataChamado:"",
        assuntoChamado:"",
        descricaoChamado:"",
        situacaoChamado:"",
        solucaoChamado:""
      },
      servico: {
        cep: "",
        numero: "",
        inclusao: null,
        descricao: "",
        empresa: {
          id: ""
        },
        tipoServico: {
          id: 1
        }
      },
      resultadoCEP: ""
    };
  },
  mounted() {
    this.listar();
    this.listarEquipamentosDisponiveis();
  },
  methods: {
    listarEquipamentosDisponiveis() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      chamado.listarEquipamentosDisponiveis(token).then((resposta) => {
        this.equipamentos = resposta.data;
      });
    },
    listar() {
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      chamado.listar(token).then((resposta) => {
        this.chamados = resposta.data;
      });
    },
    populaChamado(chamado){
      this.chamado = chamado
    },
    salvarAgendamento(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      this.formatarData();
      
      this.agendamento.chamadoAgendamento.id = this.chamado.id
      chamado.salvarAgendamento(this.agendamento, token).then(() => {
        alert('Atualizado com sucesso!');
        this.limparFormulariosAgendamento();
      });
      this.listar
    },
    formatarData(){
        let data = this.agendamento.dataHora.substring(0, 10);
        let hora = this.agendamento.dataHora.substring(11, 19);
        this.agendamento.dataHora = data + "T" + hora + ".0000000"
         
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
      this.chamado.mostrarAgendar = true;
      document.getElementById("btnAceitar").style.display = "none";
    },
    salvar(){
      let token = JSON.parse(localStorage.getItem("authUser")).access_token;
      this.chamadoDto.criticidadeChamado = this.chamado.criticidadeChamado
      this.chamadoDto.dataChamado = this.chamado.dataChamado
      this.chamadoDto.assuntoChamado = this.chamado.assuntoChamado
      this.chamadoDto.descricaoChamado = this.chamado.descricaoChamado
      this.chamadoDto.situacaoChamado = this.chamado.situacaoChamado
      this.chamadoDto.solucaoChamado = this.chamado.solucaoChamado
      chamado.atualizar(this.chamadoDto, this.chamado.id, token).then(()=>{
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
    },
    limparFormulariosAgendamento() {
      this.servico.cep = "";
      this.servico.numero = "";
      this.resultadoCEP.uf = "";
      this.resultadoCEP.localidade = "";
      this.resultadoCEP.logradouro = "";
      this.resultadoCEP.bairro = "";
      this.data = "";
      this.servico.descricao = "";
    },
  },
};
</script>

<style scoped>
.ListagemChamadosSuporte{
  background-color: rgb(143, 36, 36);
  background-size: cover;
  text-align: center;
  padding: 24rem;
}
table {
  background-color: rgb(214, 211, 211);
  /* margin-left: 50px;
  padding: 1.30rem;
  width: 90%;
  border: 2px solid black;
  border-collapse: collapse;
  text-align: center;
  table-layout: fixed; */
}
</style>