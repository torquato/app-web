package br.com.tor4neto.util;

import java.util.ArrayList;
import java.util.List;

public class CpfCnpjValidator {
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static List<String> cpfNotValid = null;

	static {
		populate();
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) 
		{
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || (cpf.length() != 11))
			return false;

		if (cpfNotValid.contains(cpf))
			return false;

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	public static boolean isValidCNPJ(String cnpj) {
		if ((cnpj == null) || (cnpj.length() != 14))
			return false;

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1,
				pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}

	private static void populate() {
		if (cpfNotValid != null)
			return;

		cpfNotValid = new ArrayList<String>();
		cpfNotValid.add("00000000000");
		cpfNotValid.add("11111111111");
		cpfNotValid.add("22222222222");
		cpfNotValid.add("33333333333");
		cpfNotValid.add("44444444444");
		cpfNotValid.add("55555555555");
		cpfNotValid.add("66666666666");
		cpfNotValid.add("77777777777");
		cpfNotValid.add("88888888888");
		cpfNotValid.add("99999999999");
	}
}
