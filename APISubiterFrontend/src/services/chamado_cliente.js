import {http} from './config'

export default{
    listar:() =>{
        return http.get('/chamado_cliente')
    },

    salvar:(chamado_cliente)=>{
        return http.post('/chamado_cliente', chamado_cliente)
    },

    deletar:(id)=>{
        return http.delete('/chamado_cliente/' + id)
    },

    atualizar:(chamado_cliente)=>{
        return http.put('/chamado_cliente/' + chamado_cliente.id , chamado_cliente)
    }
}