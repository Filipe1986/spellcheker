package br.unirio.pm.Tree;

import java.util.List;

import br.unirio.pm.distancia.LevenshteinCalculator;
import br.unirio.pm.keyboard.KeyboardLayout;

public class BurkhardKellerTree {

	private Node raiz;

	public List<String> busca(String str, int distanciaMaximaPermitida) {
		return raiz.busca(str.toUpperCase(), distanciaMaximaPermitida, new KeyboardLayout());
	}

	public BurkhardKellerTreeSearchResult search(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public void adicionaNo(String no) {
		if (no == null || no.isEmpty()) {
		} else {

			Node newNode = new Node(no);
			if (raiz == null) {
				raiz = newNode;
			} else {
				adiciona(raiz, newNode);
			}
		}
	}

	/**
	 * Adiciona lista de strings
	 * 
	 * @param nos
	 */
	public void adicionaListaDeNo(List<String> nos) {
		for (String node : nos) {
			adicionaNo(node);
		}
	}

	/**
	 * 
	 * @param srcNode
	 * @param novoNo
	 */
	private void adiciona(Node srcNode, Node novoNo) {
		if (srcNode.equals(novoNo)) {
			return;
		}

		LevenshteinCalculator levenshteinCalculator = new LevenshteinCalculator(new KeyboardLayout());

		int distancia = levenshteinCalculator.distance(srcNode.getPalavra(), novoNo.getPalavra());

		Node bkNode = srcNode.filhosNumaDistancia(distancia);

		if (bkNode == null) {
			srcNode.adicionaNoFilho(distancia, novoNo);

		}
		// senao cria um nó filho
		else {
			adiciona(bkNode, novoNo);
		}
	}

}
