import { http } from './config'

export default{
    salvar:(chamado,token)=>{
        return http.post('/chamados', chamado,  {headers:{Authorization: `Bearer ${token}`}})
    },

    listarTipoServico:(token) =>{
        return http.get('/tipo-servico', {headers:{Authorization: `Bearer ${token}`}})
    },
}