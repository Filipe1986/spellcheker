package br.unirio.pm.Tree;

import java.util.List;

import br.unirio.pm.distancia.IDistanceCalculator;

public class BurkhardKellerTree {

	private Node root;

	IDistanceCalculator calculator;

	/**
	 * Construtor
	 */
	public BurkhardKellerTree(IDistanceCalculator calculator) {
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
	 * Adiciona nó na árvore
	 */
	private void add(Node srcNode, Node newNode) {
		if (srcNode.equals(newNode)) {
			return;
		}

		int distance = (int) calculator.distance(srcNode.getWord(), newNode.getWord());

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
	 * Funcao para busca de nó com uma distancia maxima
	 */
	public List<String> search(String word, int distanciaMaximaPermitida, IDistanceCalculator calculator1) {
		return root.search(word.toUpperCase(), distanciaMaximaPermitida, calculator1);
	}

	/**
	 * Busca que devolve arvore resultado da busca
	 * 
	 */
	public BurkhardKellerTreeSearchResult search(String word, int distanciaMaxima, int numeroMaximoDePalavras) {
		// TODO Auto-generated method stub
		return null;
	}

}
