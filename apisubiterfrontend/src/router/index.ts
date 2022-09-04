import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import CadastroServicoInstalacao from '../views/CadastroServicoInstalacao.vue'
import CadastroServicoManutencao from '../views/CadastroServicoManutencao.vue'
import listagemServicos from '../views/ListagemServicos.vue'
import TelaHome from '../views/TelaHome.vue'

const rotas: RouteRecordRaw[] = [{
    path: '/',
    name: 'Home',
    component: TelaHome
},
{
    path: '/cadastroServicoInstalacao',
    name: 'cadastroServicoInstalacao',
    component: CadastroServicoInstalacao
},
{
    path: '/cadastroServicoManutencao',
    name: 'cadastroServicoManutencao',
    component: CadastroServicoManutencao
},
{
    path: '/listagemServicos',
    name: 'listagemServicos',
    component: listagemServicos
}
]

const roteador = createRouter({
    history: createWebHashHistory(),
    routes: rotas
})

export default roteador;