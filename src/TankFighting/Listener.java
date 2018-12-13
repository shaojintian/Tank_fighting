package TankFighting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

import javax.swing.JPanel;

public class Listener implements ActionListener {
	//constructors
	JPanel myPanel=null;
	Hero hero=null;
	Vector<EnemyTank> ets;
	int enSize=0;
	
	public Listener(JPanel myPanel,Hero hero,Vector<EnemyTank> ets,int enSize) {
		this.myPanel=myPanel;
		this.hero=hero;
		this.ets=ets;
		this.enSize=enSize;
	}
	
	
	static final int  MAX=1000;
	//鼠标点击，存档
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("存档")) {
			try {
				OutputStream out =new FileOutputStream("./src/io/output.txt");
				DataOutputStream dout =new DataOutputStream(out);
				//hero 
				dout.writeInt(hero.getX());
				dout.writeInt(hero.getY());
				//enemy
				
				for (int i = 0; i < ets.size(); i++) {
						//dout.writeBoolean(ets.get(i).isLive);
						dout.writeInt(ets.get(i).getX());
						dout.writeInt(ets.get(i).getY());
						
				}
				
				System.out.println("存档成功,x,y="+hero.getX()+" "+hero.getY());
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} else if (e.getActionCommand().equals("读档")){
			try {
				InputStream in= new FileInputStream("./src/io/output.txt");
				DataInputStream din =new DataInputStream(in);
				//hero
				hero.x=din.readInt();
				hero.y=din.readInt();
				
				//enemy
				
				for (EnemyTank enemyTank : ets) {
					//期间死了的话
					
					//enemyTank.isLive=true;
					enemyTank.setX(din.readInt());
					enemyTank.setY(din.readInt());
				}
				
				System.out.println("读档成功"+hero.x+" "+hero.y);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
