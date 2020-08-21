import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame;
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	GamePanel gP;
	
	public static void main(String[] args) {
		LeagueInvaders invader1 = new LeagueInvaders();
		invader1.setup();
	}
	
	public LeagueInvaders() {
		frame = new JFrame();
	}
	
	void setup() {
		gP = new GamePanel();
		frame.add(gP);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(gP);
	}

	
}
