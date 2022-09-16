import {http} from './config'

export default{
    listar:() =>{
        return http.get('/servico')
    },

    salvar:(servico)=>{
        return http.post('/servico', servico)
    },

    deletar:(id)=>{
        return http.delete('/servico/' + id)
    },

    atualizar:(servico)=>{
        return http.put('/servico/' + servico.id , servico)
    }
}