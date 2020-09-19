package zs.fight.tank;

import lombok.Data;

import java.awt.*;

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
    private final int SPEED = 10;
    private TankFrame tankFrame;

    public static final int WIDTH = ResourceMgr.tankL.getWidth(),HEIGHT = ResourceMgr.tankL.getHeight();

    /**
     * 移动为 false
     */
    private boolean moving = false;

    /**
     * 坦克是否存活
     */
    private boolean living = true;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if(!living){
            tankFrame.tankList.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
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
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        tankFrame.bulletList.add(new Bullet(bX,bY,this.dir,this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}