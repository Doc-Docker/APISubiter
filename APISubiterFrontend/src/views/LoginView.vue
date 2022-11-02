<template>
  <div class="container">
    <form>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" v-model="form.email">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="password" v-model="form.senha">
  </div>
  <button type="button" class="btn btn-primary" @click="login">Entrar</button>
</form>
  </div>
  </template>
  
  <script>
    import axios from 'axios'

    export default{
      data(){
        return{
          form:{
            email:"",
            senha:""
          },
          dados:{

          }
        }
      },
      methods:{
        login(){
          var qs = require('qs');


          axios.post('http://localhost:8080/auth/login',  qs.stringify({'email': 'admin@gmail.com', 'password':'admin'}),
          {
      headers: { 
        "Content-Type": "application/x-www-form-urlencoded"
      }
    }).then(function(response) {
        console.log(response);
    });
        }
      }
    }
  </script>
