package br.unirio.pm.keyboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardLayoutList implements Iterable<KeyboardLayout> {

	private List<KeyboardLayout> layouts;

	public void add(KeyboardLayout keyboardLayout) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(keyboardLayout);
	}

	public KeyboardLayout getLayoutByName(String nomeLayout) {
		KeyboardLayout layout = null;
		for (KeyboardLayout keyboardLayout : layouts) {
			if (keyboardLayout.getModel().equals(nomeLayout)) {
				layout = keyboardLayout;
			}
		}
		return layout;
	}

	/**
	 * Retorna lista de layouts
	 */
	public List<KeyboardLayout> getList() {
		return layouts;
	}

	public void setList(List<KeyboardLayout> list) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		this.layouts = list;
	}

	public Iterator<KeyboardLayout> iterator() {
		Iterator<KeyboardLayout> iterador = layouts.iterator();
		return iterador;
	}

}
