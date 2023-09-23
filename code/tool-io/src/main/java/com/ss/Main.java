package com.ss;

import com.ss.utils.FileUtils;
import com.ss.utils.PropertyUtils;

import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = FileUtils.getResourceFile("config/test.properties");
//        System.out.println(FileUtils.streamToString(resourceFile, true));
        Properties properties = PropertyUtils.analyzeProperties(inputStream);
        System.out.println(properties.getProperty("c"));
    }
}