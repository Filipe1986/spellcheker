package Arvore;

import java.util.ArrayList;
import java.util.List;

import br.unirio.pm.spellcheker.BurkhardKellerTree;
import br.unirio.pm.spellcheker.DictionaryReader;

public class TesteMain {

	public static void main(String[] args) {
		BurkhardKellerTree tree = new BurkhardKellerTree();
		ArrayList<String> palavras = DictionaryReader.lerArquivo("dictionary_pt-br.zip");
		tree.adicionaListaDeNo(palavras);

		String palavra = "CENARIO";

		List<String> results = tree.busca(palavra, 1);
		System.out.println(results);

	}
}
