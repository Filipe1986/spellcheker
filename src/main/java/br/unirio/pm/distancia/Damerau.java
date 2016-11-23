package br.unirio.pm.distancia;

import java.util.HashMap;

public class Damerau implements IDistanceCalculator {

	public int distance(String s1, String s2) {

		int distanciaInfinita = s1.length() + s2.length();

		HashMap<Character, Integer> mapCharInt = new HashMap<Character, Integer>();

		for (int d = 0; d < s1.length(); d++) {
			if (!mapCharInt.containsKey(s1.charAt(d))) {
				mapCharInt.put(s1.charAt(d), 0);
			}
		}

		for (int d = 0; d < s2.length(); d++) {
			if (!mapCharInt.containsKey(s2.charAt(d))) {
				mapCharInt.put(s2.charAt(d), 0);
			}
		}

		// Create the distance matrix H[0 .. s1.length+1][0 .. s2.length+1]
		int[][] h = new int[s1.length() + 2][s2.length() + 2];

		// initialize the left and top edges of H
		for (int i = 0; i <= s1.length(); i++) {
			h[i + 1][0] = distanciaInfinita;
			h[i + 1][1] = i;
		}

		for (int j = 0; j <= s2.length(); j++) {
			h[0][j + 1] = distanciaInfinita;
			h[1][j + 1] = j;

		}

		// fill in the distance matrix H
		// look at each character in s1
		for (int i = 1; i <= s1.length(); i++) {
			int db = 0;

			// look at each character in b
			for (int j = 1; j <= s2.length(); j++) {
				int i1 = mapCharInt.get(s2.charAt(j - 1));
				int j1 = db;

				int cost = 1;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					cost = 0;
					db = j;
				}
			}

			mapCharInt.put(s1.charAt(i - 1), i);
		}

		return h[s1.length() + 1][s2.length() + 1];
	}

	private static int min(int a, int b, int c, int d) {
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}

}
