package br.com.tor4neto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default", sequenceName = "sq_solicitacao", allocationSize = 1, initialValue = 1)
@Table(name = "tb_solicitacao")
public class Solicitacao extends PersistableEntity {

	@ManyToOne
	@JoinColumn(name = "id_estudante")
	private Estudante estudante;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao")
	private SituacaoSolicitacao situacao;
	
	
}
