package br.unirio.pm.keyboard;

public class KeyboardLayoutNeutro extends KeyboardLayout {

	public KeyboardLayoutNeutro() {

	}

	public double getInsertDeleteDistance() {
		return 1;
	}

	public double getMaximumDistance() {
		return 1.0;
	}

	public String getModel() {
		return "neutro";
	}

	public double getNominalDistance(char firstChar, char secondChar) {
		return 1;
	}

	public void prepareDistances() {

	}

	public double getRelativeDistance(char c1, char c2) {
		return 1.0;
	}
}
