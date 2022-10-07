import {http} from './config'

export default{
    listar:() =>{
        return http.get('/chamados')
    },

    salvar:(chamado_cliente)=>{
        return http.post('/chamados', chamado_cliente)
    },

    deletar:(id)=>{
        return http.delete('/chamados/' + id)
    },

    atualizar:(chamado_cliente)=>{
        return http.put('/chamados/' + chamado_cliente.id , chamado_cliente)
    }
}