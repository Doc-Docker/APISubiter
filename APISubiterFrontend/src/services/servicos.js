import {http} from './config'

export default{
    listar:() =>{
        return http.get('/servicos')
    },

    salvar:(servico)=>{
        return http.post('/servicos', servico)
    },

    deletar:(id)=>{
        return http.delete('/servicos/' + id)
    },

    atualizar:(servico)=>{
        return http.put('/servicos/' + servico.id , servico)
    }
}