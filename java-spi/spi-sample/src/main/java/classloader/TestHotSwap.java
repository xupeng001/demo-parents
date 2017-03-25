package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("all")
public class TestHotSwap {

    public static void main(String args[]) throws MalformedURLException {
        Person a = new Person(); // 加载类A
        Bird b = new Bird(); // 加载类B
        a.setBird(b); // A引用了B，把b对象拷贝到A.b
        System.out.printf("Person classLoader is %s\n", a.getClass().getClassLoader());
        System.out.printf("Person classLoader is %s\n", b.getClass().getClassLoader());
        System.out.printf("Person.bird classLoader is %s\n", a.getBird().getClass().getClassLoader());

        try {
            //            D:\ecwock\demo-parents\java-spi\spi-sample\target
            URL[] urls = new URL[] { new URL(
                    "file:///D:/ecwock/demo-parents/java-spi/spi-sample//target/spi-sample-0.0.1-SNAPSHOT.jar") };
            HotSwapClassLoader c1 = new HotSwapClassLoader(urls, a.getClass().getClassLoader());
            Class clazz = c1.load("classloader.Person"); // 用hot swap重新加载类A
            Object aInstance = clazz.newInstance(); // 创建A类对象
            Method method1 = clazz.getMethod("setBird", Bird.class); // 获取setB(B b)方法
            method1.invoke(aInstance, b); // 调用setB(b)方法，重新把b对象拷贝到A.b
            Method method2 = clazz.getMethod("getBird"); // 获取getB()方法
            Object bInstance = method2.invoke(aInstance); // 调用getB()方法
            System.out.printf("Reloaded Person.bird classLoader is %s\n", bInstance.getClass().getClassLoader());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
                | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
