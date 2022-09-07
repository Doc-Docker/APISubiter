import {http} from './config'

export default{
    listar:() =>{
        return http.get('/servicos')
    },

    salvar:(servico)=>{
        return http.post('/servicos', servico)
    }
}