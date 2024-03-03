package engine.map;

public class Block {
	private int line;
	private int column;
	private String element;

	public Block(int ligne, int colonne, String element) {
		this.line = ligne;
		this.column = colonne;
		this.element = element;
	}

	public Block(int ligne, int colonne) {
		this.line = ligne;
		this.column = colonne;
		this.element = "herbe"; //element par défault 
	}


	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String getElement() {
		return element;
	}
	public void setElement (String blockType){
		this.element = blockType;
	}
}
