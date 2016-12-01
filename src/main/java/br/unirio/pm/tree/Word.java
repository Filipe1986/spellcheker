package br.unirio.pm.tree;

public class Word implements Comparable<Word> {

	private String word;
	private double distance;

	public Word(String word, double distance) {
		this.word = word;
		this.distance = distance;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int compareTo(Word word) {
		if (this.distance < word.getDistance()) {
			return -1;
		}
		if (this.distance > word.getDistance()) {
			return 1;
		}
		return 0;
	}
}
