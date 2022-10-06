import {http} from './config'

export default{
    listar:() =>{
        return http.get('/suporte')
    },

    salvar:(suporte)=>{
        return http.post('/suporte', suporte)
    },

    deletar:(id)=>{
        return http.delete('/suporte/' + id)
    },

    atualizar:(suporte)=>{
        return http.put('/suporte/' + suporte.id , suporte)
    }
}