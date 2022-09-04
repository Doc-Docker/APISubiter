import { createApp } from 'vue'
import App from './App.vue'
import roteador from './router'

createApp(App)
    .use(roteador)
    .mount('#app')
