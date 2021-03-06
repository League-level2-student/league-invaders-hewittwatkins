import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font menuOptions;
	Timer frameDraw;
	Rocketship rocket1 = new Rocketship(250, 700, 50, 50);
	ObjectManager oM1 = new ObjectManager(rocket1);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer alienSpawn;
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		menuOptions = new Font("Arial", Font.PLAIN, 30);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	public void updateMenuState() {
		
	}
	
	public void updateGameState() {
		oM1.update();
		if (rocket1.isActive == false) {
			currentState = END;
		}
		
	}
	
	public void updateEndState() {
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", (WIDTH / 2), 50);
		g.setFont(menuOptions);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", (WIDTH / 2), 350);
		g.setFont(menuOptions);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", (WIDTH / 2), 450);
		
	}
	
	public void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		oM1.draw(g);
	}
	
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString("GAME OVER", (WIDTH / 2), 50);
		g.drawString("" + oM1.getScore(), (WIDTH / 2), 375);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        rocket1 = new Rocketship(250, 700, 50, 50);
		        oM1 = new ObjectManager(rocket1);
		    } 
		    else if (currentState == MENU) {
		    	
		    	currentState = GAME;
		    	startGame();
		    	
		    } 
		    
		    else if (currentState == GAME) {
		    	
		    	currentState = END;
		    	alienSpawn.stop();
		    	
		    }
		    
		    else {
		        currentState++;
		    }
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    rocket1.up();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    rocket1.down();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    rocket1.left();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    rocket1.right();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			oM1.addProjectile(rocket1.getProjectile());
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	public void startGame() {
		alienSpawn = new Timer(1000, oM1);
		alienSpawn.start();
		
	}
	
}
