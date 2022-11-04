import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/empresas',{headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(empresa)=>{
        return http.post('/empresas', empresa)
    },

    deletar:(id)=>{
        return http.delete('/empresas/' + id)
    },

    buscar:(id) => {
        return http.get('/empresas/' + id)
    },
    atualizar:(empresa)=>{
        return http.put('/empresas/' + empresa.id , empresa)
    }
}