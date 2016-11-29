package br.unirio.pm.keyboard;

import java.util.ArrayList;

/**
 * Classe para criação de teclados
 */
public class KeyboardLayout {

	private static final double INSERT_DELETE_NUMBER = 0.25;
	private final int DEFAULT_NUMBER_LETTERS = 26;
	private final int CHAR_TO_POSITION = 65;
	private double maxDistance;

	private String model;
	private ArrayList<Line> lines;

	private OrderedPair[] table;

	public KeyboardLayout() {
		lines = new ArrayList<Line>();
		table = new OrderedPair[DEFAULT_NUMBER_LETTERS];
	}

	protected OrderedPair[] getTable() {
		return table;
	}

	protected void setTable(OrderedPair[] table) {
		this.table = table;
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

	/**
	 * Método para adicionar linha ao teclado
	 */
	public void addLine(Line line) {
		lines.add(line);
	}

	/**
	 * Prepara o vetor de pares ordenados facilitando o calculo da distancia
	 * Instancia o valor da maior distancia ao fim
	 */
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
		calculateDistance();
	}

	/**
	 * Pega a distancia nominal entre duas letras de acordo com o teclado
	 */
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

	/**
	 * Calcula a hipotenusa para achar a distancia de duas teclas no teclado
	 */
	private double dist(double width, double height) {
		return Math.sqrt(width * width + height * height);

	}

	/**
	 * Retorna valor preestabelecido para inserções e deleções
	 */
	public double getInsertDeleteDistance() {
		return INSERT_DELETE_NUMBER;
	}

	/**
	 * Retorna a maior distancia
	 */
	public double getMaximumDistance() {
		return maxDistance;
	}

	/**
	 * Força o calculo da maior distancia
	 */

	private void calculateDistance() {
		double max = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				char c1 = (char) ((char) 65 + i);
				char c2 = (char) ((char) 65 + j);

				if (getNominalDistance(c1, c2) > max)
					max = getNominalDistance(c1, c2);
			}
		}
		maxDistance = max;
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

	/**
	 * Retorna o valor relativo da distancia de duas teclas pelo maximo do
	 * teclado
	 */
	public double getRelativeDistance(char firstChar, char secondChar) {
		return (getNominalDistance(firstChar, secondChar) / maxDistance);
	}

}
