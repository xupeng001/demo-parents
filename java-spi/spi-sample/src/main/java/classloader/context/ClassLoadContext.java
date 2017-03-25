package classloader.context;

/**
 * 类加载上下文，持有要加载的类
 */
public class ClassLoadContext {

    private final Class m_caller;

    public final Class getCallerClass() {
        return m_caller;
    }

    ClassLoadContext(final Class caller) {
        m_caller = caller;
    }
}
