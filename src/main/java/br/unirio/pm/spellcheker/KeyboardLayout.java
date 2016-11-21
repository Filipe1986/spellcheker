package br.unirio.pm.spellcheker;

import java.util.ArrayList;

public class KeyboardLayout {

	private static final int NUMERO_PADRAO_DE_LETRAS = 26;
	private static final int LetraMaiusculaPraPosicaoNoVetor = 65;
	private String model;
	private ArrayList<Line> lines;

	private ParOrdenado[] tabela;

	public KeyboardLayout() {
		lines = new ArrayList<Line>();

		tabela = new ParOrdenado[NUMERO_PADRAO_DE_LETRAS];
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	public void prepareDistances() {
		double ofssetAbsoluto = 0;
		int altura = 0;
		for (Line line : lines) {
			ofssetAbsoluto += line.getOffset();
			for (int i = 0; i < line.getLength(); i++) {
				char letra = line.charAt(i);

				ParOrdenado parOrdenado = new ParOrdenado(i + ofssetAbsoluto, altura);

				tabela[letra - LetraMaiusculaPraPosicaoNoVetor] = parOrdenado;
			}

			altura++;
		}

	}

	public double getNominalDistance(char c, char d) {
		if (c == d) {
			return 0;
		}
		c = Character.toUpperCase(c);
		d = Character.toUpperCase(d);
		ParOrdenado par1 = tabela[c - LetraMaiusculaPraPosicaoNoVetor];
		ParOrdenado par2 = tabela[d - LetraMaiusculaPraPosicaoNoVetor];

		double diferencaLargura = Math.abs(par1.getX() - par2.getX());

		double diferencaAltura = Math.abs(par1.getY() - par2.getY());

		return dist(diferencaLargura, diferencaAltura);
	}

	public double getInsertDeleteDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMaximumDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String s = model + "\n \n";
		for (Line line : lines) {
			s += line.toString() + "\n";
		}
		return s;
	}

	private double dist(double largura, double altura) {
		if (altura == 0.0) {
			return Math.abs(largura);
		}

		return Math.sqrt(largura * largura + altura * altura);
	}

}
