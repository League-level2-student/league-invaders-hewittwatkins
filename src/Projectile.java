import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	public Projectile(int X, int Y, int W, int H) {
		super(X, Y, W, H);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
	
	public void update() {
		y-=speed;
	}
	
}
