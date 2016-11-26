package br.unirio.pm.keyboard;

import java.util.ArrayList;

import br.unirio.pm.distancia.IDistanceCalculator;

public class KeyboardLayout {

	private final int DEFAULT_NUMBER_LETTERS = 26;
	private final int CHAR_TO_POSITION = 65;

	private String model;
	private ArrayList<Line> lines;
	private double[][] tableMatrix;

	private OrderedPair[] table;

	private IDistanceCalculator calculator;

	protected OrderedPair[] getTable() {
		return table;
	}

	protected void setTable(OrderedPair[] table) {
		this.table = table;
	}

	public int getDefaultNumberLetters() {
		return DEFAULT_NUMBER_LETTERS;
	}

	public int getCharToPosition() {
		return CHAR_TO_POSITION;
	}

	public KeyboardLayout() {
		lines = new ArrayList<Line>();
		table = new OrderedPair[DEFAULT_NUMBER_LETTERS];
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	/**
	 * Monta neutroa tabela de distancia de uma vez apenas
	 */
	public void prepareDistance() {

		tableMatrix = new double[DEFAULT_NUMBER_LETTERS][DEFAULT_NUMBER_LETTERS];

		for (int i = 0; i < tableMatrix.length; i++) {
			for (int j = 0; j < tableMatrix.length; j++) {

				tableMatrix[i][j] = 1;
			}
		}

	}

	public void prepareDistances() {

		double absolutOfsset = 0;
		int height = 0;
		for (Line line : lines) {
			absolutOfsset += line.getOffset();
			for (int i = 0; i < line.getLength(); i++) {
				char letters = line.charAt(i);

				OrderedPair orderedPair = new OrderedPair(i + absolutOfsset, height);

				table[letters - CHAR_TO_POSITION] = orderedPair;
			}
			height++;
		}
	}

	public double getNominalDistance(char firstChar, char secondChar) {
		if (firstChar == secondChar) {
			return 0;
		}
		firstChar = Character.toUpperCase(firstChar);
		secondChar = Character.toUpperCase(secondChar);
		OrderedPair pair1 = table[firstChar - CHAR_TO_POSITION];
		OrderedPair pair2 = table[secondChar - CHAR_TO_POSITION];

		double diferencaLargura = Math.abs(pair1.getX() - pair2.getX());

		double diferencaAltura = Math.abs(pair1.getY() - pair2.getY());

		return dist(diferencaLargura, diferencaAltura);
	}

	private double dist(double width, double height) {

		return Math.sqrt(width * width + height * height);
	}

	public double getInsertDeleteDistance() {
		return 1;
	}

	public double getMaximumDistance() {
		return 1;
	}

	@Override
	public String toString() {
		String string = model + "\n \n";
		for (Line line : lines) {
			string += line + "\n";
		}
		string += "\n";
		return string;
	}

	public double getRelativeDistance(char firstChar, char secondChar) {
		return 1;
	}

}
