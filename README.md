# tools



## File

### 读取项目根目录下的文件

```java
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
}
```



### 读取指定文件夹下的文件

````java
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
````



## Properties

### 将输入流转为properties

````java
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
````



### properties获取所有属性名

````java
/**
 * 获取所有属性名
 *
 * @param properties
 * @return
 */
public static Set<String> getPropertyName(Properties properties) {
    return properties.stringPropertyNames();
}
````



### properties文件转成map集合

````java
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
````



## FreeMarker

> * 引入`FreeMarker`依赖

```xml
<!--引入Freemaker依赖-->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.31</version>
</dependency>
```



### 加载项目根目录下的模板文件

```java
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
}

```



### 加载指定文件夹下的模板文件

```java
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
```



### 渲染输出模板文件

```java
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
```











