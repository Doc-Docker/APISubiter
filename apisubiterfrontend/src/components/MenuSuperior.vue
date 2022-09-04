<template>
  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="../assets/logo.png" alt="" width="100" height="56" />
      </a>

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
              <li><a class="dropdown-item" href="/#/cadastroServicoInstalacao">Serviço de instalação</a></li>
              <li><a class="dropdown-item" href="/#/cadastroServicoManutencao">Serviço de manutenção</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#">Equipamentos</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#">Usuários</a></li>
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
              <li><a class="dropdown-item" href="/#/listagemServicos">Serviços</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#">Equipamentos</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#">Usuários</a></li>
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
              <li><a class="dropdown-item" href="#">Novo</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#">Visualizar</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script lang='ts'>
import { defineComponent } from "vue";

export default defineComponent({
  name: "MenuSuperior",
});
</script>

<style scoped>
</style>
