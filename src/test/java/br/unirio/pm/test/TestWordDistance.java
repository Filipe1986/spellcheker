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

/**
 * Casos de teste de distance entre palavras
 */
public class TestWordDistance {

	private static KeyboardLayoutList layouts;

	@BeforeClass
	public static void setup() {
		layouts = new KeyboardLayoutReader().loadFromFile("layouts.xml");
	}

	@Test
	public void testDemerauTecladoNeutro() {
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
	public void testLevenshteintTecladoNeutro() {

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

		assertEquals(0.0, calculator.distance("casa", "casa"), 0.01);
		assertEquals(0.11, calculator.distance("casa", "cada"), 0.01);
		assertEquals(0.20, calculator.distance("casa", "caca"), 0.01);
		assertEquals(0.20, calculator.distance("casa", "cara"), 0.01);
		assertEquals(0.23, calculator.distance("casa", "fada"), 0.01);
		assertEquals(0.23, calculator.distance("casa", "vaza"), 0.01);
		// assertEquals(0.25, calculator.distance("casa", "asa"), 0.01);
		assertEquals(0.25, calculator.distance("casa", "cas"), 0.01);
		assertEquals(0.25, calculator.distance("casa", "casal"), 0.01);
		assertEquals(0.25, calculator.distance("casa", "casar"), 0.01);

		assertEquals(0.22, calculator.distance("cervega", "cerveja"), 0.01);
		assertEquals(0.47, calculator.distance("cervega", "cereja"), 0.01);
		assertEquals(0.48, calculator.distance("cervega", "xereta"), 0.01);
		assertEquals(0.54, calculator.distance("cervega", "verbete"), 0.01);
		assertEquals(0.57, calculator.distance("cervega", "careta"), 0.01);
		assertEquals(0.57, calculator.distance("cervega", "ferver"), 0.01);
		assertEquals(0.57, calculator.distance("cervega", "carreta"), 0.01);
		assertEquals(0.58, calculator.distance("cervega", "vereda"), 0.01);

		assertEquals(0.59, calculator.distance("cervega", "refrega"), 0.01);
		assertEquals(0.61, calculator.distance("cervega", "cerca"), 0.01);

	}

	@Test
	public void testLevenshteinTecladoDvorak() {
		KeyboardLayout layout = layouts.getLayoutByName("DVORAK");
		layout.prepareDistances();
		DistanceCalculator calculator = new LevenshteinCalculator(layout);

		assertEquals(0.0, calculator.distance("casa", "casa"), 0.01);
		assertEquals(0.11, calculator.distance("casa", "cana"), 0.01);
		assertEquals(0.11, calculator.distance("casa", "caso"), 0.01);
		assertEquals(0.15, calculator.distance("casa", "cara"), 0.01);
		assertEquals(0.15, calculator.distance("casa", "nasa"), 0.01);
		assertEquals(0.22, calculator.distance("casa", "gana"), 0.01);
		assertEquals(0.22, calculator.distance("casa", "cano"), 0.01);
		assertEquals(0.22, calculator.distance("casa", "gala"), 0.01);
		assertEquals(0.22, calculator.distance("casa", "tala"), 0.01);
		assertEquals(0.22, calculator.distance("casa", "tosa"), 0.01);

		assertEquals(0.26, calculator.distance("cervega", "corveta"), 0.01);
		assertEquals(0.35, calculator.distance("cervega", "corveia"), 0.01);
		assertEquals(0.37, calculator.distance("cervega", "corneta"), 0.01);
		assertEquals(0.44, calculator.distance("cervega", "corrego"), 0.01);
		assertEquals(0.47, calculator.distance("cervega", "cornea"), 0.01);
		assertEquals(0.47, calculator.distance("cervega", "colega"), 0.01);
		assertEquals(0.48, calculator.distance("cervega", "nervura"), 0.01);
		assertEquals(0.49, calculator.distance("cervega", "cerveja"), 0.01);
		assertEquals(0.51, calculator.distance("cervega", "centena"), 0.01);
		assertEquals(0.55, calculator.distance("cervega", "ternura"), 0.01);
	}

}