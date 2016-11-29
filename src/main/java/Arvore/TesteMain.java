package Arvore;

import java.util.ArrayList;
import java.util.List;

import br.unirio.pm.Tree.BurkhardKellerTree;
import br.unirio.pm.distancia.DamerauLevenshteinCalculator;
import br.unirio.pm.distancia.DistanceCalculator;
import br.unirio.pm.distancia.LevenshteinCalculator;
import br.unirio.pm.keyboard.KeyboardLayout;
import br.unirio.pm.keyboard.KeyboardLayoutList;
import br.unirio.pm.keyboard.KeyboardLayoutNeutro;
import br.unirio.pm.readers.DictionaryReader;
import br.unirio.pm.readers.KeyboardLayoutReader;

public class TesteMain {

	public static void main(String[] args) {

		leve();
		/* dadadadada(); */
		/* novo(); */
		/* keyboard(); */
		querty();
	}

	private static void keyboard() {
		KeyboardLayoutList keyboardLayoutList = new KeyboardLayoutReader().loadFromFile("layouts.xml");
		List<KeyboardLayout> list = keyboardLayoutList.getList();
		System.out.println(list.size());
		System.out.println(keyboardLayoutList);

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

		KeyboardLayout layout = new KeyboardLayoutNeutro();
		layout.prepareDistances();
		DistanceCalculator calculator = new LevenshteinCalculator(layout);
		BurkhardKellerTree tree = new BurkhardKellerTree(calculator);

		ArrayList<String> palavras = DictionaryReader.fileReader("dictionary_pt-br.zip");
		tree.addNodeList(palavras);

		System.out.println("teclado neutro");
		String palavra = "cervega";
		System.out.println(palavra);
		List<String> results = tree.search(palavra, 2, calculator);
		System.out.println(results);
		System.out.println("Mel");
		results = tree.search("mel", 1, calculator);
		System.out.println(results);
	}

	private static void querty() {

		KeyboardLayoutList list = new KeyboardLayoutReader().loadFromFile("layouts.xml");
		KeyboardLayout layout = list.getLayoutByName("QWERTY");
		System.out.println(layout.getModel());
		layout.prepareDistances();
		DistanceCalculator calculator = new LevenshteinCalculator(layout);
		BurkhardKellerTree tree = new BurkhardKellerTree(calculator);

		ArrayList<String> palavras = DictionaryReader.fileReader("dictionary_pt-br.zip");
		tree.addNodeList(palavras);

		System.out.println("teclado querty");
		String palavra = "cervega";
		System.out.println(palavra);
		List<String> results = tree.search(palavra, 1, calculator);
		System.out.println(results);
		System.out.println("Mel");
		results = tree.search("mel", 1, calculator);
		System.out.println(results);
	}

	public static void novo() {

		KeyboardLayout layout = new KeyboardLayoutNeutro();
		layout.prepareDistances();
		DistanceCalculator calculator = new LevenshteinCalculator(layout);
		BurkhardKellerTree tree = new DictionaryReader().loadFromFile("dictionary_pt-br.zip", calculator);

		List<String> palavras = tree.search("Casa", 1, calculator);
		System.out.println(palavras);

	}
}
