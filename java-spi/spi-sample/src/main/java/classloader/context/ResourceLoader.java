package classloader.context;

import java.net.URL;

public class ResourceLoader {

    /**
     * 加载一个类
     * 
     * @param name
     * @return
     * @throws java.lang.ClassNotFoundException
     * @see java.lang.ClassLoader#loadClass(java.lang.String)
     */
    public static Class<?> loadClass(final String name) throws ClassNotFoundException {
        //获取最合适的类加载器
        final ClassLoader loader = ClassLoaderResolver.getClassLoader();
        //用指定加载器加载类
        return Class.forName(name, false, loader);
    }

    /**
     * 加载一个资源
     * 
     * @param name
     * @return
     * @see java.lang.ClassLoader#getResource(java.lang.String)
     */
    public static URL getResource(final String name) {
        //获取最合适的类加载器
        final ClassLoader loader = ClassLoaderResolver.getClassLoader();
        //查找指定的资源
        if (loader != null) {
            return loader.getResource(name);
        } else {
            return ClassLoader.getSystemResource(name);
        }
    }

    // ... more methods ...
}
