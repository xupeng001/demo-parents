package classloader.context;

import java.net.URL;

import classloader.Person;

/**
 * 类ResourceLoaderTEST.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月23日 下午6:17:14
 */
public class ResourceLoaderTEST {

    private static String str = "file:///D:/ecwock/demo-parents/java-spi/spi-sample//target/spi-sample-0.0.1-SNAPSHOT.jar";

    public static void main(String[] args) {
        URL resource = ResourceLoader.getResource(str);
        System.out.println(resource);
        ClassLoader classLoader = ClassLoaderResolver.getClassLoader();
        URL url = classLoader.getResource(str);
        System.out.println(url);
        Class<?> loadClass = null;
        try {
            loadClass = classLoader.loadClass(Person.class.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loadClass);
    }

}
