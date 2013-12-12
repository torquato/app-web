package br.com.tor4neto.model;

public enum SituacaoSolicitacao {
	PENDENTE("Pendente"), PAGA("Paga"), IMPRESSA("Impressa");

	private final String label;

	private SituacaoSolicitacao(String label) {
		this.label = label;

	}

	public String getLabel() {
		return this.label;
	}
}
