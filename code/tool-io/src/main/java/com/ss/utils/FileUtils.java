package com.ss.utils;

import java.io.*;

/**
 * 文件工具类
 */
public class FileUtils {

    /**
     * 获取项目根路径下的文件
     *
     * @param fileName 文件名
     * @return
     */
    public static InputStream getResourceFile(String fileName) {
        return FileUtils.class.getClassLoader().getResourceAsStream((fileName));
    }

    /**
     * 获取指定文件夹下的文件
     *
     * @param fileName 文件名
     * @return
     */
    public static InputStream getDirectoryFile(String fileName) {
        try {
            return new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将输入流转为字符串
     *
     * @param inputStream 输入流
     * @param isWrap      是否换行
     * @return string
     */
    public static String streamToString(InputStream inputStream, boolean isWrap) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                if (isWrap) {
                    stringBuilder.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }


}
