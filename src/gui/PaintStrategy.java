package gui;

import java.awt.Color;
import java.awt.Graphics;

import config.ParcConfig;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Curseur;

public class PaintStrategy {
	public void paint(Map map, Graphics graphics) {
		int blockSize = ParcConfig.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				if (true) {
					if (block.getElement() == "herbe") {
						graphics.setColor(Color.GREEN.darker());
						graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
						graphics.setColor(Color.GRAY.darker().darker());
						graphics.drawRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
					} 
					else if (block.getElement() == "chemin") {
						graphics.setColor(Color.GRAY);
						graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
						graphics.setColor(Color.GRAY.darker().darker());
						graphics.drawRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
					}

					else if (block.getElement() == "carrousel") {
						graphics.setColor(Color.RED.darker());
						graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
						graphics.setColor(Color.GRAY.darker().darker());
						graphics.drawRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
					
					}
					else {
						graphics.setColor(Color.BLACK);
						graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
						graphics.setColor(Color.GRAY.darker().darker());
						graphics.drawRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
					}
				}
				/*else {
					if ((lineIndex + columnIndex) % 2 == 0) {
						graphics.setColor(Color.GRAY.darker());
						graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
					} else {
						graphics.setColor(Color.GRAY.darker().darker());
						graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize,
								blockSize);
					}
				}*/
			}
		}
	}
	/*
	 * public void paintBlock(Curseur curseur, Graphics graphics) {
	 * Block position = curseur.getPosition();
	 * 
	 * int blockSize = ParcConfig.BLOCK_SIZE;
	 * if (position.getElement() == "chemin") {
	 * graphics.setColor(Color.GRAY);
	 * graphics.fillRect(position.getColumn() * blockSize, position.getLine() *
	 * blockSize, blockSize,
	 * blockSize);
	 * graphics.setColor(Color.GRAY.darker().darker());
	 * graphics.drawRect(position.getColumn() * blockSize, position.getLine() *
	 * blockSize, blockSize,
	 * blockSize);
	 * } else if (position.getElement() == "herbe") {
	 * graphics.setColor(Color.GREEN.darker());
	 * graphics.fillRect(position.getColumn() * blockSize, position.getLine() *
	 * blockSize, blockSize,
	 * blockSize);
	 * graphics.setColor(Color.GRAY.darker().darker());
	 * graphics.drawRect(position.getColumn() * blockSize, position.getLine() *
	 * blockSize, blockSize,
	 * blockSize);
	 * } else {
	 * graphics.setColor(Color.BLACK);
	 * graphics.fillRect(position.getColumn() * blockSize, position.getLine() *
	 * blockSize, blockSize,
	 * blockSize);
	 * graphics.setColor(Color.GRAY.darker().darker());
	 * graphics.drawRect(position.getColumn() * blockSize, position.getLine() *
	 * blockSize, blockSize,
	 * blockSize);
	 * }
	 * }
	 */

	public void paint(Curseur curseur, Graphics graphics) {
		Block position = curseur.getPosition();
		int blockSize = ParcConfig.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.RED);
		graphics.fillOval(x * blockSize + blockSize * 1 / 8, y * blockSize + blockSize * 1 / 8, blockSize * 3 / 4,
				blockSize * 3 / 4);

	}
}
