package br.unirio.pm.distance;

public abstract class DistanceCalculator {
	/**
	 * método abstrato para implementação da distancia
	 */
	public abstract double distance(String palavra1, String palavra2);

	public abstract boolean isKeyboardLayoutNeutral();

}
