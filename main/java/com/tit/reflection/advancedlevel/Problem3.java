package com.tit.reflection.advancedlevel;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}

class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before execution
        System.out.println("Invoking method: " + method.getName());

        // Execute the actual method
        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LoggingProxyHandler(target)
        );
    }
}


public class Problem3 {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();

        // Create a proxy for the Greeting interface
        Greeting proxy = LoggingProxyHandler.createProxy(greeting);

        // Call the sayHello method on the proxy
        proxy.sayHello();
    }
}
