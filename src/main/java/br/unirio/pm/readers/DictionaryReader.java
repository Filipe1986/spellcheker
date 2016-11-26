package br.unirio.pm.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import br.unirio.pm.Tree.BurkhardKellerTree;
import br.unirio.pm.distancia.IDistanceCalculator;

public class DictionaryReader {

	public BurkhardKellerTree loadFromFile(String fileName, IDistanceCalculator calculator) {

		ArrayList<String> words = new ArrayList<String>();

		BurkhardKellerTree bkTree = new BurkhardKellerTree(calculator);

		try {
			ZipFile zf = new ZipFile(fileName);

			ZipEntry entry = zf.entries().nextElement();

			InputStream inputStream = zf.getInputStream(entry);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(isr);
			String line;
			while ((line = buffer.readLine()) != null) {
				line.replaceAll("'", "");
				line.replaceAll("-", "");
				line.replaceAll(".", "");
				bkTree.addNode(line);
				words.add(line);

			}
			zf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bkTree;

	}

	public static ArrayList<String> fileReader(String fileName) {

		ArrayList<String> words = new ArrayList<String>();

		try {
			ZipFile zf = new ZipFile(fileName);

			ZipEntry entry = zf.entries().nextElement();

			InputStream inputStream = zf.getInputStream(entry);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(isr);
			String line;
			while ((line = buffer.readLine()) != null) {
				words.add(line);
			}
			zf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

}
