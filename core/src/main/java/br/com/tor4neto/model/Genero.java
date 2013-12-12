package br.com.tor4neto.model;

public enum Genero {
	MASCULINO("Masculino", "M"), FEMININO("Feminino", "F");

	private final String label;
	private final String shortLabel;

	private Genero(String label, String shortLabel) {
		this.label = label;
		this.shortLabel = shortLabel;
	}

	public String getLabel() {
		return this.label;
	}

	public String getShortLabel() {
		return this.shortLabel;
	}
}
