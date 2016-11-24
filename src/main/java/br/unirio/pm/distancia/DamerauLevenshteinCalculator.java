package br.unirio.pm.distancia;

import br.unirio.pm.keyboard.KeyboardLayout;

public class DamerauLevenshteinCalculator implements IDistanceCalculator {

	public DamerauLevenshteinCalculator(KeyboardLayout layout) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construtor vazio pré distancia com layout
	 */
	public DamerauLevenshteinCalculator() {

	}

	public int distance(String s1, String s2) {

		CharSequence lhs = s1;
		CharSequence rhs = s2;
		int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

		for (int i = 0; i <= lhs.length(); i++) {
			distance[i][0] = i;
		}

		for (int j = 1; j <= rhs.length(); j++) {
			distance[0][j] = j;

		}
		int delecao;
		int insercao;
		int substituicao;
		int transposition;
		for (int i = 1; i <= lhs.length(); i++) {
			for (int j = 1; j <= rhs.length(); j++) {

				delecao = distance[i - 1][j] + 1;
				insercao = distance[i][j - 1] + 1;
				substituicao = distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1);

				// Verifica se a transponivel - Parte de damerou
				if (isTransposable(lhs, rhs, i, j)) {
					transposition = distance[i - 2][j - 2] + 1;

					distance[i][j] = lowestValue(delecao, insercao, substituicao, transposition);

				} else {
					distance[i][j] = lowestValue(delecao, insercao, substituicao);
				}

			}
		}
		return distance[lhs.length()][rhs.length()];
	}

	private boolean isTransposable(CharSequence lhs, CharSequence rhs, int i, int j) {

		return ((i > 1) && (j > 1) && (lhs.charAt(i - 1) == rhs.charAt(j - 2))
				&& (lhs.charAt(i - 2) == rhs.charAt(j - 1)));
	}

	private int lowestValue(int deletion, int insertion, int substitution) {

		int min = (deletion < insertion) ? deletion : insertion;
		min = (min < substitution) ? min : substitution;

		return min;

	}

	private int lowestValue(int deletion, int insertion, int substitution, int transposition) {
		int minor = (deletion < insertion) ? deletion : insertion;
		minor = (minor < substitution) ? minor : substitution;
		minor = (minor < transposition) ? minor : transposition;
		return minor;

	}

}
