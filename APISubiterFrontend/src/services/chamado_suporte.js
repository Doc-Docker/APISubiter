import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/chamados', {headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(suporte)=>{
        return http.post('/chamados', suporte)
    },

    deletar:(id)=>{
        return http.delete('/chamados/' + id)
    },

    atualizar:(chamado)=>{
        return http.patch('/chamados/' + chamado.id , chamado)
    }
}