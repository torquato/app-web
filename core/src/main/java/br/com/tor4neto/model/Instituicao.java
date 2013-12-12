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
@SequenceGenerator(name = "default", sequenceName = "sq_instituicao", allocationSize = 1, initialValue = 1)
@Table(name = "tb_instituicao")
public class Instituicao extends PersistableEntity {
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoInstituicao tipo;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoInstituicao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInstituicao tipo) {
		this.tipo = tipo;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
}
