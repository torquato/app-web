package br.com.tor4neto.model;

public enum TipoInstituicao {
	SECUNDARISTA("Secundarista"), UNIVERSITARIO("Universitário"), SECUNDARISTA_UNIVERSITARIO(
			"Secundarista e Universitário");

	private final String label;

	private TipoInstituicao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
