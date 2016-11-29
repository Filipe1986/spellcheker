package br.unirio.pm.keyboard;

public class OrderedPair {

	private double x;
	private double y;

	/**
	 * Par ordenado com largura e altura da posição de uma tecla(letra)
	 */
	public OrderedPair(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
