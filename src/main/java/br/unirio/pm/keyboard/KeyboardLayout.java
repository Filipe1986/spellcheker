package br.unirio.pm.keyboard;

import java.util.ArrayList;

import br.unirio.pm.distancia.IDistanceCalculator;

public class KeyboardLayout {

	private static final int DEFAULT_NUMBER_LETTERS = 26;
	private static final int CHAR_TO_POSITION = 65;

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

	public static int getDefaultNumberLetters() {
		return DEFAULT_NUMBER_LETTERS;
	}

	public static int getCharToPosition() {
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

	public void prepare() {

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

	/**
	 * Monta a tabela de distancia de uma vez apenas
	 */
	public void prepareDistances() {
		tableMatrix = new double[26][26];
		for (int i = 0; i < tableMatrix.length; i++) {
			for (int j = 0; j < tableMatrix.length; j++) {

			}
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

	public double getInsertDeleteDistance() {
		return 0.25;
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
		return string;
	}

	public double getRelativeDistance(char firstChar, char secondChar) {
		return getNominalDistance(firstChar, secondChar) / getMaximumDistance();
	}

	private double dist(double width, double height) {
		if (height == 0.0) {
			return Math.abs(width);
		}

		return Math.sqrt(width * width + height * height);
	}

}
