package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MounseInputs;

public class GamePanel extends JPanel {
	private MounseInputs mouseInputs;
	private int frame = 0;
	private float xDetal = 100;
	private float yDetal = 100;
	private float xDir = 0.8f, yDir = 0.9f;
	private long lastCheck = 0;
	private Color color = new Color(123, 23 , 20);

	private int width = 50;
	private int height = 50;
	
	
 	public GamePanel() {
		mouseInputs = new MounseInputs(this);

		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	public void changeX(int value) {
		// TODO Auto-generated method stub
		xDetal += value;
	}

	public void changeY(int value) {
		// TODO Auto-generated method stub
		yDetal += value;
	}

	public void setPosition(int x, int y) {
		this.xDetal = x;
		this.yDetal = y;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		updateRectangle();

		g.setColor(color);
		g.fillRect((int) xDetal, (int) yDetal, width, height);
	}

	private void updateRectangle() {
		// TODO Auto-generated method stub
		xDetal+=xDir;
		yDetal+=yDir;
		if((xDetal + width )> 400 || xDetal < 0) {
			xDir*=-1;
			color = getRnndColor();
		}
		if((yDetal + height)> 400|| yDetal < 0) {
			yDir*=-1;
			color = getRnndColor();
		}
	}

	private Color getRnndColor() {
		Random generator = new Random();
		// TODO Auto-generated method stub
		int r = generator.nextInt(255);
		int g = generator.nextInt(255);;
		int b = generator.nextInt(255);;
		
		return new Color(r,g,b);
	}
}
