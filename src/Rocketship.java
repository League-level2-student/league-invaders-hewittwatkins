import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int X, int Y, int W, int H) {
		super(X, Y, W, H);
		speed = 20;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void right() {
        if (x < (LeagueInvaders.WIDTH - width))
        	x+=speed;
    }
	
	public void left() {
		if (x > 0)
			x-=speed;
    }
	
	public void up() {
		if (y > 0)
			y-=speed;
    }
	
	public void down() {
		if (y < (LeagueInvaders.HEIGHT - height - 23))
			y+=speed;
    }

}
