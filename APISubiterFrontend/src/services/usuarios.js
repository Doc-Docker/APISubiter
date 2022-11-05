import { http } from './config'

export default{
    listar:(token) =>{
        return http.get('/usuarios', {headers:{Authorization: `Bearer ${token}`}})
    },

    salvar:(usuario, token, tipoUsuario)=>{
        return http.post('/usuarios/auth/signup/' + tipoUsuario, usuario, {headers:{Authorization: `Bearer ${token}`}})
    },

    deletar:(id)=>{
        return http.delete('/usuarios/' + id)
    }
}