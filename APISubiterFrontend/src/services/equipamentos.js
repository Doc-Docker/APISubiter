import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/equipamentos', {headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(equipamento, token)=>{
        return http.post('/equipamentos', equipamento,  {headers:{Authorization: `Bearer ${token}`}})
    },

    deletar:(id)=>{
        return http.delete('/equipamentos/' + id)
    },

    atualizar:(equipamento)=>{
        return http.put('/equipamentos/' + equipamento.id , equipamento)
    }
}