package zs.fight.tank;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 图片测试
 *
 * @author : zhenshuo
 * @date: 2020/09/13 22:14
 */
public class ImageTest {

    @Test
    void test() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("/Users/zhenshuo/zhenshuo/fight/tank/tank/src/images/bulletD.gif"));
            // 断言，判断条件，如果通过就是测试通过，如果没有就是没通过
            assertNotNull(bufferedImage);
            BufferedImage bufferedImage1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}