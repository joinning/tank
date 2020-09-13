package zs.fight.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame 窗口类
 *
 * @author : zhenshuo
 * @date: 2020/08/30 21:52
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tankFrame = new TankFrame();

        /**
         * 每隔 50 毫秒刷新 paint，实现移动
         */
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}