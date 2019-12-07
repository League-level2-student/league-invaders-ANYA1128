import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		super.speed = 10;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("projectile.png");
		}
	}

	public void update() {
		y -= speed;
		super.update();
	
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public void draw(Graphics g) {
		 
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
}
