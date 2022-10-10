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

    atualizar:(chamado)=>{
        return http.patch('/chamados/' + chamado.id , chamado)
    }
}