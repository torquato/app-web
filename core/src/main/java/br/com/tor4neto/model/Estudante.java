package br.com.tor4neto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default", sequenceName = "sq_estudante", allocationSize = 1, initialValue = 1)
@Table(name = "tb_estudante")
public class Estudante extends PersistableEntity {

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_lote")
	private Lote lote;

	// Estudantes
	private String passeLegalCard; // somente secundarista ??

	private String numeroCarteira;
	private String numeroCarteiraUltimoAno; //
	private String matricula;
	private TipoEstudante tipoEstudante;

	private String caminhoFoto;

	@Column(name = "nome")
	private String nome;

	// dados academicos
	private Estado estadoInstituicao; //instituicao
	private Cidade cidadeInstituicao;
	private Instituicao instituicao;
	// private EducationType educationType;// secundarista
	private Curso curso;// universitario
	private String anoEscolar;// secundarista
	private String turno; // manha tarde noite integral

	private String additionalListStr;

	private Boolean habilitado;
	private Long sequencial;
	private Long removed;
	private Date removedDate;

	// ----------personal info

	// documentos
	private Genero genero;// masculino feminino
	private String rg;
	private String orgaoExpeditor;
	private String cpf;
	private Date dataNascimento;

	// pessoal
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String email;

	// saude
	private String tipoSanguineo;
	private Boolean alergico;
	private Boolean cardiaco;

	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private Cidade cidade;
	private Estado estado;

}
