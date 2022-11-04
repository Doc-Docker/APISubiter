<template>
  <div id="appView">
    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <router-link class="navbar-brand" to="/">
          <img src="../assets/logo.png" alt="" width="100" height="56" />
        </router-link>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
                v-if="this.rule ==='ROLE_ADMIN'"
              >
                Cadastros
              </a>
              <ul class="dropdown-menu">
                <!-- Rotas -->
                <li>
                  <router-link
                    class="dropdown-item"
                    to="/cadastroServicoInspecao"
                  >
                    Serviço de inspeção 
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/cadastroEquipamentos">
                    Equipamentos
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/cadastroEmpresas">
                    Empresas
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/cadastroUsuario">
                    Usuários
                  </router-link>
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
                v-if="this.rule === 'ROLE_SUPORTE' || this.rule ==='ROLE_ADMIN'"
              >
                Listagens
              </a>
              <ul class="dropdown-menu">
                <li>
                  <router-link class="dropdown-item" to="/servicos">
                    Serviços
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/equipamentos">
                    Equipamentos
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/empresas">
                    Empresas
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/usuarios">
                    Usuários
                  </router-link>
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Chamados
              </a>
              <ul class="dropdown-menu">
                <li v-if="this.rule === 'ROLE_CLIENT'">
                  <router-link class="dropdown-item" to="/cadastroChamado" >
                    Novo
                  </router-link>
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li v-if="this.rule === 'ROLE_SUPORTE' || this.rule ==='ROLE_ADMIN'">
                  <router-link class="dropdown-item" to="/SuporteChamados">
                    Chamado Suporte
                  </router-link>
                </li>
                <li v-if="this.rule === 'ROLE_CLIENT' || this.rule ==='ROLE_ADMIN'">
                  <router-link class="dropdown-item" to="/ChamadoCliente">
                    Chamado Cliente
                  </router-link>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      rule: "",
    };
  },
  methods: {
    getRule() {
      return JSON.parse(localStorage.getItem("authUser")).autorizacao;
    },
  },
  updated() {
    this.rule = this.getRule();
  },
  mounted(){
    this.rule = this.getRule()
  }
};
</script>
