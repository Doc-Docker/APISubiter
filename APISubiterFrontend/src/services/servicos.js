import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/servico', {headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(servico, token)=>{
        return http.post('/servico', servico, {headers:{Authorization: `Bearer ${token}`}})
    },

    deletar:(id, token)=>{
        return http.delete('/servico/' + id, {headers:{Authorization: `Bearer ${token}`}})
    },

    atualizar:(servico, token)=>{
        return http.put('/servico/' + servico.id , servico, {headers:{Authorization: `Bearer ${token}`}})
    }
}