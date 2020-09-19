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
    private boolean living = true;
    private TankFrame tankFrame;
    private Group group = Group.BAD;


    public Bullet() {
    }

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if(!living){
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
            living = false;
        }
    }

    /**
     * 碰撞后销毁
     * @param tank
     */
    public void collideWith(Tank tank) {

        if(this.group == tank.getGroup()){
            return;
        }
        // 子弹的矩形
        Rectangle rectangle = new Rectangle(this.x,this.y,WIDTH,HEIGHT);

        // 坦克的矩形
        Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);

        if(rectangle.intersects(tankRec)){
            // 将爆炸的特效展示在坦克中间
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tank.die();
            this.die();
            tankFrame.explodes.add(new Explode(eX,eY,tankFrame));
        }
    }

    private void die() {
        this.living = false;
    }
}