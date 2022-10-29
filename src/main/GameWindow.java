package main;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame Jframe;

	public GameWindow(GamePanel gamePanel) {
		Jframe = new JFrame();

		Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
		Jframe.add(gamePanel);
		Jframe.setResizable(false);
		Jframe.pack();
		Jframe.setLocationRelativeTo(null);
		Jframe.setVisible(true);
	}
}
