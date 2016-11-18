package br.unirio.pm.spellcheker;

import java.util.ArrayList;

public class KeyboardLayout {

	private String model;
	private ArrayList<Line> lines;
	
	public KeyboardLayout()
	{
		lines = new ArrayList<Line>();
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
	
	public void addLine(Line line)
	{
		lines.add(line);
	}

	public void prepareDistances() {
		// TODO Auto-generated method stub
	}

	public double getNominalDistance(char c, char d) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
		String s = model + "\n \n";
		
		for (Line line : lines) {
			s+=line.toString() + "\n";
		}
		
		return s;
	}

}
