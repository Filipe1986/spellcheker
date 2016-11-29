package br.unirio.pm.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import br.unirio.pm.distancia.DamerauLevenshteinCalculator;
import br.unirio.pm.distancia.DistanceCalculator;
import br.unirio.pm.distancia.LevenshteinCalculator;
import br.unirio.pm.keyboard.KeyboardLayout;
import br.unirio.pm.keyboard.KeyboardLayoutList;
import br.unirio.pm.keyboard.KeyboardLayoutNeutro;
import br.unirio.pm.readers.KeyboardLayoutReader;

public class TestWordDistance {

	private static KeyboardLayoutList layouts;

	@BeforeClass
	public static void setup() {
		layouts = new KeyboardLayoutReader().loadFromFile("layouts.xml");

	}

	@Test
	public void testLevenshteintTecladoNeutro() {
		KeyboardLayout layout = new KeyboardLayoutNeutro();
		layout.prepareDistances();

		DistanceCalculator calculator = new DamerauLevenshteinCalculator(layout);

		assertEquals(0, calculator.distance("casa", "casa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "asa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "cas"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casar"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casal"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "causa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casba"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casta"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "caca"), 0.01);

		assertEquals(1.0, calculator.distance("cervega", "cerveja"), 0.01);
		assertEquals(2.0, calculator.distance("cervega", "cereja"), 0.01);
		assertEquals(2.0, calculator.distance("cervega", "corveta"), 0.01);
		assertEquals(2.0, calculator.distance("cervega", "corveia"), 0.01);
		assertEquals(2.0, calculator.distance("cervega", "certeza"), 0.01);

	}

	@Test
	public void testDemerauTecladoNeutro() {
		KeyboardLayout layout = new KeyboardLayoutNeutro();
		layout.prepareDistances();
		DistanceCalculator calculator = new LevenshteinCalculator(layout);

		assertEquals(0.0, calculator.distance("casa", "casa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "asa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "cas"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casar"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casal"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "causa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casba"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casca"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casta"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "caca"), 0.01);

		assertEquals(1.0, calculator.distance("cervega", "cerveja"), 0.01);
		assertEquals(2.0, calculator.distance("cervega", "cereja"), 0.01);
		assertEquals(2.0, calculator.distance("cervega", "cereja"), 0.01);
		assertEquals(3.0, calculator.distance("cervega", "xereta"), 0.01);

	}

	@Test
	public void testLevenshteinTecladoQwerty() {
		KeyboardLayout layout = layouts.getLayoutByName("QWERTY");
		layout.prepareDistances();
		DistanceCalculator calculator = new LevenshteinCalculator(layout);
		// BurkhardKellerTree tree = new
		// DictionaryReader().loadFromFile("dictionary_pt-br.zip", calculator);

		assertEquals(0.0, calculator.distance("casa", "casa"), 0.01);
		assertEquals(0.11, calculator.distance("casa", "cada"), 0.01);
		assertEquals(0.20, calculator.distance("casa", "caca"), 0.01);

		assertEquals(1.0, calculator.distance("casa", "cara"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "fada"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "vaza"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "asa"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "cas"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "casal"), 0.01);
		assertEquals(1.0, calculator.distance("casa", "cacar"), 0.01);
		/*
		 * check(result, 0, "casa", 0.0); check(result, 1, "cada", 0.11);
		 * check(result, 2, "caca", 0.20); check(result, 3, "cara", 0.20);
		 * check(result, 4, "fada", 0.23); check(result, 5, "vaza", 0.23);
		 * check(result, 6, "asa", 0.25); check(result, 7, "cas", 0.25);
		 * check(result, 8, "casal", 0.25); check(result, 9, "casar", 0.25);
		 */

	}

}