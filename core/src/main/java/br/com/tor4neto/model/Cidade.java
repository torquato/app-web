package br.com.tor4neto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default", sequenceName = "sq_cidade", allocationSize = 1, initialValue = 1)
@Table(name = "tb_cidade")
public class Cidade extends PersistableEntity {

	@Column(name = "codigo")
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nome_abreviado")
	private String nomeAbreviado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

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
