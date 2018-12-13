package Tank_fight;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Tank {
	
	public Bullet(double x,double y,double speed_bullet) {
		super(x,y);
		this.x=x;
		this.y=y;
		this.dy=speed_bullet;
		file =new File ("src/image/bullet.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint_(Graphics g,Rectangle2D bounds) {
		
		if(this.dy!=0||this.dx!=0) {
		move(bounds);
		paint(g);
		}
	}
	public void move(Rectangle2D bounds) {
	
		y+=dy;
		
			}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
