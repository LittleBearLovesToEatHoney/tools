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











