import { http } from './config'

export default{
    salvar:(chamado)=>{
        return http.post('/chamados', chamado)
    }
}