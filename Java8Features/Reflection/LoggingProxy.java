package reflection;

import java.lang.reflect.*;

interface Greet { void sayHello(String name); }

class GreetImpl implements Greet {
    public void sayHello(String name) { System.out.println("Hello " + name); }
}

class LogProxy implements InvocationHandler {
    private Object target;
    LogProxy(Object t) { this.target = t; }
    public Object invoke(Object p, Method m, Object[] a) throws Throwable {
        System.out.println("Called: " + m.getName());
        return m.invoke(target, a);
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greet g = (Greet) Proxy.newProxyInstance(
            Greet.class.getClassLoader(),
            new Class[]{Greet.class},
            new LogProxy(new GreetImpl()));
        g.sayHello("World");
    }
}
