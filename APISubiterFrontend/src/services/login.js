import axios from 'axios'

export default{

    login:(usuario)=>{
        return axios.create({
            baseURL:'http://localhost:8080/'
        }).post('/auth/signup/', usuario)
    }
}