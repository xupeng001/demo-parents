package classloader.context;

/**
 * 缺省的类加载策略，可以适应大部分工作场景
 */
public class DefaultClassLoadStrategy implements IClassLoadStrategy {

    /**
     * 为ctx返回最合适的类加载器，从系统类加载器、当前类加载器 和当前线程上下文类加载中选择一个最底层的加载器
     * 
     * @param ctx
     * @return
     */
    @Override
    public ClassLoader getClassLoader(final ClassLoadContext ctx) {
        final ClassLoader callerLoader = ctx.getCallerClass().getClassLoader();
        final ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader result;

        // If 'callerLoader' and 'contextLoader' are in a parent-child
        // relationship, always choose the child:
        if (isChild(contextLoader, callerLoader)) {
            result = callerLoader;
        } else if (isChild(callerLoader, contextLoader)) {
            result = contextLoader;
        } else {
            // This else branch could be merged into the previous one,
            // but I show it here to emphasize the ambiguous case:
            result = contextLoader;
        }
        final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        // Precaution for when deployed as a bootstrap or extension class:
        if (isChild(result, systemLoader)) {
            result = systemLoader;
        }

        return result;
    }

    // 判断anotherLoader是否是oneLoader的child
    private boolean isChild(ClassLoader oneLoader, ClassLoader anotherLoader) {
        return true;
        //...
    }

    // ... more methods 
}
