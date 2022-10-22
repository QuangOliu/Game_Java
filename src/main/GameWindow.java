package main;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame Jframe;

	public GameWindow(GamePanel gamePanel) {
		Jframe = new JFrame();

		Jframe.setSize(400, 400);
		Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
		Jframe.add(gamePanel);
		Jframe.setLocationRelativeTo(null);
		Jframe.setVisible(true);
	}
}
