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

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;
public class GamePanel extends JPanel {
	private MounseInputs mouseInputs;

	private Player player;
	private Game game;

	public GamePanel(Game game) {

		mouseInputs = new MounseInputs(this);
		this.game = game;
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		setPanelSize();
		addMouseMotionListener(mouseInputs);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);

		System.out.println("size :" + GAME_WIDTH +" : " + GAME_HEIGHT);
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
