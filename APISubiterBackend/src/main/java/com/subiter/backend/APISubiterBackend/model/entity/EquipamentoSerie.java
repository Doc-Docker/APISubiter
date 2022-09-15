
package com.subiter.backend.APISubiterBackend.model.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "EQUIPAMENTO_SERIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipamentoSerie implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "serie_equipamento")
    private String id;

    @OneToOne(mappedBy = "equipamentoSerie")
    @JsonIgnore
    private Equipamento equipamento;

    @Column(name = "serie_disponivel")
    private Boolean disponibilidade;

    @Column(name = "serie_data_entrada", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void presPersist(){
        setDataCadastro(LocalDate.now());
    }
}
