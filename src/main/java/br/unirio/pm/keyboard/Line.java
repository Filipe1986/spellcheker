package br.unirio.pm.keyboard;

public class Line {

	private String conteudo;
	private double offset;

	public String getContent() {
		return conteudo;
	}

	public void setLetters(String content) {
		this.conteudo = content;
	}

	public double getOffset() {
		return offset;
	}

	public void setOffset(double offset) {
		this.offset = offset;
	}

	public char charAt(int i) {
		return conteudo.charAt(i);

	}

	public int getTamanho() {

		return conteudo.length();
	}

	public int getLength() {
		return conteudo.length();
	}

	@Override
	public String toString() {
		String string = conteudo + " " + offset;

		return string;
	}

}
