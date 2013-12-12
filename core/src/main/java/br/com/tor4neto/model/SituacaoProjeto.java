package br.com.tor4neto.model;

public enum SituacaoProjeto {
	ABERTO("Aberto"), FECHADO("Fechado");

	private final String label;

	private SituacaoProjeto(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
