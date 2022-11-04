<template>
  <div>

    <head>
      <meta charset="utf-8">
    </head>

    <body>
      <form class="box">
        <center><img src="../assets/logo.png" alt="" width="200" height="110" /></center>

        <input type="text" name="" id="email" placeholder="E-mail" v-model="form.email">

        <input type="password" name="" id="password" placeholder="Password" v-model="form.senha">

        <button id="btn" type="button" class="btn btn-primary" @click="login">
          Entrar
        </button>
      </form>
    </body>
  </div>
</template>
  
<script>
import axios from "axios";

export default {
  data() {
    return {
      form: {
        email: "",
        senha: "",
      },
      dados: ""
    };
  },
  methods: {
    login() {
      var qs = require("qs");
      let self = this
      axios
        .post(
          "http://localhost:8080/auth/login",
          qs.stringify({ email: this.form.email, password: this.form.senha }),
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
        .then(function (response) {


          localStorage.setItem('authUser', JSON.stringify(response.data))


          self.$router.push({ name: 'Home' })

        });
    },
  },
};
</script>

<style scoped>
body {
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica, sans-serif;
  background: radial-gradient(#e63808, #f3eb00);
  height: 100vh;
  overflow: hidden;
}

.box {
  width: 400px;
  padding: 40px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: #fcfcfc;
  text-align: center;
  border-radius: 25px;
}

.box h1 {
  color: white;
  text-transform: uppercase;
  font-weight: 500;
}

.box input[type="text"],
.box input[type="password"] {
  border: 0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #e63808;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: rgb(0, 0, 0);
  border-radius: 24px;
  transition: 0.25s;
}

.box input[type="text"]:focus,
.box input[type="password"]:focus {
  width: 280px;
  border-color: #f3eb00;
}

.box button[type="button"] {
  border: 0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #f3eb00;
  padding: 14px 40px;
  outline: none;
  color: rgb(3, 3, 3);
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}

.box button[type="button"]:hover {
  background: #2ecc71;
  border-color: #2ecc71
}
</style>