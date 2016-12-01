package br.unirio.pm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.unirio.pm.distance.DistanceCalculator;

public class Node {

	private final String word;
	private final Map<Integer, Node> children;

	public Node(String palavra) {
		this.word = palavra;
		this.children = new HashMap<Integer, Node>();

	}

	public String getWord() {
		return word;
	}

	/**
	 * Pega o filho na posição distance no hashMap
	 */
	public Node filhoNumaDistancia(int distance) {
		return children.get(distance);
	}

	/**
	 * Método usado pela árvore para adicionar o nó na posição do hash
	 */
	public void addChildNode(int position, Node childNode) {
		children.put(position, childNode);
	}

	/**
	 * Busca por palavras na árvore
	 */
	public ArrayList<Word> search(String node, int maxDistance, DistanceCalculator calculator) {

		ArrayList<Word> compatibleWord = new ArrayList<Word>();

		double distance = (int) calculator.distance(word, node);

		double modificador = 1;

		if (!calculator.isKeyboardLayoutNeutral()) {
			modificador = 100;
		}

		distance = distance * modificador;
		maxDistance = (int) (maxDistance * modificador);

		if (distance <= maxDistance) {
			compatibleWord.add(new Word(word, distance / modificador));
		}

		if (children.size() == 0) {
			return compatibleWord;
		}

		for (int i = Math.max(1, (int) distance - maxDistance); i <= distance + maxDistance; i++) {

			Node child = children.get(i);
			if (child != null) {
				compatibleWord.addAll(child.search(node, maxDistance / (int) modificador, calculator));
			}
		}
		return compatibleWord;

	}
}
