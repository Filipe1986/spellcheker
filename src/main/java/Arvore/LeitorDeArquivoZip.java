package Arvore;

/**
 * @authors Bruno Buck Brigagao e Filipe Goncalves
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LeitorDeArquivoZip {

	public static ArrayList<String> lerArquivo(String nomeArquivo, String nomeArquivoInterno) {

		ArrayList<String> palavras = new ArrayList<String>();

		try {
			ZipFile zf = new ZipFile(nomeArquivo);
			ZipEntry entry = zf.getEntry(nomeArquivoInterno);

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