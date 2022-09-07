<template>
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Serviço de manutenção</h3>
        </div>
      </div>

    <table  class="table  table-striped table-bordered">
      <thead >
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Tipo de serviço</th>
          <th scope="col">Descrição</th>
          <th scope="col">Data Inclusão</th>
        </tr>
      </thead>
      <tbody >
        <tr v-for="(servico, i) in servicos" :key="i">
          <td>{{servico.id}}</td>
          <td>{{servico.tipo_servico}}</td>
          <td>{{servico.descricao}}</td>
          <td>{{servico.empresa}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Servico from '../services/servicos'

export default{
  name: "ListagemServicosView",

  data(){
    return{
        servicos:[]
    }
  },
  mounted(){
    Servico.listar().then(resposta => {
        this.servicos = resposta.data
    })
  }
};
</script>

