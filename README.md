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
 * 文件工具类
 */
public class FileUtils {

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
}
````



