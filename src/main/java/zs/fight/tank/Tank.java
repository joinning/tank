package zs.fight.tank;

import lombok.Data;

import java.awt.*;
import java.util.Random;

/**
 * 坦克
 *
 * @author : zhenshuo
 * @date: 2020/09/13 13:06
 */
@Data
public class Tank {

    private int x,y;
    private Dir dir= Dir.DOWN;
    private final int SPEED = 5;
    private TankFrame tankFrame;

    public static final int WIDTH = ResourceMgr.tankGoodL.getWidth(),HEIGHT = ResourceMgr.tankGoodL.getHeight();

    /**
     * 移动为 false
     */
    private boolean moving = true;

    /**
     * 坦克是否存活
     */
    private boolean living = true;

    private Random random  = new Random();

    private Group group = Group.BAD;
    Rectangle rectangle = new Rectangle();


    public Tank() {
    }

    public Tank(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if(!living){
            tankFrame.tankList.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(this.group.equals(Group.GOOD) ? ResourceMgr.tankGoodL : ResourceMgr.tankBadL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group.equals(Group.GOOD) ? ResourceMgr.tankGoodU : ResourceMgr.tankBadU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group.equals(Group.GOOD) ? ResourceMgr.tankGoodR : ResourceMgr.tankBadR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group.equals(Group.GOOD) ? ResourceMgr.tankGoodD : ResourceMgr.tankBadD,x,y,null);
                break;
                default:break;
        }
        move();
    }

    private void move() {
        if(!moving){
            return;
        }
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }


        // 随机发射子弹
        if(this.group == Group.BAD && random.nextInt(100) > 95){
            this.fire();
        }
        // 随机更换方向
        if(this.group == Group.BAD && random.nextInt(100) > 95){
            randomDir();
        }
        
        boundsCheck();

        // 更新 rect 的值
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    // 边界检测
    private void boundsCheck() {
        if(this.x < 0){
            x = 0;
        }
        if(this.y < 0){
            y = 0;
        }
        if(this.x > TankFrame.WIDTH - WIDTH){
            x = TankFrame.WIDTH - WIDTH;
        }
        if(this.y > TankFrame.HEIGHT - HEIGHT){
            y = TankFrame.HEIGHT - HEIGHT;
        }
    }

    // 在移动的时候随机更换方向
    private void randomDir() {
        if(group.equals(Group.GOOD)){
            return;
        }
        this.dir = Dir.values()[random.nextInt(4)];

    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        tankFrame.bulletList.add(new Bullet(bX,bY,this.dir,group,this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}