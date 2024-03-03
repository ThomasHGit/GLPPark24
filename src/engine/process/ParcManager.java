package engine.process;

import config.ParcConfig;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Curseur;

public class ParcManager {
	private Map map;

	private Curseur Curseur;

	public ParcManager(Map map) {
		this.map = map;
	}

	public void set(Curseur Curseur) {
		this.Curseur = Curseur;
	}

	public void moveUpCurseur() {
		Block position = Curseur.getPosition();

		if (position.getLine() > 0) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			Curseur.setPosition(newPosition);
		}

	}

	public void moveDownCurseur() {
		Block position = Curseur.getPosition();

		if (position.getLine() < ParcConfig.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			Curseur.setPosition(newPosition);
		}
	}

	public void moveLeftCurseur() {
		Block position = Curseur.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			Curseur.setPosition(newPosition);
		}

	}

	public void moveRightCurseur() {
		Block position = Curseur.getPosition();

		if (position.getColumn() < ParcConfig.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			Curseur.setPosition(newPosition);
		}
	}
	
	public void moveSetCurseur(Block position) {
		Block newPosition = map.getBlock(position.getLine(), position.getColumn());
		Curseur.setPosition(newPosition);
	}

	public void changeBlock(String blockType) {
		// if (map.getBlock(Curseur.getPosition().getLine() - 1 + i,
		// Curseur.getPosition().getColumn() - 1 + j).getElement())!=""
		map.getBlock(Curseur.getPosition().getLine(), Curseur.getPosition().getColumn()).setElement(blockType);
	}

	public void changeBlock3x3(String blockType) {
		Block position = Curseur.getPosition();
		// vérifie que la structure est placeable sans sortir des bords
		if ((position.getLine() > 0) & (position.getLine() < ParcConfig.LINE_COUNT - 1)
				& (position.getColumn() > 0) & (position.getColumn() < ParcConfig.COLUMN_COUNT - 1)) {
			// vérifie que la structure n'empiète pas sur d'autres
			int v = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if ((map.getBlock(Curseur.getPosition().getLine() - 1 + i,
							Curseur.getPosition().getColumn() - 1 + j).getElement()) != "herbe") {
						v = 1; // le placement n'est pas valide
					}

				}
			}
			if (v == 0) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						map.getBlock(Curseur.getPosition().getLine() - 1 + i, Curseur.getPosition().getColumn() - 1 + j)
								.setElement(blockType);
					}
				}
			}
		}
	}

	public void blockInfo() {
		System.out.println(map.getBlock(Curseur.getPosition().getLine(), Curseur.getPosition().getColumn()).getElement());
		System.out.print("Ligne nº" + Curseur.getPosition().getLine());
		System.out.print(" Colonne nº" + Curseur.getPosition().getColumn()+ "\n");
	}

	public Curseur getCurseur() {
		return Curseur;
	}
}
