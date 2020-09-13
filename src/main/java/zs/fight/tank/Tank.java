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

    public Tank() {
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void print(Graphics g) {
        g.fillRect(x,y,50,50);

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