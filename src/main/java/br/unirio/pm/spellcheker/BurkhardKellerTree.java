package br.unirio.pm.spellcheker;

import java.util.List;

import Arvore.Util;

public class BurkhardKellerTree {

	private Node raiz;

	public List<String> busca(String str, int distanciaMaximaPermitida) {
		return raiz.busca(str.toUpperCase(), distanciaMaximaPermitida);
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

		//
		int distancia = Util.computeLevenshteinDistance(srcNode.getPalavra(), novoNo.getPalavra());
		// Verifica a existencia de um nó na distancia
		Node bkNode = srcNode.filhosNumaDistancia(distancia);
		// Se ele não existe adiciona no hashmap
		if (bkNode == null) {
			srcNode.adicionaNoFilho(distancia, novoNo);

		}
		// senao cria um nó filho
		else {
			adiciona(bkNode, novoNo);
		}
	}

}
