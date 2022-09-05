<template>
  <div class="listagemServicos">
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Serviço de manutenção</h3>
        </div>
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
          <td>{{ servico.id }}</td>
          <td>{{ servico.tipo_servico }}</td>
          <td>{{ servico.descricao }}</td>
          <td>{{ servico.data_inclusao }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang='ts'>
import { defineComponent, onMounted, ref } from "vue";
import http from "../http/index";

export default defineComponent({
  name: "ListagemServicos",
  setup() {
    const servicos = ref([]);

    const fetchServicos = () =>
      http.get("servicos").then((response) => (servicos.value = response.data));

    onMounted(fetchServicos);

    return { servicos };
  },
});
</script>

<style scoped>
.listagemServicos {
  padding: 1.25rem;
}
</style>
