package br.unirio.pm.spellcheker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardLayoutList {

	private List<KeyboardLayout> layouts;

	public KeyboardLayoutList() {

	}

	public void add(KeyboardLayout p) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(p);
	}

	public KeyboardLayout getLayoutByName(String string) {
		KeyboardLayout layout = null;
		for (KeyboardLayout keyboardLayout : layouts) {
			if (keyboardLayout.getModel().equals(string)) {
				layout = keyboardLayout;
			}
		}
		return layout;

	}

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "\n";

		for (KeyboardLayout keyboardLayout : layouts) {
			s += keyboardLayout.toString();
		}

		return s;
	}

}
