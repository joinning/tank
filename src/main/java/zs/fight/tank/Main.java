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

        int initTankCount= Integer.parseInt(PropertyMgr.get("initTankCount").toString());

        // 初始敌方坦克
        for(int i =0;i < initTankCount;i++){
            tankFrame.tankList.add(new Tank(50 + i * 80,200,Dir.DOWN,Group.BAD,tankFrame));
        }

        /**
         * 每隔 50 毫秒刷新 paint，实现移动
         */
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}