package br.unirio.pm.readers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.unirio.pm.keyboard.KeyboardLayout;
import br.unirio.pm.keyboard.KeyboardLayoutList;
import br.unirio.pm.keyboard.Line;

public class KeyboardLayoutReader {

	public static KeyboardLayoutList reloadFromFile() {
		KeyboardLayoutList keylaylist = new KeyboardLayoutList();
		try {
			File fXmlFile = new File("layouts.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("layout");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					KeyboardLayout kl = new KeyboardLayout();
					Element eElement = (Element) nNode;
					kl.setModel(eElement.getAttribute("model"));
					for (int i = 0; i < 3; i++) {
						Line line = new Line();
						String content = eElement.getElementsByTagName("line").item(i).getTextContent();
						line.setLetters(content);
						kl.addLine(line);
						String offset = ""
								+ eElement.getElementsByTagName("line").item(i).getAttributes().getNamedItem("offset");
						if (!offset.equals("null")) {
							offset = offset.substring(8, offset.length() - 1);
							Double cont = Double.parseDouble(offset);
							line.setOffset(cont);
						}
						keylaylist.add(kl);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keylaylist;
	}

	public KeyboardLayoutList loadFromFile(String string) {
		KeyboardLayoutList keylaylist = new KeyboardLayoutList();
		try {
			File fXmlFile = new File("layouts.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("layout");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					KeyboardLayout kl = new KeyboardLayout();
					Element eElement = (Element) nNode;
					kl.setModel(eElement.getAttribute("model"));

					for (int i = 0; i < 3; i++) {
						Line line = new Line();
						String content = eElement.getElementsByTagName("line").item(i).getTextContent();
						line.setLetters(content);
						kl.addLine(line);
						String offset = ""
								+ eElement.getElementsByTagName("line").item(i).getAttributes().getNamedItem("offset");
						if (!offset.equals("null")) {
							offset = offset.substring(8, offset.length() - 1);
							Double cont = Double.parseDouble(offset);
							line.setOffset(cont);
						}

					}
					keylaylist.add(kl);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keylaylist;
	}
}