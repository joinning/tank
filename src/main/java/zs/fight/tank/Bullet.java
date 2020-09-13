package zs.fight.tank;

import lombok.Data;

import java.awt.*;
import java.util.HashMap;

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
    private static final int WIDTH = 5,HEIGHT = 5;

    public Bullet() {
    }

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
//        Color color = g.getColor();
//        g.setColor(Color.magenta);
        g.fillOval(x,y,WIDTH, HEIGHT);
        g.setColor(Color.magenta);
        
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
    }
}