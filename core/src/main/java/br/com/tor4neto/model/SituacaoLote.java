package br.com.tor4neto.model;

public enum SituacaoLote {
	ABERTO("Aberto"), FECHADO("Fechado"), IMPRESSO("Impresso");

	private final String label;

	private SituacaoLote(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
