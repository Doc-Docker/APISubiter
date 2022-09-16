import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
// Listagens
import ListagemServicosView from '../views/ListagemServicosView.vue'
import ListagemEquipamentoView from '../views/ListagemEquipamentoView.vue'

import ListagemEmpresaView from '../views/ListagemEmpresaView.vue'
import ListagemUsuarios from '../views/ListagemUsuariosView.vue'

// Cadastros
import CadastroServicoManutencao from '../views/CadastroServicoManutencaoView.vue'
import CadastroServicoInstalacao from '../views/CadastroServicoInstalacaoView.vue'
import CadastroEquipamento from '../views/CadastroEquipamentoView.vue'

import CadastroEmpresa from '../views/CadastroEmpresaView.vue'

import CadastroUsuario from '../views/CadastroUsuarioView.vue'


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
    path: '/equipamentos',
    name: 'listagemEquipamentos',
    component: ListagemEquipamentoView
  },
  {
    path: '/empresas',
    name: 'listagemEmpresas',
    component: ListagemEmpresaView
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
  },
  {
    path: '/cadastroEquipamentos',
    name: 'cadastroEquipamentos',
    component: CadastroEquipamento
  },
  {

    path: '/cadastroEmpresas',
    name: 'cadastroEmpresas',
    component: CadastroEmpresa
  },
  {

    path: '/cadastroUsuario',
    name: 'cadastroUsuario',
    component: CadastroUsuario
  },
  {
    path: '/usuarios',
    name: 'listagemUsuarios',
    component: ListagemUsuarios

  }
]

const router = new VueRouter({
  routes
})

export default router
