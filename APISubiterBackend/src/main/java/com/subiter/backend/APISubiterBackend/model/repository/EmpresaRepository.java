package com.subiter.backend.APISubiterBackend.model.repository;

import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
<<<<<<< HEAD

import java.util.List;

=======
import java.util.List;
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
  
    
    List<Empresa> findByStatus(Boolean statusEmpresa);
    
    List<Empresa> findByStatusAndId(Boolean statusEmpresa,Integer id);
    
    
    
}
