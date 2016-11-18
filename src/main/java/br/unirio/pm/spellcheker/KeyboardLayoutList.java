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
		return null;
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

	public List<KeyboardLayout> getLayout() {
		return layouts;
	}

	public void setLayout(List<KeyboardLayout> layout) {
		this.layouts = layout;
	}

}
