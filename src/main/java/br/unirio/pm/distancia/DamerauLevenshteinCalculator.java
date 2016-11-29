package br.unirio.pm.distancia;

import br.unirio.pm.keyboard.KeyboardLayout;

public class DamerauLevenshteinCalculator extends DistanceCalculator {

	private KeyboardLayout layout;

	public DamerauLevenshteinCalculator(KeyboardLayout layout) {
		this.layout = layout;
	}

	/**
	 * Implementação do calculo da distancia com Damerou-Levenshtein
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
		double transposition;
		for (int i = 1; i <= lhs.length(); i++) {
			for (int j = 1; j <= rhs.length(); j++) {

				deletion = distance[i - 1][j] + layout.getInsertDeleteDistance();
				insertion = distance[i][j - 1] + layout.getInsertDeleteDistance();
				substitution = distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0
						: layout.getRelativeDistance(lhs.charAt(i - 1), rhs.charAt(j - 1)));

				// Verifica se é transponivel - Damerou
				if (isTransposable(lhs, rhs, i, j)) {
					transposition = distance[i - 2][j - 2]
							+ layout.getNominalDistance(lhs.charAt(i - 1), rhs.charAt(j - 2));

					distance[i][j] = lowestValue(deletion, insertion, substitution, transposition);

				} else {
					distance[i][j] = lowestValue(deletion, insertion, substitution);
				}

			}
		}

		return distance[lhs.length()][rhs.length()];
	}

	/**
	 * Verifica se troca de letra com a letra seguinte
	 */
	private boolean isTransposable(CharSequence lhs, CharSequence rhs, int i, int j) {

		return ((i > 1) && (j > 1) && (lhs.charAt(i - 1) == rhs.charAt(j - 2))
				&& (lhs.charAt(i - 2) == rhs.charAt(j - 1)));
	}

	/**
	 * Calcula o menor valor entre deleção, inserção e substituição
	 */
	private double lowestValue(double deletion, double insertion, double substitution) {

		double min = (deletion < insertion) ? deletion : insertion;
		min = (min < substitution) ? min : substitution;

		return min;

	}

	/**
	 * Calcula o menor valor entre deleção, inserção , substituição e troca pela
	 * letra seguinte
	 */
	private double lowestValue(double deletion, double insertion, double substitution, double transposition) {
		double minor = (deletion < insertion) ? deletion : insertion;
		minor = (minor < substitution) ? minor : substitution;
		minor = (minor < transposition) ? minor : transposition;
		return minor;

	}

}
