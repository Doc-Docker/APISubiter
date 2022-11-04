import Vue from 'vue'
import VueRouter from 'vue-router'
import AppView from '../views/AppView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'app',
    component: AppView,
    children: [
      {
        name: 'Home',
        path: '/',
        component: () => import('../views/HomeView.vue')
      },
      {
        path: '/login',
        component: () => import('../views/LoginView.vue')
      },
      {
        path: '/servicos',
        component: () => import('../views/ListagemServicosView.vue')
      },
      {
        path: '/equipamentos',
        component: () => import('../views/ListagemEquipamentoView.vue')
      },
      {
        path: '/SuporteChamados',
        component: () => import('../views/ListagemChamadoSuporteView.vue')
      },
      {
        path: '/empresas',
        component: () => import('../views/ListagemEmpresaView.vue')
      },
      {
        path: '/ChamadoCliente',
        component: () => import('../views/ListagemChamadoClienteView.vue')
      },
      {
        path: '/cadastroServicoInspecao',
        component: () => import('../views/CadastroServicoInspecaoView.vue')
      },
      {
        path: '/cadastroEquipamentos',
        component: () => import('../views/CadastroEquipamentoView.vue')
      },
      {
        path: '/cadastroEmpresas',
        component: () => import('../views/CadastroEmpresaView.vue')
      },
      {
        path: '/cadastroUsuario',
        component: () => import('../views/CadastroUsuarioView.vue')
      },
      {
        path: '/usuarios',
        component: () => import('../views/ListagemUsuariosView.vue')
      },
      {
        path: '/cadastroChamado',
        component: () => import('../views/CadastroChamadoView.vue')
      }
    ]
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
