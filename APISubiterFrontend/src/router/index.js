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
        path: '/servicos',
        component: () =>('../views/ListagemServicosView.vue')
      },
      {
        path: '/equipamentos',
        component: () =>('../views/ListagemEquipamentoView.vue')
      },
      {
        path: '/SuporteChamados',
        component: () =>('../views/ListagemChamadoSuporteView.vue')
      },
      {
        path: '/empresas',
        component: () =>('../views/ListagemEmpresaView.vue')
      },
      {
        path: '/ChamadoCliente',
        component: () =>('../views/ListagemChamadoClienteView.vue')
      },
      {
        path: '/cadastroServicoManutencao',
        component: () =>('../views/CadastroServicoManutencaoView.vue')
      },
      {
        path: '/cadastroServicoInstalacao',
        component: () =>('../views/CadastroServicoInstalacaoView.vue')
      },
      {
        path: '/cadastroEquipamentos',
        component: () =>('../views/CadastroEquipamentoView.vue')
      },
      {

        path: '/cadastroEmpresas',
        component: () =>('../views/CadastroEmpresaView.vue')
      },
      {

        path: '/cadastroUsuario',
        component: () =>('../views/CadastroUsuarioView.vue')
      },
      {
        path: '/usuarios',
        component: () =>('../views/ListagemUsuariosView.vue')

      },
      {
        path: '/cadastroChamado',
        component: () =>('../views/CadastroChamadoView.vue')
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
