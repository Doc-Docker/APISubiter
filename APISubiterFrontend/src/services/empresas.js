import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/empresas',{headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(empresa, token)=>{
        return http.post('/empresas', empresa, {headers:{Authorization: `Bearer ${token}`}})
    },

    deletar:(id, token)=>{
        return http.delete('/empresas/' + id, {headers:{Authorization: `Bearer ${token}`}})
    },

    buscar:(id) => {
        return http.get('/empresas/' + id)
    },
    atualizar:(empresa, token)=>{
        return http.put('/empresas/' + empresa.id , empresa, {headers:{Authorization: `Bearer ${token}`}})
    }
}