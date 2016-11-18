package br.unirio.pm.spellcheker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardLayoutList {

	private List<KeyboardLayout> layout;

	public KeyboardLayoutList() {

	}

	public void add(KeyboardLayout p) {
		if (layout == null) {
			layout = new ArrayList<KeyboardLayout>();
		}
		layout.add(p);
	}

	public KeyboardLayout getLayoutByName(String string) {
		return null;
	}

	public List<KeyboardLayout> getList() {
		return layout;
	}

	public void setList(List<KeyboardLayout> list) {
		if (layout == null) {
			layout = new ArrayList<KeyboardLayout>();
		}
		this.layout = list;
	}

	public Iterator<KeyboardLayout> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "\n";
				
		for (KeyboardLayout keyboardLayout : layout) 
		{
			s+= keyboardLayout.toString();
		}
		
		
		return s;
	}

}
