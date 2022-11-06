package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import com.subiter.backend.APISubiterBackend.model.entity.Usuario;
import com.subiter.backend.APISubiterBackend.model.repository.UsuarioRepository;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaService empresaService;
    
    public Usuario save (Usuario usuario){

        usuario.setId(null);

        Empresa empresa = empresaService.getEnterpriseById(usuario.getEmpresa().getId());

        usuario.setEmpresa(empresa);

        usuarioRepository.save(usuario);

        return usuario;
    }

    public List<Usuario> getAllUsers (){
        
        return usuarioRepository.findAll();
    }
    
    public Usuario getUserById(Integer id){

        return usuarioRepository.findById(id).orElseThrow(()-> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado."));
    }

    public Usuario getUserByEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);

        return usuario;
    }
}
