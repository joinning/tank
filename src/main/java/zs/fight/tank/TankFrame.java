package zs.fight.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 类
 *
 * @author : zhenshuo
 * @date: 2020/09/13 11:45
 */
public class TankFrame extends Frame {

    Tank mainTank = new Tank(200,200,Dir.DOWN);

    public TankFrame(){
        setSize(800,600);
        // 不能改变大小
        setResizable(false);
        setTitle("坦克");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        // 关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 提供一个画笔
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("print");
        mainTank.print(g);
    }

    /**
     * 键盘的事件监听器
     */
    class MyKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            // 键盘被按下去的时候调用
            System.out.println("key pressed");
            // 查看是哪个键被按下了
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    default:
                        break;
            }
            
            setMainTankDir();
        }


        @Override
        public void keyReleased(KeyEvent e) {
            // 键起来的时候调用
            System.out.println("key released");
            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {

            if(bL){
                mainTank.setDir(Dir.LEFT);
            }
            if(bU){
                mainTank.setDir(Dir.UP);
            }
            if(bR){
                mainTank.setDir(Dir.RIGHT);
            }
            if(bD){
                mainTank.setDir(Dir.DOWN);
            }
        }

    }
}