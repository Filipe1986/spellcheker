package br.unirio.pm.Tree;

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

	public String getWord(int position) {
		return "";
	}

	public double getDistance(int position) {
		return (Double) null;
	}

	public void addNode(Node node) {
		if (numberOfNodes < lenght) {

			numberOfNodes++;
		} else if (node.getDistance() < nodes.last().getDistance()) {
			nodes.remove(nodes.last());
			nodes.add(node);
		}
	}

	public void add(String word) {
		Node node = new Node(word);
		addNode(node);
	}

}
