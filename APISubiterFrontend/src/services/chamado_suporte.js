import {http} from './config'

export default{
    listar:() =>{
        return http.get('/chamados')
    },

    salvar:(suporte)=>{
        return http.post('/chamados', suporte)
    },

    deletar:(id)=>{
        return http.delete('/chamados/' + id)
    },

    atualizar:(suporte)=>{
        return http.put('/chamados/' + suporte.id , suporte)
    }
}