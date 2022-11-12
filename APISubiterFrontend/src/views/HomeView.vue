<template>
  <div class="font-title">
    <button class="btn btn-secondary top" @click="sair()">Sair</button>
    <h3 style="text-align:center">Seja bem-vindo!</h3>
  </div>
</template>

<style scoped>
  .font-title {
    font: Roboto;
    font-weight:500;
    margin-bottom: 30px;
    margin-top: 30px;
  }

  .top {
    margin-top: 5px;
    margin-left: 20px;
  }
</style>

<script>
import router from '../router'

export default {
  name: 'HomeView',

  methods: {
    sair(){
      router.push("/login");
    },
  }
}
</script>
