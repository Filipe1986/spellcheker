package br.unirio.pm.distancia;

import br.unirio.pm.keyboard.KeyboardLayout;

public class LevenshteinCalculator extends DistanceCalculator {
	KeyboardLayout layout;

	public LevenshteinCalculator(KeyboardLayout layout) {
		this.layout = layout;
	}

	/**
	 * Implementação do calculo da distancia com Levenshtein
	 */
	public double distance(String s1, String s2) {

		CharSequence lhs = s1;
		CharSequence rhs = s2;
		double[][] distance = new double[lhs.length() + 1][rhs.length() + 1];

		for (int i = 0; i <= lhs.length(); i++) {
			distance[i][0] = i;
		}

		for (int j = 1; j <= rhs.length(); j++) {
			distance[0][j] = j;

		}
		double deletion;
		double insertion;
		double substitution;

		for (int i = 1; i <= lhs.length(); i++) {
			for (int j = 1; j <= rhs.length(); j++) {
				deletion = distance[i - 1][j] + layout.getInsertDeleteDistance();
				insertion = distance[i][j - 1] + layout.getInsertDeleteDistance();

				substitution = distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0
						: layout.getRelativeDistance(lhs.charAt(i - 1), rhs.charAt(j - 1)));

				distance[i][j] = lowestValue(deletion, insertion, substitution);
			}
		}

		return distance[lhs.length()][rhs.length()];
	}

	/**
	 * Calcula o menor valor entre deleção, inserção e substituição
	 */
	private double lowestValue(double deletion, double insertion, double substitution) {
		double min = (deletion < insertion) ? deletion : insertion;
		return (min < substitution) ? min : substitution;

	}
}
