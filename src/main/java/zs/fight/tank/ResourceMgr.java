package zs.fight.tank;

import zs.fight.tank.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 资源管理器
 *
 * @author : zhenshuo
 * @date: 2020/09/15 21:33
 */
public class ResourceMgr {

    public static BufferedImage tankGoodL,tankGoodU,tankGoodR,tankGoodD;
    public static BufferedImage tankBadL,tankBadU,tankBadR,tankBadD;

    public static BufferedImage bulletL,bulletU,bulletR,bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            tankGoodL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankGoodU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankGoodR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankGoodD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            tankBadL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankBadU = ImageUtil.rotateImage(tankBadL,90);
            tankBadR = ImageUtil.rotateImage(tankBadL,180);
            tankBadD = ImageUtil.rotateImage(tankBadL,270);

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            for(int i = 0;i < 16;i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i + 1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}