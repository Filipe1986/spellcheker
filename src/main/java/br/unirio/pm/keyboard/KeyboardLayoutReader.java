package br.unirio.pm.keyboard;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class KeyboardLayoutReader {

	public KeyboardLayoutList loadFromFile(String filePath) {

		KeyboardLayoutList keyboardLayoutList = new KeyboardLayoutList();

		File file = new File(filePath);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(file);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("layout");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					KeyboardLayout keyboardLayout = new KeyboardLayout();

					Element eElement = (Element) nNode;

					keyboardLayout.setModel(eElement.getAttribute("model"));

					for (int i = 0; i < 3; i++) {
						Line line = new Line();

						String letters = eElement.getElementsByTagName("line").item(i).getTextContent();
						line.setLetters(letters);
						keyboardLayout.addLine(line);

						String offsetString = eElement.getElementsByTagName("line").item(i).getAttributes()
								.getNamedItem("offset").toString();

						if (!offsetString.equals("null")) {

							Double offsetDouble = Double
									.parseDouble(offsetString.substring(8, offsetString.length() - 1));

							line.setOffset(offsetDouble);
						}

						keyboardLayoutList.add(keyboardLayout);
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return keyboardLayoutList;
	}
}
