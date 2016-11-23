package Arvore;

import java.util.ArrayList;
import java.util.List;

import br.unirio.pm.Tree.BurkhardKellerTree;
import br.unirio.pm.distancia.Damerau;
import br.unirio.pm.distancia.DamerauLevenshteinCalculator;
import br.unirio.pm.readers.DictionaryReader;

public class TesteMain {

	public static void main(String[] args) {
		leve();
		damereu();
		dadadadada();

	}

	private static void dadadadada() {
		DamerauLevenshteinCalculator d = new DamerauLevenshteinCalculator();
		int i = d.distance("cook", "cook");
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

	private static void damereu() {
		Damerau d = new Damerau();
		int i = d.distance("cook", "cook");
		System.out.println(i);

	}

	private static void leve() {
		BurkhardKellerTree tree = new BurkhardKellerTree();
		ArrayList<String> palavras = DictionaryReader.lerArquivo("dictionary_pt-br.zip");
		tree.adicionaListaDeNo(palavras);

		String palavra = "Filipe";

		List<String> results = tree.busca(palavra, 1);
		System.out.println(results);
	}
}
