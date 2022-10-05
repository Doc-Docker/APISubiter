<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Chamado Cliente</h3>
        </div>
      </div>
  
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th scope="col">Nome do Usuário</th>
            <th scope="col">Motivo</th>
            <th scope="col">Descrição</th>
            <th scope="col">Tipo de Serviço</th>
            <th scope="col">Data de Abertura</th>
            <th scope="col">Data e Horário de Agendamento</th>
            <th scope="col">Endereço</th>
            <th scope="col">Criticidade</th>

          </tr>
        </thead>
        <tbody>
          <tr v-for="(chamado_cliente, i) in chamado_clientes" :key="i">
            <td>{{ chamado_cliente.usuarioChamado }}</td>
            <td>{{ chamado_cliente.tituloChamado }}</td>
            <td>{{ chamado_cliente.descricaoChamado }}</td>
            <td>{{ chamado_cliente.tipoChamado }}</td>
            <td>{{ chamado_cliente.dataAbertura }}</td>
            <td>{{ chamado_cliente.datahoraAgendamento }}</td>
            <td>{{ chamado_cliente.enderecoChamado }}</td>
            <td>{{ chamado_cliente.criticidadeChamado }}</td>
            <td>
              <button class="btn btn-danger" @click="deletar(chamado_cliente.id)">
                Deletar
              </button>
              <button class="btn" @click="editar(chamado_cliente)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
  
    <form @submit.prevent="salvar">
        <div class="mb-3 mt-3">
          <div class="row">
            <div class="col-md-6">
              <h3>Chamado Cliente</h3>
            </div>  
          </div>
        </div>
  
        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Nome do Usuário</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.usuarioChamado"
              />
            </div>
          </div>
        </div>
  
        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Motivo</label
              >
              <textarea
                class="form-control"
                v-model="chamado_cliente.tituloChamado"
                rows="3"
              ></textarea>
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
                v-model="chamado_cliente.descricaoChamado"
                rows="3"
              ></textarea>
            </div>
          </div>
        </div>

        <div class="mb-5">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Tipo de Serviço</label
              >
              <textarea
                class="form-control"
                v-model="chamado_cliente.tipoChamado"
                rows="3"
              ></textarea>
            </div>
          </div>
        </div>
        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Data Abertura</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.dataAbertura"
              />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Data e Hora do Agendamento</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.datahoraAgendamento"
              />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Endereço</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.enderecoChamado"
              />
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <label for="exampleFormControlInput1" class="form-label"
                >Criticidade</label
              >
              <input
                type="text"
                class="form-control"
                v-model="chamado_cliente.criticidadeChamado"
              />
            </div>
          </div>
        </div>
        <button>Salvar</button>
      </form>
  
    </div>
  </template>
  
  <script>
  import Chamado_Cliente from "../services/chamado_cliente";
  
  export default {
    name: "Listagemchamado_clienteView",
  
    data() {
      return {
        chamado_cliente: [],
        empresa: {
          id: "",
          usuarioChamado: "",
          tituloChamado: "",
          descricaoChamado: "",
          tipoChamado: "",
          dataAbertura: "",
          datahoraAgendamento: "",
          enderecoChamado: "",
          criticidadeChamado: "",
        },
      };
    },
    mounted() {
      this.listar();
    },
    methods: {
      listar() {
        Chamado_Cliente.listar().then((resposta) => {
          this.chamado_cliente = resposta.data;
        });
      },
      deletar(id) {
        Chamado_Cliente.deletar(id).then(() => {
          this.listar();
          alert("Deletado com Sucesso");
        });
      },
      editar(chamado_cliente) {
        this.chamado_cliente = chamado_cliente;
      },
      salvar(){
        Chamado_Cliente.atualizar(this.chamado_cliente).then(()=>{
        this.chamado_cliente = {}
        alert('Atualizado com sucesso!')
        this.listar()
      })
    },
    },
  };
  </script>
  
  