package br.unirio.pm.Tree;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Árvore de ordenação
 * 
 * @author Filipe
 *
 */
public class BurkhardKellerSearchResult {

	TreeSet<Node> nodes;
	private int lenght;
	private int numberOfNodes;

	public BurkhardKellerSearchResult(int lenght) {
		this.lenght = lenght;
		numberOfNodes = 0;
		nodes = new TreeSet<Node>();
	}

	public Node getWord(int position) {
		int i = 0;
		Node node = null;
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			i++;
			if (position == i) {
				node = nodes.iterator().next();
			}
		}
		return node;
	}

	/**
	 * 
	 */
	public double getDistance(int position) {
		return (Double) null;
	}

	/**
	 * Adiciona no
	 */
	public void addNode(Node node) {
		if (numberOfNodes < lenght) {

			numberOfNodes++;
		} else if (node.getDistance() < nodes.last().getDistance()) {
			nodes.remove(nodes.last());
			nodes.add(node);
		}
	}

	/**
	 * Adiciona no
	 */
	public void add(String word) {
		Node node = new Node(word);
		addNode(node);
	}

}
