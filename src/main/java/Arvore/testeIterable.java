package Arvore;

import br.unirio.pm.keyboard.KeyboardLayoutList;
import br.unirio.pm.readers.KeyboardLayoutReader;

public class testeIterable {

	public static void main(String[] args) {
		KeyboardLayoutList keyboardLayoutList = new KeyboardLayoutReader().loadFromFile("layouts.xml");

	}

}
