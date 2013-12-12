package br.com.tor4neto.model;

public enum TipoEstudante {
	SECUNDARISTA("Secundarista"), UNIVERSITARIO("Universitário");

	private final String label;

	private TipoEstudante(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
