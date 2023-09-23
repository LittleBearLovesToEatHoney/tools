package com.ss;

import com.ss.utils.FreeMarkerUtils;
import freemarker.template.Template;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Map<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("name", "张三");
//        Template template = FreeMarkerUtils.loadTemplateFromResource("/", "test.ftl");
//        String fileName = "test" + System.currentTimeMillis() + ".txt";
//        System.out.println(fileName);
//        FreeMarkerUtils.printTemplate(template, "E:/", fileName, hashMap);

        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("age", 21);
        Template template = FreeMarkerUtils.loadTemplateFromDirectory("E:/", "test.ftl");
        String fileName = "test" + System.currentTimeMillis() + ".txt";
        System.out.println(fileName);
        FreeMarkerUtils.printTemplate(template, "E:/", fileName, hashMap);
    }
}