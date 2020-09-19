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
            tankGoodU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            tankGoodL = ImageUtil.rotateImage(tankGoodU,-90);
            tankGoodR = ImageUtil.rotateImage(tankGoodU,90);
            tankGoodD = ImageUtil.rotateImage(tankGoodU,180);

            tankBadU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankBadL = ImageUtil.rotateImage(tankBadU,-90);
            tankBadR = ImageUtil.rotateImage(tankBadU,90);
            tankBadD = ImageUtil.rotateImage(tankBadU,180);

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