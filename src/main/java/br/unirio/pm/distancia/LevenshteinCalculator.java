package br.unirio.pm.distancia;

import br.unirio.pm.keyboard.KeyboardLayout;

public class LevenshteinCalculator implements IDistanceCalculator {

	public LevenshteinCalculator(KeyboardLayout layout) {
		// TODO Auto-generated constructor stub
	}

	public int distance(String s1, String s2) {

		CharSequence lhs = s1;
		CharSequence rhs = s2;
		int[][] distancia = new int[lhs.length() + 1][rhs.length() + 1];

		for (int i = 0; i <= lhs.length(); i++) {
			distancia[i][0] = i;
		}

		for (int j = 1; j <= rhs.length(); j++) {
			distancia[0][j] = j;

		}

		for (int i = 1; i <= lhs.length(); i++) {
			for (int j = 1; j <= rhs.length(); j++) {
				int delecao = distancia[i - 1][j] + 1;
				int insercao = distancia[i][j - 1] + 1;
				int substituicao = distancia[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1);

				distancia[i][j] = menorValor(delecao, insercao, substituicao);

			}
		}
		return distancia[lhs.length()][rhs.length()];
	}

	private int menorValor(int delecao, int insercao, int substituicao) {
		int min = (delecao < insercao) ? delecao : insercao;
		return (min < substituicao) ? min : substituicao;

	}

}
