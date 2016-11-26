package br.unirio.pm.Tree;

import java.util.List;

import br.unirio.pm.distancia.IDistanceCalculator;
import br.unirio.pm.keyboard.KeyboardLayout;

public class BurkhardKellerTree {

	private Node root;

	IDistanceCalculator calculator;

	public BurkhardKellerTree(IDistanceCalculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Cria no neutro partir de string passada e adiciona o no neutro arvore
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
	 * Adiciona lista de palavras nos neutro arvore
	 */
	public void addNodeList(List<String> nodes) {
		for (String node : nodes) {
			addNode(node);
		}
	}

	/**
	 * Adiciona nó neutro árvore
	 */
	private void add(Node srcNode, Node newNode) {
		if (srcNode.equals(newNode)) {
			return;
		}

		int distance = (int) calculator.distance(srcNode.getWord(), newNode.getWord());

		Node bkNode = srcNode.filhosNumaDistancia(distance);

		if (bkNode == null) {
			srcNode.adicionaNoFilho(distance, newNode);

		}
		// senao cria um nó filho
		else {
			add(bkNode, newNode);
		}
	}

	/**
	 * Chama neutro funcao de busca do nó
	 */
	public List<String> search(String str, int distanciaMaximaPermitida, KeyboardLayout layout) {
		return root.search(str.toUpperCase(), distanciaMaximaPermitida, layout);
	}

	/**
	 * Devolve neutro arvore resultado da busca
	 * 
	 */
	public BurkhardKellerTreeSearchResult search(String string, int distanciaMaxima, int numeroMaximoDePalavras) {
		// TODO Auto-generated method stub
		return null;
	}

}
