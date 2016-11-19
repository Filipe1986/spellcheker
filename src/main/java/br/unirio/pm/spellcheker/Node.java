package Arvore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No {

	private final String palavra;
	private final Map<Integer, No> filhos = new HashMap<Integer, No>();

	public No(String palavra) {
		this.palavra = palavra;
	}

	public No filhosNumaDistancia(int distancia) {
		return filhos.get(distancia);
	}

	public void adicionaNoFilho(int posicao, No noFilho) {
		filhos.put(posicao, noFilho);
	}

	public List<String> busca(String no, int distanciaMaxima) {

		List<String> palavrasCompativeis = new ArrayList<String>();

		int distanciaLevenshtein = Util.computeLevenshteinDistance(palavra, no);
		if (distanciaLevenshtein <= distanciaMaxima) {
			palavrasCompativeis.add(palavra);
		}

		if (filhos.size() == 0) {
			return palavrasCompativeis;
		}

		for (int i = Math.max(1, distanciaLevenshtein - distanciaMaxima); i <= distanciaLevenshtein
				+ distanciaMaxima; i++) {

			No filho = filhos.get(i);
			if (filho != null) {
				palavrasCompativeis.addAll(filho.busca(no, distanciaMaxima));
			}
		}
		return palavrasCompativeis;
	}

	public boolean equals(No outroNo) {
		return palavra.equals(outroNo.palavra);
	}

	public String getPalavra() {
		return palavra;
	}

}
