package Arvore;

import br.unirio.pm.keyboard.KeyboardLayout;
import br.unirio.pm.keyboard.KeyboardLayoutList;
import br.unirio.pm.keyboard.KeyboardLayoutReader;

public class testeIterable {

	public static void main(String[] args) {
		KeyboardLayoutList keyboardLayoutList = new KeyboardLayoutReader().loadFromFile("layouts.xml");
		int i = 0;

		for (KeyboardLayout keyboardLayout : keyboardLayoutList) {
			System.out.println(keyboardLayout);

			System.out.println(i++);
		}

	}

}
