package br.unirio.pm.distancia;

import br.unirio.pm.keyboard.KeyboardLayout;

public class LevenshteinCalculator implements IDistanceCalculator {
	KeyboardLayout layout;

	public LevenshteinCalculator(KeyboardLayout layout) {
		this.layout = layout;
	}

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

		for (int i = 1; i <= lhs.length(); i++) {
			for (int j = 1; j <= rhs.length(); j++) {
				double deletion = distance[i - 1][j] + layout.getInsertDeleteDistance();
				double insertion = distance[i][j - 1] + layout.getInsertDeleteDistance();

				double substitution = distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0
						: layout.getRelativeDistance(lhs.charAt(i - 1), rhs.charAt(j - 1)));

				distance[i][j] = lowestValue(deletion, insertion, substitution);

			}
		}
		return distance[lhs.length()][rhs.length()];
	}

	private double lowestValue(double deletion, double insertion, double substitution) {
		double min = (deletion < insertion) ? deletion : insertion;
		return (min < substitution) ? min : substitution;

	}

}
