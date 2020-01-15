package Tester;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class EnumBuilder {
    public void createEnumObject(Class<?> clazz) throws Exception {
        final Constructor<?> constructor = clazz.getConstructor();
        final Object object = constructor.newInstance();
    }
}
