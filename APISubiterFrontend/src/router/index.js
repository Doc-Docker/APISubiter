import Vue from 'vue'
import VueRouter from 'vue-router'
import AppView from '../views/AppView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/Home',
    name: 'app',
    component: AppView,
    children: [
      {
        name: 'Home',
        path: '/Home',
        component: () => import('../views/HomeView.vue')
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
        path: '/empresas',
        component: () => import('../views/ListagemEmpresaView.vue')
      },
      {
        path: '/usuarios',
        component: () => import('../views/ListagemUsuariosView.vue')
      },
      {
        path: '/SuporteChamados',
        component: () => import('../views/ListagemChamadoSuporteView.vue')
      },
      {
        path: '/ChamadoCliente',
        component: () => import('../views/ListagemChamadoClienteView.vue')
      },
      {
        path: '/cadastroServicoManutencao',
        component: () => import('../views/CadastroServicoManutencaoView.vue')
      },
      {
        path: '/cadastroServicoInstalacao',
        component: () => import('../views/CadastroServicoInstalacaoView.vue')
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
        path: '/cadastroChamado',
        component: () => import('../views/CadastroChamadoView.vue')
      }
    ]
  },
  {
    path: '/',
    component: () => import('../views/LoginView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
