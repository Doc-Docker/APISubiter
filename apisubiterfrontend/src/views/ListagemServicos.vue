<template>
  <h1>Listagem</h1>
  <div class="container text-center">
    <div class="row align-items-start">
      <div class="col">{{servicos}}</div>
    </div>
    <div class="row align-items-center">
      <div class="col">One of three columns</div>
      <div class="col">One of three columns</div>
      <div class="col">One of three columns</div>
    </div>
    <div class="row align-items-end">
      <div class="col">One of three columns</div>
      <div class="col">One of three columns</div>
      <div class="col">One of three columns</div>
    </div>
  </div>
</template>

<script lang='ts'>
import { defineComponent, onMounted, ref } from 'vue'
import http from '../http/index'

export default defineComponent({
  name: "ListagemServicos",
  setup(){
    const servicos = ref([])

    const fetchServicos =() => 
      http
        .get("servicos")
        .then((response) => (servicos.value = response.data));

    onMounted(fetchServicos);

    return {servicos};

  }
})
</script>
