<template>
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
            >
              Cadastros
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link
                  class="dropdown-item"
                  to="/cadastroServicoInstalacao"
                  >Serviço de instalação</router-link
                >
              </li>
              <li>
                <router-link
                  class="dropdown-item"
                  to="/cadastroServicoManutencao"
                  >Serviço de manutenção</router-link
                >
              </li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#/cadastroEquipamentos">Equipamentos</a></li>
              <li><hr class="dropdown-divider" /></li>

              <li><a class="dropdown-item" href="#">Usuários</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#/cadastroEmpresas">Empresas</a></li>
              
              <li><a class="dropdown-item" href="#/cadastroUsuario">Usuários</a></li>

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
              Listagens
            </a>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="/#/servicos">Serviços</a>
              </li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#/equipamentos">Equipamentos</a></li>
              <li><hr class="dropdown-divider" /></li>

              <li><a class="dropdown-item" href="#">Usuários</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#/empresas">Empresas</a></li>

              <li><a class="dropdown-item" href="#/usuarios">Usuários</a></li>

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
              <li><a class="dropdown-item" href="#/cadastroChamado">Novo</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#">Visualizar</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>

export default {
  name: "CabecalhoComponent",
};
</script>


<style scoped>
</style>
