package classloader.context;

/**
 * 类加载解析器，获取最合适的类加载器
 */
public abstract class ClassLoaderResolver {

    private static IClassLoadStrategy   s_strategy;             // initialized in <clinit>
    private static final int            CALL_CONTEXT_OFFSET = 3; // may need to change if this class is redesigned
    private static final CallerResolver CALLER_RESOLVER;        // set in <clinit>

    static {
        try {
            // This can fail if the current SecurityManager does not allow
            // RuntimePermission ("createSecurityManager"):
            CALLER_RESOLVER = new CallerResolver();
        } catch (SecurityException se) {
            throw new RuntimeException("ClassLoaderResolver: could not create CallerResolver: " + se);
        }
        s_strategy = new DefaultClassLoadStrategy(); //默认使用缺省加载策略
    }

    /**
     * This method selects the best classloader instance to be used for
     * class/resource loading by whoever calls this method. The decision
     * typically involves choosing between the caller's current, thread context,
     * system, and other classloaders in the JVM and is made by the
     * {@link IClassLoadStrategy} instance established by the last call to
     * {@link #setStrategy}.
     * 
     * @return classloader to be used by the caller ['null' indicates the
     *         primordial loader]
     */
    public static synchronized ClassLoader getClassLoader() {
        final Class caller = getCallerClass(0); // 获取执行当前方法的类
        final ClassLoadContext ctx = new ClassLoadContext(caller); // 创建类加载上下文
        return s_strategy.getClassLoader(ctx); // 获取最合适的类加载器
    }

    public static synchronized IClassLoadStrategy getStrategy() {
        return s_strategy;
    }

    public static synchronized IClassLoadStrategy setStrategy(final IClassLoadStrategy strategy) {
        final IClassLoadStrategy old = s_strategy; // 设置类加载策略
        s_strategy = strategy;
        return old;
    }

    /**
     * A helper class to get the call context. It subclasses SecurityManager to
     * make getClassContext() accessible. An instance of CallerResolver only
     * needs to be created, not installed as an actual security manager.
     */
    private static final class CallerResolver extends SecurityManager {
        @Override
        protected Class[] getClassContext() {
            return super.getClassContext(); // 获取当执行栈的所有类，native方法
        }

    }

    /*
     * Indexes into the current method call context with a given offset.
     */
    private static Class getCallerClass(final int callerOffset) {
        return CALLER_RESOLVER.getClassContext()[CALL_CONTEXT_OFFSET + callerOffset]; // 获取执行栈上某个方法所属的类
    }
}
