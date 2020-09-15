package zs.fight.tank;

import lombok.Data;

import java.awt.*;

/**
 * 子弹
 *
 * @author : zhenshuo
 * @date: 2020/09/13 17:22
 */
@Data
public class Bullet {

    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletL.getWidth(),HEIGHT = ResourceMgr.bulletL.getHeight();
    private boolean live = true;
    private TankFrame tankFrame;

    public Bullet() {
    }

    public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if(!live){
            tankFrame.bulletList.remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:break;
        }


        move();
    }

    private void move() {
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
        if(x < 0 || y < 0 || x > TankFrame.WIDTH || y > TankFrame.HEIGHT){
            live = false;
        }
    }
}