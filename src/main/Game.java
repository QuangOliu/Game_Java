package main;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;

	public Game() {
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start(); 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double timePerFrame = 1000000000.0/ FPS_SET;
		long now = System.nanoTime();
		int frame = 0;
		long lastCheck = System.currentTimeMillis();
		long lastFrame  = System.nanoTime();
		while (true) {	
			
			now = System.nanoTime();
			if(now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frame++;
			}
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println(frame);
				frame = 0;
			}
		}
	}
}
