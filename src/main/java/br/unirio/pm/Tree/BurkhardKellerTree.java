package br.unirio.pm.Tree;

import java.util.List;

import br.unirio.pm.distancia.LevenshteinCalculator;
import br.unirio.pm.keyboard.KeyboardLayout;

public class BurkhardKellerTree {

	private Node root;

	/**
	 * Chama a funcao de busca do nó
	 */
	public List<String> search(String str, int distanciaMaximaPermitida) {
		return root.search(str.toUpperCase(), distanciaMaximaPermitida, new KeyboardLayout());
	}

	/**
	 * Devolve a arvore resultado da busca
	 */
	public BurkhardKellerTreeSearchResult search(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Cria no a partir de string passada e adiciona o no a arvore
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
	 * Adiciona lista de palavras nos a arvore
	 */
	public void addNodeList(List<String> nos) {
		for (String node : nos) {
			addNode(node);
		}
	}

	/**
	 * Adiciona nó a árvore
	 */
	private void add(Node srcNode, Node novoNo) {
		if (srcNode.equals(novoNo)) {
			return;
		}

		LevenshteinCalculator levenshteinCalculator = new LevenshteinCalculator(new KeyboardLayout());

		int distance = levenshteinCalculator.distance(srcNode.getPalavra(), novoNo.getPalavra());

		Node bkNode = srcNode.filhosNumaDistancia(distance);

		if (bkNode == null) {
			srcNode.adicionaNoFilho(distance, novoNo);

		}
		// senao cria um nó filho
		else {
			add(bkNode, novoNo);
		}
	}

}
