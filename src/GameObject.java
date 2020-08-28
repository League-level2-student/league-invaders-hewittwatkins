
public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	
	public GameObject(int X, int Y, int W, int H) {
		this.x = X;
		this.y = Y;
		this.width = W;
		this.height = H;
		speed = 0;
		isActive = true;
	}
	
	public void update() {
		
	}

}
