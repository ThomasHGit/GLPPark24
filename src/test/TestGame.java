package test;

import gui.MainGUI;

public class TestGame {
	public static void main(String[] args) {
		MainGUI gameMainGUI = new MainGUI("Parc d'attraction");
		Thread gameThread = new Thread(gameMainGUI);//thread pour l'écoulement du temps
		gameThread.start();
	}
}
