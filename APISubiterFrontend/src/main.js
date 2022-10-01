import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import PrimeVue from 'primevue/config'
import 'primevue/resources/primevue.min.css';
import'primeicons/primeicons.css';
import 'primevue/resources/themes/bootstrap4-light-blue/theme.css';

Vue.config.productionTip = false

new Vue({
  router,
  store,
  PrimeVue,
  render: h => h(App)
}).$mount('#app')
