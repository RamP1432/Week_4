package com.tit.reflection.advancedlevel;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

 class SimpleDIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) {
        try {
            if (instances.containsKey(clazz)) {
                return clazz.cast(instances.get(clazz));
            }

            // Create a new instance of the class
            T instance = createInstance(clazz);
            instances.put(clazz, instance);

            // Inject dependencies
            injectDependencies(instance);

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> T createInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    private <T> void injectDependencies(T instance) throws Exception {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object fieldInstance = getInstance(field.getType());
                field.set(instance, fieldInstance);
            }
        }
    }
}

public class Problem4 {
    public static void main(String[] args) {
        SimpleDIContainer container = new SimpleDIContainer();
        ServiceA serviceA = container.getInstance(ServiceA.class);

        if (serviceA != null) {
            serviceA.performAction();
        }
    }
}

class ServiceA {
    @Inject
    private ServiceB serviceB;

    public void performAction() {
        System.out.println("ServiceA performing action");
        serviceB.assistAction();
    }
}

class ServiceB {
    public void assistAction() {
        System.out.println("ServiceB assisting action");
    }
}
