package br.unirio.pm.spellcheker;

public class Line {

	private String content;
	private double offset;
	
	public Line()
	{
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getOffset() {
		return offset;
	}

	public void setOffset(double offset) {
		this.offset = offset;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = content +  " " + offset;
		
		return s;
	}
	
}
