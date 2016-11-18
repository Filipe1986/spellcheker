package br.unirio.pm.spellcheker;

public class testeKeyboard 
{
	
	
	public static void main(String[] args) {
		
		KeyboardLayoutList kll = ReadXMLFile.readXML();		
		
		System.out.println(kll);
	}
}
