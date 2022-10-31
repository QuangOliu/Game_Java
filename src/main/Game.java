package main;

import java.awt.Graphics;

import entities.Player;
import levels.LevelManager;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private Player player;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	private LevelManager levelManager;
	
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}

	private void initClasses() {
		// TODO Auto-generated method stub
		player = new Player(200, 200);
		levelManager = new LevelManager(this);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}


	private void update() {
		player.update();
		levelManager.update();
	}
	
	public void render(Graphics g) {

		levelManager.draw(g);
		player.render(g);
	}
	
	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		double detalU = 0;
		double detalF = 0;

		double previusTime = System.nanoTime();

		int frame = 0;
		int update = 0;

		long lastCheck = System.currentTimeMillis();
		
		while (true) {
			long currentTime = System.nanoTime();

			detalU += (currentTime - previusTime) / timePerUpdate;
			detalF += (currentTime - previusTime) / timePerFrame;
			previusTime = currentTime;

			if (detalU >= 1) {
				update();
				update++;
				detalU--;
			}
			if(detalF >= 1) {
				gamePanel.repaint();
				frame++;
				detalF--;
			}

			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.printf("FPS: " + frame + "UPS: " + update);
				System.out.println("");
				frame = 0;
				update = 0;
			}
		}
	}
}
