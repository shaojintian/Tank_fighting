package TankFighting;


import java.util.Vector;

//坦克父类  可以设置坦克出现位置（x，y）
class Tank {
    int x = 0;
    int y = 0;
    int speed = 8;
    int Direct = 0;
    int color;
    boolean isLive = true;
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDirect() {
        return Direct;
    }

    public void setDirect(int direct) {
        Direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //constructor
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // 视频中是把移动放在hero类中

}

// 敌方坦克
// 需要做成线程类
class EnemyTank extends Tank  {

    int time = 0;
    //定义一个向量存放敌人的子弹
    Vector<Shot> ss = new Vector<Shot>();
    //敌人添加子弹，在刚刚创建坦克的时候
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    
//    public void run() { 
//        while (true) {
//            try {
//                Thread.sleep(50);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            switch (Direct) {
//            case 0:
//                for(int i=0;i<3;i++){
//                    if(y>0)
//                    y-=speed;
//                    try {
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                //说明坦克正在向上移动
//                break;
//            case 1:
//                for(int i=0;i<3;i++){
//                    if(y<300)
//                    y+=speed;
//                    try {
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//            case 2:
//                for(int i=0;i<3;i++){
//                    if(x>0)
//                    x-=speed;
//                    try {
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//            case 3:
//                for(int i=0;i<3;i++){
//                    if(x<400)
//                    x+=speed;
//                    try {
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//            default:
//                break;
//            }
//            time++;
//            if(time%2==0){
//                if(isLive){
//                    if(ss.size()<8){
//                        Shot s = null;
//                        //没有子弹了  就添加
//                        switch(Direct){
//
//                        case 0:
//                            // 创建一颗子弹
//                            s = new Shot(x + 8, y - 4, 0);
//                            // 把子弹加入向量
//                            ss.add(s);
//                            break;
//                        case 1:
//                            s = new Shot(x + 9, y + 32, 1);
//                            ss.add(s);
//                            break;
//                        case 2:
//                            s = new Shot(x - 8, y + 8, 2);
//                            ss.add(s);
//                            break;
//                        case 3:
//                            s = new Shot(x + 32, y + 9, 3);
//                            ss.add(s);
//                            break;
//                        default:
//                            break;
//                        }
//                        //启动子弹线程
//                        Thread t = new Thread(s);
//                        t.start();
//                    }
//                }
//            }
//
//
//            //让坦克随机产生新的方向
//            Direct =  (int)(Math.random()*4);
//            //判断敌人坦克是否死亡
//            if(isLive==false){
//                //让坦克死亡，退出线程
//                break;
//            }
//
//        }
//    }
//}

// 我的英雄坦克
static class Hero extends Tank {

    // 子弹

    Vector<Shot> ss = new Vector<Shot>();
    Shot s = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    // 开火
    public void shotEnemy() {

        switch (Direct) {
        case 0:
            // 创建一颗子弹
            s = new Shot(x + 8, y - 4, 0);
            // 把子弹加入向量
            ss.add(s);
            break;
        case 1:
            s = new Shot(x + 9, y + 32, 1);
            ss.add(s);
            break;
        case 2:
            s = new Shot(x - 8, y + 8, 2);
            ss.add(s);
            break;
        case 3:
            s = new Shot(x + 32, y + 9, 3);
            ss.add(s);
            break;
        default:
            break;
        }
        Thread t = new Thread(s);
        t.start();
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }
    
}

    
}

// 子弹类
class Shot implements Runnable {
    int x;
    int y;
    int Direct;
    int speed = 1;
    boolean isLive = true;

    public Shot(int x, int y, int Direct) {
        this.x = x;
        this.y = y;
        this.Direct = Direct;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
            switch (Direct) {
            case 0:
                y -= speed;
                break;
            case 1:
                y += speed;
                break;
            case 2:
                x -= speed;
                break;
            case 3:
                x += speed;
                break;
            default:
                break;
            }

            // System.out.println(""+x+" "+y);
            // 子弹何时死亡
            if (x < 0 || x > 400 || y < 0 || y > 300) {
                this.isLive = false;
                break;
            }
        }
    }
}

class Bomb {
    int x;
    int y;
    // 炸弹的生命
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 减少生命值
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
