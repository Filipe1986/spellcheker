package br.unirio.pm.tree;

import java.util.List;

import br.unirio.pm.distancia.DistanceCalculator;

public class BurkhardKellerTree {

	private Node root;

	private DistanceCalculator calculator;

	private BurkhardKellerSearchResult result;

	public BurkhardKellerTree(DistanceCalculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Adiciona no partir de string passada e adiciona o no arvore
	 */
	public void addNode(String no) {
		if (no == null || no.isEmpty()) {
		} else {
			Node newNode = new Node(no);
			if (root == null) {
				root = newNode;
			} else {
				add(root, newNode);
			}
		}
	}

	/**
	 * Adiciona lista de palavras na árvore
	 */
	public void addNodeList(List<String> nodes) {
		for (String node : nodes) {
			addNode(node);
		}
	}

	/**
	 * Adiciona nó na árvore de acordo com a distancia do DistanceCalculator
	 */
	private void add(Node srcNode, Node newNode) {
		if (srcNode.equals(newNode)) {
			return;
		}

		int distance = (int) Math.round(calculator.distance(srcNode.getWord(), newNode.getWord()));

		Node bkNode = srcNode.filhosNumaDistancia(distance);

		if (bkNode == null) {
			srcNode.addChildNode(distance, newNode);

		}
		// senao adiciona nó como filho
		else {
			add(bkNode, newNode);
		}
	}

	/**
	 * Funcao para busca de nó com uma distancia máxima
	 */
	public List<String> search(String word, int distanciaMaximaPermitida, DistanceCalculator calculator) {
		return root.search(word.toUpperCase(), distanciaMaximaPermitida, calculator);
	}

	/**
	 * Busca que devolve arvore resultado da busca
	 * 
	 */
	public BurkhardKellerSearchResult search(String word, int distanciaMaxima, int numeroMaximoDePalavras) {
		return root.search2(word.toUpperCase(), distanciaMaxima, calculator);

	}

}
