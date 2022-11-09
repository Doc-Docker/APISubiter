import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/chamados',{headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(chamado_cliente, token)=>{
        return http.post('/chamados', chamado_cliente, {headers:{Authorization: `Bearer ${token}`}})
    },

    deletar:(id)=>{
        return http.delete('/chamados/' + id)
    },

    atualizar:(chamado_cliente)=>{
        return http.patch('/chamados/' + chamado_cliente.id , chamado_cliente)
    }
}