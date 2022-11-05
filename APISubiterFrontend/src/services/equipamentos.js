import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/equipamentos', {headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(equipamento, token)=>{
        return http.post('/equipamentos', equipamento,  {headers:{Authorization: `Bearer ${token}`}})
    },

    deletar:(id, token)=>{
        return http.delete('/equipamentos/' + id,  {headers:{Authorization: `Bearer ${token}`}})
    },

    atualizar:(equipamento, token)=>{
        return http.put('/equipamentos/' + equipamento.id , equipamento, {headers:{Authorization: `Bearer ${token}`}})
    }
}