package com.ss.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Properties常用工具类
 */
public class PropertyUtils {

    /**
     * 解析Properties文件流
     *
     * @param inputStream
     * @return
     */
    public static Properties analyzeProperties(InputStream inputStream) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    /**
     * 获取所有属性名
     *
     * @param properties
     * @return
     */
    public static Set<String> getPropertyName(Properties properties) {
        return properties.stringPropertyNames();
    }

    /**
     * 将properties文件转成map集合
     *
     * @param properties
     * @return
     */
    public static Map<String, String> convertToMap(Properties properties) {
        Map<String, String> map = new HashMap<String, String>();
        for (String propertyName : properties.stringPropertyNames()) {
            String propertyValue = properties.getProperty(propertyName);
            map.put(propertyName, propertyValue);
        }
        return map;
    }


}
