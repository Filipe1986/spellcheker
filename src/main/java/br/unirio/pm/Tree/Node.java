package br.unirio.pm.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unirio.pm.distancia.IDistanceCalculator;

public class Node {

	private final String word;
	private final Map<Integer, Node> filhos = new HashMap<Integer, Node>();

	public Node(String palavra) {
		this.word = palavra;
	}

	/**
	 * Pega o filho na posição distancia no hashMap
	 */
	public Node filhosNumaDistancia(int distancia) {
		return filhos.get(distancia);
	}

	/**
	 * Método usado pela árvore para adicionar o nó na posição do hash
	 */
	public void addChildNode(int position, Node childNode) {
		filhos.put(position, childNode);
	}

	public List<String> search(String no, int distanciaMaxima, IDistanceCalculator calculator) {
		List<String> palavrasCompativeis = new ArrayList<String>();

		int distancia = (int) calculator.distance(word, no);
		if (distancia <= distanciaMaxima) {
			palavrasCompativeis.add(word);
		}

		if (filhos.size() == 0) {
			return palavrasCompativeis;
		}

		for (int i = Math.max(1, distancia - distanciaMaxima); i <= distancia + distanciaMaxima; i++) {

			Node filho = filhos.get(i);
			if (filho != null) {
				palavrasCompativeis.addAll(filho.search(no, distanciaMaxima, calculator));
			}
		}
		return palavrasCompativeis;

	}

	public boolean equals(Node node) {
		return word.equals(node.word);
	}

	public String getWord() {
		return word;
	}

}
