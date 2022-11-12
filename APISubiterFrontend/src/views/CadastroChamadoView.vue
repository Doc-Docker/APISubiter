<template>
  <div class="cadastroChamado">
    <div class="container">
    <div class="card">
    <form @submit.prevent="salvar">
    <div class="col-lg-12">
    <div class="p-4">
  
      <div class="font-title">
        <h3>CHAMADO</h3>
      </div>

      <div class="font-body">
        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control"  v-model="nome" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Nome do usuário</label>
              </div>
            </div>
          </div>
        </div>

        

        <div class="mb-3">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" v-model="chamado.assuntoChamado" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Título do chamado</label>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <select default="" v-model="chamado.criticidadeChamado" class="form-control" required>
                  <option id="B">Baixo</option>
                  <option id="M">Médio</option>
                  <option id="A">Alto</option>
                </select>
                <label class="form-control-placeholder" for="exampleFormControlInput2">Criticidade do chamado</label>
              </div>
              
            </div>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control" v-model="chamado.descricaoChamado" required />
                <label class="form-control-placeholder" for="exampleFormControlInput1">Descrição do chamado</label>
              </div>
            </div>
          </div>
        </div>

       
        <center><button class="btn btn-success btn-salvar">Salvar</button></center>

      </div>
      </div>
    </div>
    </form>
    </div>
    </div>
  </div>
</template>

<style scoped>
.cadastroChamado {
  padding: 5rem;
  background-color:#292A2F;
  background-size:cover
}

.card {
  position:relative;
  display:flex;
  flex-direction:column;
  min-width:0;
  word-wrap:break-word;
  background-color:#535459;
  background-clip:border-box;
  border:1px solid #535459;
  border-radius:.35rem;
  color: #F4EDED;
}

.font-title {
  font: Roboto;
  font-weight:500;
  text-align:center;
  margin-bottom: 30px
}

.font-body {
  font: Inter;
  font-weight:500
}

.container {
  min-width:992px!important
}

.btn-salvar {
  background-color: #535459;
  border: 2px solid #6CEC90;
  width: 150px;
  border-radius: 13px
}

.color {
  background-color: #838384;
  border: 1px solid #292A2F;
  border-radius: 13px
}

.form-group {
  position: relative;
  margin-bottom: 1.5rem;
}

.form-control-placeholder {
  position: absolute;
  top: 0;
  padding: 7px 0 0 10px;
  transition: all 200ms;
  opacity: 0.9;
  color: #fff;
}

.form-control:focus + .form-control-placeholder,
.form-control:valid + .form-control-placeholder {
  font-size: 100%;
  transform: translate3d(0, -100%, 0);
  opacity: 1;
  top:5px;
}

.form-control {
  border: 0;
  outline: 0;
  border-bottom: 2px solid #eee;
  font-size: 16px;
  color: #CCC;
  background-color: transparent; 
}

.form-control:focus {
  border: 0;
  color: #FFF;
  background-color: #535459;
  border-color: #FFF;
  outline: 0;
  border-bottom: 2px solid #FFF;
  box-shadow: 0 0 0 0.2rem transparent;
}
</style>

<script>

import Chamado from "../services/chamado";

export default {
  name: "CadastroUsuarioView",

  data() {
    return {
      tiposChamado: [],
      mostrar: false,
      nome: "Victor",
      data: "",
      endereco: "",
      chamado: {
        usuarioChamado: {
          id: 1
        },
        tipoChamado: {
          id: 1
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
      Chamado.listarTipoServico().then((resp) => {
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