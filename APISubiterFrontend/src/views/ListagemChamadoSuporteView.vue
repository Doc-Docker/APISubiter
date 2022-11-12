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
              
              <button id="btnAceitar" class="btn btn-success" @click="editar(chamado)">Aceitar</button>

              <template v-if="chamado.mostrarAgendar">
                <button class="btn btn-danger" @click="encerrar(chamado)" style="margin-right: 5px">
                  Encerrar
                </button>
                <b-button v-b-modal.modal variant="info">Editar</b-button>
                <b-button v-b-modal.modalAgendar variant="warning" style="margin-top: 5px">Agendar</b-button>
              </template>
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
                >Status</label
              >
              <input
                type="text"
                class="form-control"
                v-model=" chamado.situacaoChamado"
                disabled
              />
            </div>
          </div>
        </div>

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
      <form @submit.prevent="salvarServico">

      <h6>Data do agendamento</h6>
      <div class="mb-3">
        <div class="row">
        <div class="col-md-6">
          <br>
          <date-picker type="datetime" valueType="format" v-model="data"></date-picker>
        </div>
        </div>
      </div>

      <h6>Endereço</h6>
        <form @submit.prevent="buscarCEP">
          <div class="mb-3">
            <div class="row">
              <div class="col-md-4">
                <label for="exampleFormControlInput1" class="form-label">CEP</label>
                <input type="text" class="form-control" v-model="servico.cep" maxlength="8" />
              </div>
              <div class="col-md-2">
                <button class="btn btn-primary" style="margin-top: 31px">Buscar</button>
              </div>
            </div>
          </div>
        </form>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-9">
              <label for="exampleFormControlInput1" class="form-label">Logradouro</label>
              <input type="text" class="form-control" v-model="resultadoCEP.logradouro" disabled/>
            </div>
            <div class="col-md-3">
              <label for="exampleFormControlInput1" class="form-label">Número</label>
              <input type="text" class="form-control" v-model="servico.numero" />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <label for="exampleFormControlInput1" class="form-label">Bairro</label>
              <input type="text" class="form-control" v-model="resultadoCEP.bairro" disabled/>
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label">Cidade</label>
              <input type="text" class="form-control" v-model="resultadoCEP.localidade" disabled/>
            </div>
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label">Estado</label>
              <input type="text" class="form-control" v-model="resultadoCEP.uf" disabled/>
            </div>
          </div>
        </div>

        <br>
        <h6>Descrição do Serviço</h6>
        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <textarea
                type="text"
                class="form-control"
                v-model=" servico.descricao"
              />
            </div>
          </div>
        </div>

        <button class="btn btn-success">Salvar</button>
      </form>
      </b-modal>
  
    </div>
  </template>
  
  <script>
  import chamado from "../services/chamado_suporte.js";
  import servico from "../services/servicos.js";

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
        data: "",
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
          solucaoChamado: "",
          mostrarAgendar: false
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
        this.chamado.mostrarAgendar = true;
        document.getElementById("btnAceitar").style.display = "none";
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
      },
      salvarServico(){
        let token = JSON.parse(localStorage.getItem("authUser")).access_token;

        servico.salvar(this.servico, token).then(() => {
          alert('Atualizado com sucesso!');
          this.limparFormulariosAgendamento();
        });
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
      buscarCEP() {
        if(this.servico.cep.length === 8){
          fetch(`https://viacep.com.br/ws/${this.servico.cep}/json`)
          .then(r => r.json())
          .then(r => {
            if(r.erro){
              alert('CEP inválido');
            }else{
              this.resultadoCEP = r;
              console.log(r);
            }
          });
        }else{
          alert('CEP inválido');
        }
      }
    },
  };
  </script>