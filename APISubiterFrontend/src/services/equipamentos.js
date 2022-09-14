import {http} from './config'

export default{
    listar:() =>{
        return http.get('/equipamentos')
    },

    salvar:(equipamento)=>{
        return http.post('/equipamentos', equipamento)
    },

    deletar:(id)=>{
        return http.delete('/equipamentos/' + id)
    }
}