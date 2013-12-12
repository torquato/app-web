package br.com.tor4neto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "default", sequenceName = "sq_projeto", allocationSize = 1, initialValue = 1)
@Table(name = "tb_projeto")
public class Projeto extends PersistableEntity{

	@Column(name = "ano")
	private String ano;// 2 digitos
	
	@ManyToOne
	@Column(name = "id_estado")
	private Estado estado;
	
	@Column(name = "situacao")
	@Enumerated(EnumType.STRING)
	private SituacaoProjeto situacao;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public SituacaoProjeto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoProjeto situacao) {
		this.situacao = situacao;
	}

	
	
}
