package Arvore;

import java.util.ArrayList;
import java.util.List;

/*import LeitorDeArquivoZip;*/

public class TesteMain {

	public static void main(String[] args) {
		ArvoreBK tree = new ArvoreBK();
		ArrayList<String> palavras = LeitorDeArquivoZip.lerArquivo("dictionary_pt-br.zip", "dictionary pt-br.dic");
		tree.adicionaListaDeNo(palavras);

		String palavra = "Filipe";

		List<String> results = tree.busca(palavra, 2);
		System.out.println(results);

	}
}
