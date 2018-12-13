package TankFighting;
import java.util.Vector;

import TankFighting.*;
public class EnemyTank_Thread implements Runnable{
	Vector<EnemyTank> ets =new Vector<EnemyTank>();
	
	//Contructor 
	public  EnemyTank_Thread(Vector<EnemyTank> ets) {
		this.ets=ets;
	}
	
	
	
	
	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < ets.size(); i++) {
				enemy_move(ets.get(i), ets);
			}
		}
	
	}
	
	
	public void enemy_move(EnemyTank enemyTank,Vector<EnemyTank> ets) {
		try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (enemyTank.Direct) {
        case 0:
            for(int i=0;i<3;i++){
                if(enemyTank.y>0)
                enemyTank.y-=enemyTank.speed;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //说明坦克正在向上移动
            break;
        case 1:
            for(int i=0;i<3;i++){
                if(enemyTank.y<300)
                enemyTank.y+=enemyTank.speed;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case 2:
            for(int i=0;i<3;i++){
                if(enemyTank.x>0)
                enemyTank.x-=enemyTank.speed;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case 3:
            for(int i=0;i<3;i++){
                if(enemyTank.x<400)
                enemyTank.x+=enemyTank.speed;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        default:
            break;
        }
        enemyTank.time++;
        if(enemyTank.time%2==0){
            if(enemyTank.isLive){
                if(enemyTank.ss.size()<8){
                    Shot s = null;
                    //没有子弹了  就添加
                    switch(enemyTank.Direct){

                    case 0:
                        // 创建一颗子弹
                        s = new Shot(enemyTank.x + 8, enemyTank.y - 4, 0);
                        // 把子弹加入向量
                        enemyTank.ss.add(s);
                        break;
                    case 1:
                        s = new Shot(enemyTank.x + 9, enemyTank.y + 32, 1);
                        enemyTank.ss.add(s);
                        break;
                    case 2:
                        s = new Shot(enemyTank.x - 8, enemyTank.y + 8, 2);
                        enemyTank.ss.add(s);
                        break;
                    case 3:
                        s = new Shot(enemyTank.x + 32, enemyTank.y + 9, 3);
                        enemyTank.ss.add(s);
                        break;
                    default:
                        break;
                    }
                    //启动子弹线程
                    Thread t = new Thread(s);
                    t.start();
                }
            }
        }


        //让坦克随机产生新的方向
        enemyTank.Direct =  (int)(Math.random()*4);
        //如果死了，就从vector移除
        if(enemyTank.isLive==false) ets.remove(enemyTank);
       
        

	
	}
	

}
