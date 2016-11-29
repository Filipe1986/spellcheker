package br.unirio.pm.keyboard;

/**
 * Classe para montar uma linha do teclado
 */
public class Line {

	private String letters;
	private double offset;

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public double getOffset() {
		return offset;
	}

	public void setOffset(double offset) {
		this.offset = offset;
	}

	public char charAt(int i) {
		return letters.charAt(i);
	}

	public int getTamanho() {
		return letters.length();
	}

	public int getLength() {
		return letters.length();
	}

	@Override
	public String toString() {
		String string = letters + " " + offset;
		return string;
	}

}
