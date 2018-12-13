package Tank_fight;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Thread_run extends Thread {
	private Graphics bufferG, g;
	private Rectangle2D bounds;
	private JPanel move_panel;
	private BufferedImage buffer_image;
	private File back_img;
	private Image backGround;
	private Bullet bullet;
	private volatile ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private volatile ArrayList<Tank> tanks = new ArrayList<Tank>();
	private volatile ArrayList<Army> armys = new ArrayList<Army>();

	public Thread_run(Graphics bufferG, Graphics g, Rectangle2D bounds, JPanel move_panel, BufferedImage buffer_image,
			File back_img, Image backGround, ArrayList<Bullet> bullets, ArrayList<Tank> tanks,ArrayList<Army> armys) {
		this.bufferG = bufferG;
		this.g = g;
		this.bounds = bounds;
		this.move_panel = move_panel;
		this.buffer_image = buffer_image;
		this.back_img = back_img;
		this.backGround = backGround;
		this.bullets = bullets;
		this.tanks = tanks;
		this.armys = armys;

	}

	@Override
	public void run() {
		// Thread launch

		while (true) {

			bufferG.drawImage(backGround, 0, 0, 1000, 1000, null);// refresh the screen

			// System.out.println(tanks.size());
			for (int i = 0; i < tanks.size(); i++) {

				Tank tank = tanks.get(i);
				tank.move(bounds);

				tank.paint(bufferG);

			}

			for (int i = 0; i < bullets.size(); i++) {

				Bullet bullet = bullets.get(i);
				bullet.move(bounds);

				bullet.paint(bufferG);

			}

			for (int i = 0; i < armys.size(); i++) {

				Army enemy= armys.get(i);
				enemy.move(bounds);

				enemy.paint(bufferG);

			}

			g.drawImage(buffer_image, 0, 0, 1000, 1000, null);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
