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

		DistanceCalculator calculator = new LevenshteinCalculator(layout);

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
		DistanceCalculator calculator = new DamerauLevenshteinCalculator(layout);

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

		assertEquals(0.1, calculator.distance("cervega", "cerveja"), 0.01);

		assertEquals(0.47, calculator.distance("cervega", "cereja"), 0.01);
		assertEquals(0.47, calculator.distance("cervega", "cereja"), 0.01);
		assertEquals(0.48, calculator.distance("cervega", "xereta"), 0.01);

		assertEquals(0.54, calculator.distance("cervega", "verbete"), 0.01);
		/*
		 * check(result2, 4, "careta", 0.57); assertEquals(0.47,
		 * calculator.distance("cervega", "cereja"), 0.01); check(result2, 5,
		 * "ferver", 0.57); assertEquals(0.47, calculator.distance("cervega",
		 * "cereja"), 0.01); check(result2, 6, "carreta", 0.57);
		 * assertEquals(0.47, calculator.distance("cervega", "cereja"), 0.01);
		 * check(result2, 7, "vereda", 0.58); assertEquals(0.47,
		 * calculator.distance("cervega", "cereja"), 0.01); check(result2, 8,
		 * "refrega", 0.59); assertEquals(0.47, calculator.distance("cervega",
		 * "cereja"), 0.01); check(result2, 9, "cerca", 0.61);
		 */

		/*
		 * BurkhardKellerSearchResult result3 = tree.search("aviea", 2, 10);
		 * check(result3, 0, "aveia", 1.0); check(result3, 1, "aia", 2.0);
		 * check(result3, 2, "ave", 2.0); check(result3, 3, "via", 2.0);
		 * check(result3, 4, "avioes", 2.0); check(result3, 5, "avisar", 2.0);
		 * check(result3, 6, "avivar", 2.0); check(result3, 7, "alinea", 2.0);
		 * check(result3, 8, "avidez", 2.0); check(result3, 9, "ravina", 2.0);
		 */
	}

}