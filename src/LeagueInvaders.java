import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame;
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	
	public static void main(String[] args) {
		LeagueInvaders invader1 = new LeagueInvaders();
		invader1.setup();
	}
	
	public LeagueInvaders() {
		this.frame = new JFrame();
	}
	
	void setup() {
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
}
