import {http} from './config'

export default{
    listar:() =>{
        return http.get('/empresas')
    },

    salvar:(empresa)=>{
        return http.post('/empresas', empresa)
    },

    deletar:(id)=>{
        return http.delete('/empresas/' + id)
    },

    buscar:(id) => {
        return http.get('/empresas/' + id)
    }
}