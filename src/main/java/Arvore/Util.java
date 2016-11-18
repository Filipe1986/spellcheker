package Arvore;

public class Util {

	public static int distanciaDeLevenshtein(String string1, String string2) {

		if (string1.length() == 0) {
			return string2.length();
		}
		if (string2.length() == 0) {
			return string1.length();
		}

		int igualdadePosicao0 = (string1.charAt(0) == string2.charAt(0)) ? 0 : 1;

		int adicao = distanciaDeLevenshtein(string1.substring(1), string2) + 1;

		int delecao = distanciaDeLevenshtein(string1, string2.substring(1)) + 1;

		int mudanca = distanciaDeLevenshtein(string1.substring(1), string2.substring(1)) + igualdadePosicao0;

		return Math.min(mudanca, Math.min(adicao, delecao));
	}

	public static int computeLevenshteinDistance(String s1, String s2) {

		CharSequence lhs = s1;
		CharSequence rhs = s2;
		int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

		for (int i = 0; i <= lhs.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= rhs.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= lhs.length(); i++)
			for (int j = 1; j <= rhs.length(); j++) {
				int dist1 = distance[i - 1][j] + 1;
				int dist2 = distance[i][j - 1] + 1;
				int dist3 = distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1);
				int dist4 = Math.min(dist1, dist2);
				distance[i][j] = Math.min(dist3, dist4);
			}

		return distance[lhs.length()][rhs.length()];
	}
}
