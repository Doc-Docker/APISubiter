package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Chamado;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;
import com.subiter.backend.APISubiterBackend.model.entity.Usuario;
import com.subiter.backend.APISubiterBackend.model.repository.ChamadoRepository;

import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoServicoService tipoServicoService;

    public Chamado save(Chamado chamado){

        chamado.setId(null);

        Usuario usuario = usuarioService.getUserById(chamado.getUsuarioChamado().getId());
        
        chamado.setUsuarioChamado(usuario);

        TipoServico tipoChamado = tipoServicoService.getServicoById(chamado.getTipoChamado().getId());

        chamado.setTipoChamado(tipoChamado);
        
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> getAllChamados (){
        
        return chamadoRepository.findAll();
    }
    
    public Chamado getChamadoById(Integer id){

        return chamadoRepository.findById(id).orElseThrow(()-> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Chamado não encontrado."));
    }

    public Chamado updateChamadoById(Integer id, Chamado chamado){
    	Chamado chamadoSelector = this.getChamadoById(id);

    	chamadoSelector.setId(id);

        chamadoSelector.setUsuarioChamado(chamado.getUsuarioChamado());

        chamadoSelector.setTipoChamado(chamado.getTipoChamado());

        chamadoSelector.setCriticidadeChamado(chamado.getCriticidadeChamado());

        chamadoSelector.setDataChamado(chamado.getDataChamado());

        chamadoSelector.setDescricaoChamado(chamado.getDescricaoChamado());

        chamadoSelector.setSituacaoChamado(chamado.getSituacaoChamado());

        chamadoSelector.setSolucaoChamado(chamado.getSolucaoChamado());

        chamadoSelector.setEncerramentoChamado(chamado.getEncerramentoChamado());
    	
    	return chamadoRepository.save(chamadoSelector);
    }
    
    public void deleteChamadoById(Integer id){

    	chamadoRepository.deleteById(id);
    }
}
