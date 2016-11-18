package Arvore;

import java.util.List;

/*import No;*/

public class ArvoreBK {

	private No raiz;

	public List<String> busca(String str, int distanciaMaximaPermitida) {
		return raiz.busca(str.toUpperCase(), distanciaMaximaPermitida);
	}

	public void adicionaNo(String no) {
		if (no == null || no.isEmpty()) {
		} else {

			No newNode = new No(no);
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
	private void adiciona(No srcNode, No novoNo) {
		if (srcNode.equals(novoNo)) {
			return;
		}

		//
		int distancia = Util.computeLevenshteinDistance(srcNode.getPalavra(), novoNo.getPalavra());
		// Verifica a existencia de um nó na distancia
		No bkNode = srcNode.filhosNumaDistancia(distancia);
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
