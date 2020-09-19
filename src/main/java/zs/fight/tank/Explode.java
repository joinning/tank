package zs.fight.tank;

import java.awt.*;

/**
 * 爆炸效果
 * @author : zhenshuo
 * @date: 2020/09/19 10:30
 */
public class Explode {

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth(),HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x,y;
    private TankFrame tankFrame;

    private int step = 0;

    /**
     * 坦克是否存活
     */
    private boolean living = true;

    public Explode() {
    }

    public Explode(int x, int y, TankFrame tankFrame) {


        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }


    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length){
            tankFrame.explodes.remove(this);
        }
    }
}