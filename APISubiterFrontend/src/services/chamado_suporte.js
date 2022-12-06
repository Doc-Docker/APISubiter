import {http} from './config'

export default{
    listar:(token) =>{
        return http.get('/chamados', {headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(suporte)=>{
        return http.post('/chamados', suporte)
    },

    deletar:(id)=>{
        return http.delete('/chamados/' + id)
    },

    atualizar:(chamado, id, token)=>{
        return http.patch('/chamados/' + id , chamado, {headers:{Authorization: `Bearer ${token}`}})
    },

    listarEquipamentosDisponiveis:(token) =>{
        return http.get('/equipamento-serie/disponivel', {headers:{Authorization: `Bearer ${token}`}})
    } ,

    salvarAgendamento:(agendamento, token)=>{
        return http.post('/agendamento', agendamento, {headers:{Authorization: `Bearer ${token}`}})
    }
}