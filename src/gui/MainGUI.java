package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


import config.ParcConfig;
import engine.map.Block;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.ParcManager;

public class MainGUI extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//warnings sinon
	/**
	 * 
	 */
	private Map map;
	private ParcManager manager;
	private GameDisplay fenetre;
	
	
	private final static Dimension preferredSize = new Dimension(ParcConfig.LARGEUR,
			ParcConfig.HAUTEUR);


	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		KeyControls keyControls = new KeyControls();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);
		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		fenetre = new GameDisplay(map, manager);
		fenetre.setPreferredSize(preferredSize);
		MouseControls mouseControls = new MouseControls();
		fenetre.addMouseListener(mouseControls);
		contentPane.add(fenetre, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(ParcConfig.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			fenetre.repaint();
		}
	}

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int y = (e.getX())/ParcConfig.BLOCK_SIZE;
			int x = (e.getY())/ParcConfig.BLOCK_SIZE;
			Block b = new Block(x,y);
			manager.moveSetCurseur(b);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

				case 'q':
					manager.moveLeftCurseur();
					break;
				case 'd':
					manager.moveRightCurseur();
					break;
				case 'z':
					manager.moveUpCurseur();
					break;
				case 's':
					manager.moveDownCurseur();
					break;
				// placer un chemin
				case 'c':
					manager.changeBlock("chemin");
					break;
				// placer un herbe
				case 'h':
					manager.changeBlock("herbe");
					break;
				// Carrousel
				case 'l':
					manager.changeBlock3x3("carrousel");
					break;
				case 'i':
					manager.blockInfo();
					break;
				default:
					break;

			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

}