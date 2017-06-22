package br.com.intro.utils;

public class StringUtil {
	public static String crypt(String senha) {
		int contador, tamanho, codigoASCII;
		String senhaCriptografada = "";
		tamanho = senha.length();
		senha = senha.toUpperCase();
		contador = 0;
		while (contador < tamanho) {
			codigoASCII = senha.charAt(contador) + 130;
			senhaCriptografada = senhaCriptografada + (char) codigoASCII;
			contador++;
		}
		return senhaCriptografada;
	}

	public static String decrypt(String senha) {
		int contador, tamanho, codigoASCII;
		String senhaCriptografada = "";
		tamanho = senha.length();
		senha = senha.toUpperCase();
		contador = 0;
		while (contador < tamanho) {
			codigoASCII = senha.charAt(contador) - 130;
			senhaCriptografada = senhaCriptografada + (char) codigoASCII;
			contador++;
		}
		return senhaCriptografada;
	}
}
