package kz.zhanbolat.chief.util.impl;

import kz.zhanbolat.chief.exception.CannotInstantiateByConstructorException;
import kz.zhanbolat.chief.util.ReflectionCreator;

import java.lang.reflect.Field;

public class ReflectionCreatorImpl implements ReflectionCreator {

    @Override
    public <T> T instantiate(Class<T> clazz, Object... parameters) {
        Field[] declaredFields = clazz.getDeclaredFields();
        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new CannotInstantiateByConstructorException("Cannot instantiate the class " + clazz.getName()
                    + " by the constructor", e);
        }
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> fieldType = declaredField.getType();
            try {
                // field with interfaces should be skipped, because never know the implementation
                if (fieldType.isInterface() || fieldType.isPrimitive()) {
                    continue;
                }
                declaredField.set(instance, fieldType.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new CannotInstantiateByConstructorException("Cannot instantiate the class " + fieldType.getName()
                        + " by the constructor", e);
            }
        }
        return instance;
    }
}
