
package com.subiter.backend.APISubiterBackend.model.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

@Entity(name = "EQUIPAMENTO_SERIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipamentoSerie {

	@Id
	@Column(name = "serie_equipamento")
	@JsonView({ View.EquipamentoSerieView.class, View.InstalacaoView.class, View.EquipamentoView.class })
	private String id;

	@OneToOne(mappedBy = "equipamentoSerie",cascade = CascadeType.ALL)
	@JsonView({View.EquipamentoSerieView.class, View.InstalacaoView.class })
	private Equipamento equipamento;

	@Column(name = "serie_disponivel")
	@JsonView({View.EquipamentoView.class})
	private Boolean disponibilidade;

	@Column(name = "serie_data_entrada", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonView({ View.EquipamentoSerieView.class })
	private LocalDate dataCadastro;

	@OneToMany(mappedBy = "equipamentoSerieInstalacao", cascade = CascadeType.ALL)
	@JsonView({View.EquipamentoSerieView.class})
	private List<Instalacao> instalacaos;

	@PrePersist
	public void presPersist() {
		setDataCadastro(LocalDate.now());
		setDisponibilidade(true);
	}
}
