<template>
    <form @submit.prevent="auth">
      <img
        alt="logo"
        src="../assets/logo.png"
      >
      <h4>
        
      </h4>
      <div class="card">
        <h2>Login</h2>
        <div class="form-group">
          <BaseInput
            v-model="email"
            type="text"
            class="form-control"
            placeholder="Usuário"
            :required="true"
            :autofocus="true"
          />
  
          <BaseInput
            v-model="password"
            type="password"
            class="form-control"
            placeholder="Senha"
            :required="true"
            :autofocus="true"
          />
        </div>
        <button
          class="btn btn-lg btn-primary btn-block"
          type="submit"
        >
          Ok
        </button>
      </div>
    </form>
  </template>
  
  <script>
  import { mapActions } from "vuex";
  
  export default {
      name: "ViewLogin",
      data() {
          return {
              email: '',
              password: '',
          };
      },
      methods: {
          ...mapActions(["login"]),
          auth() {
              this.login({ email: this.email, password: this.password });
          },
      }
  };
  </script>
  
  <style scoped>
      h2
      {
          font-family: "Inter";
          font-weight: 500;
          font-size: 30px;
          line-height: 40px;
      }
      h4
      {
          font-family: "Inter";
          max-width: 300px;
          font-size: 24px;
          line-height: 22px;
      }
      form
      {
          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;
      }
      img
      {
          margin: 50px 0px;
          
      }
      .card
      {
          margin-top: 10px;
          padding: 10px;
          display: flex;
          justify-content: space-around;
          max-width: auto;
      }
      .form-control
      {
          margin-bottom: 15px
      }
  </style>