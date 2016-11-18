package Arvore;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.unirio.pm.spellcheker.KeyboardLayout;

public class MainXML {

	public static void main(String[] args) {
		XStream xStream = new XStream(new DomDriver());

		KeyboardLayout xml = (KeyboardLayout) xStream.fromXML("layouts.xml");

	}
}
