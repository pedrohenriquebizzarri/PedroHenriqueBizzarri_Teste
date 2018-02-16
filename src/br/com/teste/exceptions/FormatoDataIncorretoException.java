package br.com.teste.exceptions;

public class FormatoDataIncorretoException extends Exception {
	private static final long serialVersionUID = 1L;

	public FormatoDataIncorretoException() {
		super("O formato da data foi digitado de maneira incorreta");
	}
}
