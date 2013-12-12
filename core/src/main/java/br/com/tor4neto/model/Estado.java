package br.com.tor4neto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default", sequenceName = "sq_estado", allocationSize = 1, initialValue = 1)
@Table(name = "tb_estado")
public class Estado extends PersistableEntity {
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nome_abreviado")
	private String nomeAbreviado;

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}
	
	
}
