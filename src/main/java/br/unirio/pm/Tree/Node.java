package br.unirio.pm.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unirio.pm.distancia.DistanceCalculator;

public class Node implements Comparable<Node> {

	private final String word;
	private final Map<Integer, Node> children = new HashMap<Integer, Node>();
	private int distance;

	public Node(String palavra) {
		this.word = palavra;
	}

	public int getDistance() {
		return distance;
	}

	/**
	 * Pega o filho na posição distance no hashMap
	 */
	public Node filhosNumaDistancia(int distancia) {
		return children.get(distancia);
	}

	/**
	 * Método usado pela árvore para adicionar o nó na posição do hash
	 */
	public void addChildNode(int position, Node childNode) {
		children.put(position, childNode);
	}

	public List<String> search(String no, int maxDistance, DistanceCalculator calculator) {

		List<String> compatibleWord = new ArrayList<String>();

		this.distance = (int) Math.round(calculator.distance(word, no));
		if (distance <= maxDistance) {
			compatibleWord.add(word);
		}

		if (children.size() == 0) {
			return compatibleWord;
		}

		for (int i = Math.max(1, distance - maxDistance); i <= distance + maxDistance; i++) {

			Node child = children.get(i);

			if (child != null) {
				compatibleWord.addAll(child.search(no, maxDistance, calculator));
			}
		}
		return compatibleWord;

	}

	public BurkhardKellerSearchResult search2(String no, int maxDistance, DistanceCalculator calculator) {

		BurkhardKellerSearchResult compatibleWord = new BurkhardKellerSearchResult(maxDistance);

		this.distance = (int) Math.round(calculator.distance(word, no));
		if (distance <= maxDistance) {
			compatibleWord.add(word);
		}

		if (children.size() == 0) {
			return compatibleWord;
		}

		for (int i = Math.max(1, distance - maxDistance); i <= distance + maxDistance; i++) {

			Node child = children.get(i);

			if (child != null) {
				// TODO
				/*
				 * compatibleWord.add(child.search(no, maxDistance,
				 * calculator));
				 */
			}
		}
		return compatibleWord;

	}

	public boolean equals(Node node) {
		return word.equals(node.word);
	}

	public String getWord() {
		return word;
	}

	public int compareTo(Node node) {
		if (this.distance < node.getDistance()) {
			return -1;
		}
		if (this.distance > node.getDistance()) {
			return 1;
		}
		return 0;
	}

}
