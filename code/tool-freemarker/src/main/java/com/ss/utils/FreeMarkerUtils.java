package com.ss.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * FreeMarker常用工具类
 */
public class FreeMarkerUtils {

    /**
     * 加载项目根目录下的模板文件
     *
     * @param templatePath 模板路径
     * @param templateName 模板文件
     * @return the template
     */
    public static Template loadTemplateFromResource(String templatePath, String templateName) {
        //配置对象
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        //获取模板
        configuration.setClassForTemplateLoading(FreeMarkerUtils.class, templatePath);
        //加载模板
        try {
            return configuration.getTemplate(templateName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载指定文件夹下的模板文件
     *
     * @param templatePath 模板路径
     * @param templateName 模板文件
     * @return the template
     */
    public static Template loadTemplateFromDirectory(String templatePath, String templateName) {
        //配置对象
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        try {
            //获取模板
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            //加载模板
            return configuration.getTemplate(templateName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 打印输出模板文件
     *
     * @param filePath 文件输出路径
     * @param fileName 文件名称
     * @param modelMap 模板数据
     */
    public static void printTemplate(Template template, String filePath, String fileName, Map<String, Object> modelMap) {
        try {
            //创建输出对象
            //输出文件
            FileWriter fileWriter = new FileWriter(filePath + fileName);
            //输出字符串
            StringWriter stringWriter = new StringWriter();
            //渲染模板
            template.process(modelMap, stringWriter);
            template.process(modelMap, fileWriter);
            //关闭流
            stringWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

}
