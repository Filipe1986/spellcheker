package br.unirio.pm.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import br.unirio.pm.Tree.BurkhardKellerTree;
import br.unirio.pm.distancia.DistanceCalculator;

public class DictionaryReader {

	public BurkhardKellerTree loadFromFile(String fileName, DistanceCalculator calculator) {

		BurkhardKellerTree bkTree = new BurkhardKellerTree(calculator);

		try {
			ZipFile zf = new ZipFile(fileName);

			ZipEntry entry = zf.entries().nextElement();

			InputStream inputStream = zf.getInputStream(entry);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(isr);
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.replace("'", "");
				line = line.replace("-", "");
				line = line.replace(".", "");

				bkTree.addNode(line);
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
				line = line.replace("'", "");
				line = line.replace("-", "");
				line = line.replace(".", "");

				words.add(line);
			}
			zf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

}
