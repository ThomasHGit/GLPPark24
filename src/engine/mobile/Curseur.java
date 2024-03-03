package engine.mobile;

import engine.map.Block;

public class Curseur{
	private Block position;
	
	public Curseur(Block position) {
		this.position = position;
	}
	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

}
