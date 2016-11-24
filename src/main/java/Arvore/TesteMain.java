package Arvore;

import java.util.ArrayList;
import java.util.List;

import br.unirio.pm.Tree.BurkhardKellerTree;
import br.unirio.pm.distancia.DamerauLevenshteinCalculator;
import br.unirio.pm.readers.DictionaryReader;

public class TesteMain {

	public static void main(String[] args) {
		leve();
		dadadadada();

	}

	private static void dadadadada() {
		System.out.println("Ddadada");
		DamerauLevenshteinCalculator d = new DamerauLevenshteinCalculator();

		int i = d.distance("a", "b");
		System.out.println(i);
		i = d.distance("ab", "ba");
		System.out.println(i);
		i = d.distance("cook", "cook");
		System.out.println(i);
		i = d.distance("coko", "cook");
		System.out.println(i);
		i = d.distance("coco", "coco");
		System.out.println(i);
		i = d.distance("filipe", "ifilep");
		System.out.println(i);

		i = d.distance("lal", "all");
		System.out.println(i);

	}

	private static void leve() {
		BurkhardKellerTree tree = new BurkhardKellerTree();
		ArrayList<String> palavras = DictionaryReader.fileReader("dictionary_pt-br.zip");
		tree.addNodeList(palavras);

		String palavra = "Filipe";

		List<String> results = tree.search(palavra, 1);
		System.out.println(results);
	}
}
