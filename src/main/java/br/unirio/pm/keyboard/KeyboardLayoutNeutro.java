package br.unirio.pm.keyboard;

public class KeyboardLayoutNeutro extends KeyboardLayout {

	public String getModel() {
		return "neutro";
	}

	public double getInsertDeleteDistance() {
		return 1;
	}

	public double getNominalDistance(char firstChar, char secondChar) {
		return 1;
	}

	public double getRelativeDistance(char c1, char c2) {
		return 1.0;
	}
}
