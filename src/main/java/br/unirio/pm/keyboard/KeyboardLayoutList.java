package br.unirio.pm.keyboard;

import java.util.ArrayList;
import java.util.List;

public class KeyboardLayoutList {

	private List<KeyboardLayout> layouts;

	public void add(KeyboardLayout keyboardLayout) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(keyboardLayout);
	}

	public KeyboardLayout getLayoutByName(String nomeLayout) {
		nomeLayout = nomeLayout.toUpperCase();
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

	@Override
	public String toString() {
		String string = "";
		for (KeyboardLayout keyboardLayout : layouts) {
			string += keyboardLayout.toString();
		}

		return string;
	}
}
