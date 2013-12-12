package br.com.tor4neto.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default", sequenceName = "sq_lote", allocationSize = 1, initialValue = 1)
@Table(name = "tb_lote")
public class Lote extends PersistableEntity{
	
	@Column(name = "codigo")
	private String codigo;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "lote")
	private Set<Estudante> estudantes;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao")
	private SituacaoLote situacao;
	
}
