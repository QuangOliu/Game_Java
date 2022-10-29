package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entities.Player;
import inputs.KeyboardInputs;
import inputs.MounseInputs;

import utilz.Constaints.PlayerConstaint;
import utilz.Constaints.Directions;

public class GamePanel extends JPanel {
	private MounseInputs mouseInputs;

	private Player player;
	private Game game;

	public GamePanel(Game game) {

		mouseInputs = new MounseInputs(this);
		this.game = game;
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		setWindowSize();
		addMouseMotionListener(mouseInputs);
	}

	private void setWindowSize() {
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(getMinimumSize());
		setPreferredSize(size);
		setMaximumSize(size);
	}

	public void updateGame() {
		player.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.render(g);

	}

	public Game getGame() {
		return game;
	}

}
