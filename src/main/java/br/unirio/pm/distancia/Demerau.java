/*
 * package br.unirio.pm.distancia;
 * 
 * public class Demerau { private String string1; private String string2;
 * 
 * private int[][] matriz; private Boolean calculated = false;
 * 
 * public Demerau(String string1, String string2) { if ((string1.length() > 0 ||
 * !string1.isEmpty()) || (string2.length() > 0 || !string2.isEmpty())) {
 * this.string1 = string1; this.string2 = string2; } }
 * 
 * public int[][] getMatrix() { setupMatrix(); return matriz; }
 * 
 * public int getSimilaridade() { if (!calculated) setupMatrix();
 * 
 * return matriz[string1.length()][string2.length()]; }
 * 
 * private void setupMatrix() { int cost = -1; int delecao, substituicao,
 * insercao;
 * 
 * matriz = new int[string1.length() + 1][string2.length() + 1];
 * 
 * for (int i = 0; i <= string1.length(); i++) { matriz[i][0] = i; }
 * 
 * for (int i = 0; i <= string2.length(); i++) { matriz[0][i] = i; }
 * 
 * for (int i = 1; i <= string1.length(); i++) { for (int j = 1; j <=
 * string2.length(); j++) { if (string1.charAt(i - 1) == string2.charAt(j - 1))
 * { cost = 0; } else { cost = 1; }
 * 
 * delecao = matriz[i - 1][j] + 1; insercao = matriz[i][j - 1] + 1; substituicao
 * = matriz[i - 1][j - 1] + cost;
 * 
 * matriz[i][j] = minimo(delecao, insercao, substituicao);
 * 
 * if ((i > 1) && (j > 1) && (string1.charAt(i - 1) == string2.charAt(j - 2)) &&
 * (string1.charAt(i - 2) == string2.charAt(j - 1))) { matriz[i][j] =
 * minimo(matriz[i][j], matriz[i - 2][j - 2] + cost); } } }
 * 
 * calculated = true; displayMatrix(); }
 * 
 * private void displayMatrix() { System.out.println("  " + string1); for (int y
 * = 0; y <= string2.length(); y++) { if (y - 1 < 0) System.out.print(" "); else
 * System.out.print(string2.charAt(y - 1)); for (int x = 0; x <=
 * string1.length(); x++) { System.out.print(matriz[x][y]); }
 * System.out.println(); } }
 * 
 * private int minimo(int d, int i, int s) { int valorMaximo =
 * Integer.MAX_VALUE;
 * 
 * if (d < valorMaximo) valorMaximo = d; if (i < valorMaximo) valorMaximo = i;
 * if (s < valorMaximo) valorMaximo = s;
 * 
 * return valorMaximo; }
 * 
 * private int minimo(int d, int t) { int valorMaximo = Integer.MAX_VALUE;
 * 
 * if (d < valorMaximo) valorMaximo = d; if (t < valorMaximo) valorMaximo = t;
 * 
 * return valorMaximo; }
 * 
 * public int getDHSimilarity() {
 * 
 * int INF = string1.length() + string2.length();
 * 
 * matriz = new int[string1.length() + 1][string2.length() + 1];
 * 
 * for (int i = 0; i < string1.length(); i++) { matriz[i + 1][1] = i; matriz[i +
 * 1][0] = INF; }
 * 
 * for (int i = 0; i < string2.length(); i++) { matriz[1][i + 1] = i;
 * matriz[0][i + 1] = INF; }
 * 
 * int[] DA = new int[24];
 * 
 * for (int i = 0; i < 24; i++) { DA[i] = 0; }
 * 
 * for (int i = 1; i < string1.length(); i++) { int db = 0;
 * 
 * for (int j = 1; j < string2.length(); j++) {
 * 
 * int i1 = DA[string2.indexOf(string2.charAt(j - 1))]; int j1 = db; int d =
 * ((string1.charAt(i - 1) == string2.charAt(j - 1)) ? 0 : 1); if (d == 0) { db
 * = j; }
 * 
 * matriz[i + 1][j + 1] = Math.min(Math.min(matriz[i][j] + d, matriz[i + 1][j] +
 * 1), Math.min(matriz[i][j + 1] + 1, matriz[i1][j1] + (i - i1 - 1) + 1 + (j -
 * j1 - 1))); } DA[string1.indexOf(string1.charAt(i - 1))] = i; }
 * 
 * return matriz[string1.length()][string2.length()]; } }
 */