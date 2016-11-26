package Arvore;

import java.util.ArrayList;
import java.util.List;

import br.unirio.pm.Tree.BurkhardKellerTree;
import br.unirio.pm.distancia.DamerauLevenshteinCalculator;
import br.unirio.pm.keyboard.KeyboardLayoutNeutro;
import br.unirio.pm.readers.DictionaryReader;

public class TesteMain {

	public static void main(String[] args) {
		leve();
		/* dadadadada(); */
		/* maisUmTest(); */

	}

	private static void maisUmTest() {
		KeyboardLayoutNeutro a = new KeyboardLayoutNeutro();

	}

	private static void dadadadada() {
		System.out.println("Ddadada");
		KeyboardLayoutNeutro layout = new KeyboardLayoutNeutro();
		DamerauLevenshteinCalculator d = new DamerauLevenshteinCalculator(layout);

		double i = d.distance("a", "b");
		System.out.println("esperado = 1" + " encontrado -> " + i);
		i = d.distance("ab", "ba");
		System.out.println("esperado = 1" + " encontrado -> " + i);
		i = d.distance("cook", "cook");
		System.out.println("esperado = 0" + " encontrado -> " + i);
		i = d.distance("coko", "cook");
		System.out.println("esperado = 1" + " encontrado -> " + i);
		i = d.distance("coco", "coco");
		System.out.println("esperado = 0" + " encontrado -> " + i);
		i = d.distance("filipe", "ifilep");
		System.out.println("esperado = 3" + " encontrado -> " + i);

		i = d.distance("lal", "all");
		System.out.println("esperado = 1" + " encontrado -> " + i);

	}

	private static void leve() {
		BurkhardKellerTree tree = new BurkhardKellerTree();
		ArrayList<String> palavras = DictionaryReader.fileReader("dictionary_pt-br.zip");
		tree.addNodeList(palavras);

		String palavra = "Filipe";

		KeyboardLayoutNeutro layout = new KeyboardLayoutNeutro();
		List<String> results = tree.search(palavra, 1, layout);
		System.out.println(results);
	}
}
