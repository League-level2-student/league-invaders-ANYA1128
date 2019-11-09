import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager extends GameObject {
	Rocketship rocket;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens = new ArrayList();
	Random random = new Random();

	ObjectManager(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
		
	}
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update(){
	for(int i =0;i<aliens.size();i++) {
		aliens.get(i).update();
		if(aliens.get(i).y<=LeagueInvaders.HEIGHT) {
			isActive = false;
		}
	}
	
}
void draw(Graphics g) {
	for(int i =0;i<aliens.size();i++) {
		aliens.get(i).draw(g);
	}
	for(int i =0;i<projectiles.size();i++) {
		projectiles.get(i).draw(g);
	}
}
void purgeObjects() {
	for(int i =0;i<aliens.size();i++) {
		if(aliens.get(i).isActive==false) {
			aliens.remove(aliens);
			
		}
	}
	for(int i =0;i<projectiles.size();i++) {
		if(projectiles.get(i).isActive==false) {
			projectiles.remove(projectiles);
			
		}
	}
}
}
