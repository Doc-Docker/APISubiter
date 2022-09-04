<template>
  <main>
    <div class="container">
      <MenuSuperior/>
      <router-view></router-view>
    </div>
  </main>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import MenuSuperior from './components/MenuSuperior.vue'

export default defineComponent({
  name: "App",
  components: {
    MenuSuperior
  },
});
</script>

<style>
</style>
