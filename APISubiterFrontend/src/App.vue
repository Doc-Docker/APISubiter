<template>
  <div>
    <CabecalhoComponent/>
    <div class="container">
      <router-view/>
    </div>
  </div>
</template>

<script>
import CabecalhoComponent from './components/CabecalhoComponent.vue'

export default {
  components:{
    CabecalhoComponent
  }
}
</script>


<style>

</style>
