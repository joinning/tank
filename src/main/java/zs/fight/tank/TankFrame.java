package zs.fight.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * 类
 *
 * @author : zhenshuo
 * @date: 2020/09/13 11:45
 */
public class TankFrame extends Frame {

    Tank mainTank = new Tank(200,400,Dir.DOWN,this);

    /**
     * 装子弹的容易
     * 需要注意的问题，如果不清理的话，很有可能会造成内存泄露
     */
    ArrayList<Bullet> bulletList = new ArrayList<>();
    ArrayList<Tank> tankList = new ArrayList<>();
    
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    public TankFrame(){
        setSize(WIDTH,HEIGHT);
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
     * 解决双缓冲的问题
     * 消除闪烁问题
     */
    Image offScreenImage = null;

    @Override
    public void update(Graphics g){

        if(offScreenImage == null){
            offScreenImage = this.createImage(WIDTH,HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.black);
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        // 把内存的内容复制到显存
        g.drawImage(offScreenImage,0,0,null);
    }

    /**
     * 提供一个画笔
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bulletList.size(),10,60);
        g.drawString("敌人的数量" + tankList.size(),10,80);
        g.setColor(color);
        mainTank.paint(g);
        for (int i = 0;i < bulletList.size();i++) {
            bulletList.get(i).paint(g);
        }

        for (int i = 0;i < tankList.size();i++) {
            tankList.get(i).paint(g);
        }

        for(int i = 0;i < bulletList.size();i ++){

            for(int j = 0 ;j < tankList.size(); j++){

                bulletList.get(i).collideWith(tankList.get(j));
            }
        }
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
                    break;
                case KeyEvent.VK_CONTROL:
                    mainTank.fire();
                    break;
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

            if(!bL && !bU && !bR && !bD){
                mainTank.setMoving(false);
            }else {
                mainTank.setMoving(true);
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
}