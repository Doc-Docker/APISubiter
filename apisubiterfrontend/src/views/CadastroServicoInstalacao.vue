<template>
  <div class="cadastroServicos">
    <div class="mb-3 mt-3">
      <div class="row">
        <div class="col-md-6">
          <h3>Serviço de instalação</h3>
        </div>  
      </div>
    </div>

    <div class="mb-3">
      <div class="row">
        <div class="col-md-6">
          <label for="exampleFormControlInput1" class="form-label"
            >Empresa</label
          >
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
          />
        </div>
        <div class="col">
          <label for="exampleFormControlInput1" class="form-label"
            >Responsavel</label
          >
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
          />
        </div>
      </div>
    </div>

    <div class="mb-3">
      <div class="row">
        <div class="col-md-5">
          <label for="exampleFormControlInput1" class="form-label"
            >Endereço</label
          >
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
          />
        </div>
        <div class="col-md-5">
          <label for="exampleFormControlInput1" class="form-label"
            >Bairro</label
          >
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
          />
        </div>
        <div class="col-md-1">
          <label for="exampleFormControlInput1" class="form-label"
            >Numero</label
          >
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
          />
        </div>
        
      </div>
    </div>

    <div class="mb-5">
      <div class="row">
        <div class="col-md-6">
          <label for="exampleFormControlTextarea1" class="form-label"
            >Descrição</label
          >
          <textarea
            class="form-control"
            id="exampleFormControlTextarea1"
            rows="3"
          ></textarea>
        </div>
      </div>
    </div>


    <button type="submit" class="btn btn-primary mb-3">Cadastrar</button>


    
  </div>
</template>

<style scoped>
.cadastroServicos {
  padding: 1.25rem;
}
</style>