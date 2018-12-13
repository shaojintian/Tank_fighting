package Tank_fight;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Key_listener implements KeyListener {
		private volatile ArrayList<Tank> tanks =new ArrayList<Tank>();
		private volatile ArrayList<Bullet> bullets =new ArrayList<Bullet>();
		protected volatile Bullet new_bullet=null;
		protected Tank current_tank;
		private double speed_tank;
		private double speed_bullet;
		public Key_listener(ArrayList<Bullet> bullets,Tank current_tank,double speed_tank,double speed_bullet) {
			 this.bullets =bullets;	
			 this.current_tank=current_tank;
			 this.speed_tank=speed_tank;
			 this.speed_bullet=speed_bullet;
			 
		}
	
		public void keyTyped(KeyEvent e) {}

	   
	    public void keyPressed(KeyEvent e) {
	    	int code=e.getKeyCode();
	    	if(code==KeyEvent.VK_UP) {
	    		
	    		current_tank.dy=-speed_tank;
	    	}
	    	if(code==KeyEvent.VK_DOWN) {
	    		current_tank.dy=speed_tank;
	    		
	    	}
	    	if(code==KeyEvent.VK_LEFT) {
	    		current_tank.dx=-speed_tank;
	    		
	    	}
	    	if(code==KeyEvent.VK_RIGHT) {
	    		current_tank.dx=speed_tank;
	    		
	    	}
	    	if(code==KeyEvent.VK_A) {
	    		new_bullet=new Bullet(current_tank.x,current_tank.y,speed_bullet);
	    		bullets.add(new_bullet);
	    		
	    		System.out.println("launch");
	    	}
	    }

	   
	    public void keyReleased(KeyEvent e) {
	    	int code =e.getKeyCode();
	    	if(code==KeyEvent.VK_DOWN||code==KeyEvent.VK_UP) {
	    	current_tank.dy=0;
	    	}
	    	if(code==KeyEvent.VK_LEFT||code==KeyEvent.VK_RIGHT) {
		    current_tank.dx=0;
		    }
	    	
	    	
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
