package Tester;

import java.lang.Enum;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void run(Class<?> clazz) throws Exception {
        final Constructor<?> constructor = clazz.getConstructor();
        final Object object = constructor.newInstance();
        final Method[] methods = clazz.getDeclaredMethods();
        List<Method> testMethods = getMethodsByAnnotation(Test.class, methods);
        List<Method> beforeMethods = getMethodsByAnnotation(Before.class, methods);
        List<Method> beforeAllMethods = getMethodsByAnnotation(BeforeAll.class, methods);
        List<Method> afterAllMethods = getMethodsByAnnotation(AfterAll.class, methods);
        for (Method testMethod : testMethods) {
            for (Method beforeMethod : beforeMethods) {
                beforeMethod.invoke(object);
            }
            testMethod.invoke(object);
        }
        Method beforeAllMethod = 
    }


    private List<Method> getMethodsByAnnotation(Class<? extends Annotation> annotation, Method[] methods) {
        final List<Method> tempMethods = new ArrayList<Method>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                tempMethods.add(method);
            }
        }
        return tempMethods;
    }
}