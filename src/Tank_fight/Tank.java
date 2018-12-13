package Tank_fight;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class Tank extends JPanel{
	/**
	 * 
	 * attributes: size,x,y,speed,color
	 * @param args
	 * functions:move,paint
	 */
	
	protected double x,y;
	protected int size;
	protected double dx,dy;
	private Color c;
	protected Image image;
	protected File file;
	public Tank(double x,double y)  {
		Random rand =new  Random();
		this.x=x;
		this.y=y;
//		x=rand.nextInt(300);	
//		y=rand.nextInt(300);	
		size=rand.nextInt(10)+100;
		dx=0;
		dy=0;
		c=new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		file =new File ("src/image/tank.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double get_dx() {
		return this.dx;
	}
	public double get_dy() {
		return this.dy;
	}
	public void move(Rectangle2D bounds) {
		x+=dx;
		y+=dy;
		//bounce edges to reverse direction
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
		
	
	public void paint(Graphics g) {
		
		g.setColor(c);
		g.drawImage(image, (int)x, (int)y, size,size, null);
//		g.fillOval((int)x, (int)y, size, size);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
