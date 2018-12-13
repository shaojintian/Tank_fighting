package Tank_fight;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Army extends Tank{
	Random rand=new Random();
	public Army(double x,double y) {
		super(x,y);
		this.x=rand.nextInt(500);	
		this.y=rand.nextInt(500);
		
		
		
		file =new File ("src/image/army.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void move(Rectangle2D bounds) {
		
		x+=dx;
		y+=dy;
		dx=dy=rand.nextInt(20)-10;
		if (x<bounds.getMinX()) {
			dx=-dx;
			x=bounds.getMinX();
		}
		if(x+size>=bounds.getMaxX()) {
			dx=-dx;
			x=bounds.getMaxX()-size;
		}
		if (y<bounds.getMinY()) {
			dy=-dy;
			y=bounds.getMinY();
		}
		if(y+size>=bounds.getMaxY()) {
			dy=-dy;
			y=bounds.getMaxY()-size;
		}
		
	}

		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
