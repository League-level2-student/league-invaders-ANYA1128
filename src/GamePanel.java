import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font instructionsFont;
	Font scoreFont;
	Timer frameDraw;
	Rocketship rocketShip = new Rocketship(250, 700, 50, 50);
ObjectManager obj = new
	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instructionsFont = new Font("Arial", Font.PLAIN, 23);
		scoreFont = new Font("Arial", Font.PLAIN, 35);
		frameDraw = new Timer(1000 / 100, this);
		frameDraw.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		}

		else if (currentState == GAME) {
			drawGameState(g);
		}

		else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
	}

	void updateGameState() {
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 80);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.drawString("Press SPACE for instructions", 95, 600);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocketShip.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 97, 130);
		g.setFont(scoreFont);
		g.drawString("You killed enemies", 96, 350);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to restart", 120, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action");
		repaint();
		if (currentState == MENU) {
			updateMenuState();
		}

		else if (currentState == GAME) {
			updateGameState();
		}

		else if (currentState == END) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP && rocketShip.y >= 0) {
			System.out.println("UP");
			rocketShip.up();

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && rocketShip.y <= 710) {
			System.out.println("DOWN");
			rocketShip.down();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && rocketShip.x >= 0) {
			System.out.println("LEFT");
			rocketShip.left();

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocketShip.x <= 450) {
			System.out.println("RIGHT");
			rocketShip.right();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
