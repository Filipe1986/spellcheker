package br.unirio.pm.spellcheker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DictionaryReader {

	public BurkhardKellerTree loadFromFile(String string, IDistanceCalculator calculator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<String> lerArquivo(String nomeArquivo) {

		ArrayList<String> palavras = new ArrayList<String>();

		try {
			ZipFile zf = new ZipFile(nomeArquivo);

			ZipEntry entry = zf.entries().nextElement();

			InputStream inputStream = zf.getInputStream(entry);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(isr);
			String linha;
			while ((linha = buffer.readLine()) != null) {
				palavras.add(linha);
			}
			zf.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return palavras;
	}

}
