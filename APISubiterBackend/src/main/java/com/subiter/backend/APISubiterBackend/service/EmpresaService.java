package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import com.subiter.backend.APISubiterBackend.model.repository.EmpresaRepository;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa) {
        empresa.setId(null);
        return empresaRepository.save(empresa);
    }

<<<<<<< HEAD
//    public List<Empresa> getAllEnterprises() {
//
//        return empresaRepository.findAll();
//    }
=======
    public List<Empresa> getAllEnterprises (Boolean status){
        
        List<Empresa> empresas = empresaRepository.findByStatus(status);
        
        return  empresas;
    }
    
    
    public Empresa getEnterpriseById(Integer id){
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1

    public List<Empresa> getAllEnterprises(Boolean status, Integer id) {

<<<<<<< HEAD
     
        List<Empresa> empresas = empresaRepository.findByStatusAndId(status, id);

        return empresas;
=======
    	empresa.setCnpj(empresaNova.getCnpj());
    	empresa.setContato(empresaNova.getContato());
    	empresa.setEndereco(empresaNova.getEndereco());
    	empresa.setName(empresaNova.getName());
    	
    	return empresaRepository.save(empresa);
    }
    
    public void arquivaEmpresaById(Integer id, Boolean status){
        Empresa empresa = this.getEnterpriseById(id);
        empresa.setStatus(status);
        
    	empresaRepository.save(empresa);
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1
    }

    public Empresa getEnterpriseById(Integer id) {

        return empresaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado."));
    }

    public Empresa updateEmpresaById(Integer id, Empresa empresaNova) {
        Empresa empresa = this.getEnterpriseById(id);

        empresa.setCnpj(empresaNova.getCnpj());
        empresa.setContato(empresaNova.getContato());
        empresa.setEndereco(empresaNova.getEndereco());
        empresa.setName(empresaNova.getName());

        return empresaRepository.save(empresa);
    }

    public void deleteEmpresaById(Integer id) {

        empresaRepository.deleteById(id);
    }

    public void arquivaEmpresaById(Integer id, Boolean status) {
        Empresa empresa = this.getEnterpriseById(id);
        empresa.setStatus(status);

        empresaRepository.save(empresa);
    }

}
