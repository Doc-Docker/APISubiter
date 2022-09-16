package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.subiter.backend.APISubiterBackend.model.dto.ServicoDto;
import com.subiter.backend.APISubiterBackend.model.dto.ServicoForm;
import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import com.subiter.backend.APISubiterBackend.model.entity.Servico;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;
import com.subiter.backend.APISubiterBackend.model.repository.EmpresaRepository;
import com.subiter.backend.APISubiterBackend.model.repository.ServicoRepository;
import com.subiter.backend.APISubiterBackend.model.repository.TipoServicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;
    
    public Servico save (ServicoForm servicoForm){

    	Servico servico = new Servico();
        Optional<TipoServico> tipoServico = tipoServicoRepository.findById(servicoForm.getTipoServico());

        servico.setTipoServico(tipoServico.get());
        
        Optional<Empresa> empresaQuerySelector = empresaRepository.findById(servicoForm.getEmpresaServico());

        Empresa empresa = empresaQuerySelector.get();

        servico.setEmpresaServico(empresa);

        servico.setDescricao(servicoForm.getDescricao());
        

        return servicoRepository.save(servico);
    }

    public List<ServicoDto> getAllServices (){
        
    	List<Servico> servicos = servicoRepository.findAll();
    	List<ServicoDto> servicosDto = new ArrayList<>();
    	
    	for (Servico servico : servicos) {
			ServicoDto servicoDto = new ServicoDto(
													servico.getId(),
													servico.getTipoServico().getNome(),
													servico.getDescricao(),
													servico.getEmpresaServico().getName(),
													servico.getEmpresaServico().getId()
													);
			
			
			servicosDto.add(servicoDto);
		}
    	
        return servicosDto;
    }
    
    public Servico getServiceById(Integer id){

        return servicoRepository.findById(id).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado."));
    }
    
    public void deleteServiceById(Integer id){

        servicoRepository.deleteById(id);
    }
    
    public Servico updateServiceById(Integer id, ServicoForm servicoForm){
    	Servico servico = this.getServiceById(id);
    	
    	Optional<TipoServico> tipoServico = tipoServicoRepository.findById(servicoForm.getTipoServico());

        servico.setTipoServico(tipoServico.get());
        
        Optional<Empresa> empresaQuerySelector = empresaRepository.findById(servicoForm.getEmpresaServico());

        Empresa empresa = empresaQuerySelector.get();

        servico.setEmpresaServico(empresa);
    	
    	servico.setDescricao(servicoForm.getDescricao());
    	
    	return servicoRepository.save(servico);
    }
    
    
}
