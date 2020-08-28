import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	
	
	public Alien(int X, int Y, int W, int H) {
		super(X, Y, W, H);
		speed = 1;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
	
	public void update() {
		y+=speed;
	}
}
