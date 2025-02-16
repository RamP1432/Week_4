package com.tit.annotationspractice.advancelevel;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveComputation {

    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int compute(int input) {
        // Check if the result is already cached
        if (cache.containsKey(input)) {
            System.out.println("Returning cached result for input: " + input);
            return cache.get(input);
        }

        // Simulate a computationally expensive operation
        System.out.println("Computing result for input: " + input);
        int result = input * input; // Example computation

        // Store the result in the cache
        cache.put(input, result);

        return result;
    }
}

public class Problem3 {

    private static Map<Method, Map<Object, Object>> methodCache = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();
        Class<?> obj = computation.getClass();

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CacheResult.class)) {
                methodCache.put(method, new HashMap<>());
            }
        }

        // Test the caching system
        int[] inputs = {2, 4, 2, 4, 5};
        for (int input : inputs) {
            for (Method method : methodCache.keySet()) {
                Object result = invokeWithCache(computation, method, input);
                System.out.println("Result: " + result);
            }
        }
    }

    private static Object invokeWithCache(Object obj, Method method, Object input) throws Exception {
        Map<Object, Object> cache = methodCache.get(method);

        if (cache.containsKey(input)) {
            System.out.println("Returning cached result for input: " + input);
            return cache.get(input);
        }

        System.out.println("Computing result for input: " + input);
        Object result = method.invoke(obj, input);
        cache.put(input, result);

        return result;
    }
}
