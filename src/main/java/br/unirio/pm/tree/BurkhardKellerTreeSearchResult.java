package br.unirio.pm.tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Árvore de ordenação
 * 
 * @author Filipe
 *
 */
public class BurkhardKellerTreeSearchResult {

	private ArrayList<Word> words;

	public BurkhardKellerTreeSearchResult(ArrayList<Word> words) {
		this.words = words;

		for (Word word : words) {
			System.out.println(word.getWord());
		}
		Collections.sort(words);

	}

	public String getWord(int position) {
		return words.get(position).getWord();
	}

	public double getDistance(int position) {
		return words.get(position).getDistance();
	}

}
