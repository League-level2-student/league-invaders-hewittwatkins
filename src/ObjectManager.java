import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
	Rocketship rocket;
	ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList <Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;
	
	public ObjectManager(Rocketship rocket1) {
		rocket = rocket1;
	}
	
	public void addProjectile(Projectile projectile1) {
		projectiles.add(projectile1);
	}
	
	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
	
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y <= 0) {
				projectiles.get(i).isActive = false;
			}
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}
	
	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	public void purgeObjects() {
			
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
	public void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
				rocket.isActive = false;
			}
			for (int q = 0; q < projectiles.size(); q++) {
			
				if (projectiles.get(q).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(q).isActive = false;
					aliens.get(i).isActive = false;
					score++;
				}
			}
		}
	}
	
	public int getScore() {
		return this.score;
	}
}
