package zs.fight.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件
 *
 * @author : zhenshuo
 * @date: 2020/09/19 21:15
 */
public class PropertyMgr {

    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){

        if(properties == null){
            return null;
        }
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(properties.getProperty("initTankCount"));
    }
}