import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ListagemServicosView from '../views/ListagemServicosView.vue'
import CadastroServicoManutencao from '../views/CadastroServicoManutencaoView.vue'
import CadastroServicoInstalacao from '../views/CadastroServicoInstalacaoView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/servicos',
    name: 'listagemServicos',
    component: ListagemServicosView
  },
  {
    path: '/cadastroServicoManutencao',
    name: 'cadastroServicoManutencao',
    component: CadastroServicoManutencao
  },
  {
    path: '/cadastroServicoInstalacao',
    name: 'cadastroServicoInstalacao',
    component: CadastroServicoInstalacao
  }
  
]

const router = new VueRouter({
  routes
})

export default router
