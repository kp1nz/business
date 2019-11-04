package com.kp1nz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载配置文件工具类
 * @author kp1nz
 * @create 2019-01-08 15:23
 */
public class PropertiesUtils {

    private static Properties properties = new Properties();

    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("prp.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取配置文件的内容
     */
    public static String readByKey(String key){
        return  properties.getProperty(key);
    }
}
