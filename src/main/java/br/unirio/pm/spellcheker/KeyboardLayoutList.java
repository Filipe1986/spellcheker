package br.unirio.pm.spellcheker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardLayoutList {

	private List<KeyboardLayout> layouts;

	public KeyboardLayoutList() {

	}

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
		// TODO Auto-generated method stub
		return null;
	}

}
