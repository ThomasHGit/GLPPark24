package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import engine.map.Map;
import engine.mobile.Curseur;
import engine.process.ParcManager;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private ParcManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, ParcManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

		Curseur Curseur = manager.getCurseur();
		paintStrategy.paint(Curseur, g);
	}
}
