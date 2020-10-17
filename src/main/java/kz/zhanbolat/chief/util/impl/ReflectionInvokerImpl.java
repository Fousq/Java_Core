package kz.zhanbolat.chief.util.impl;

import kz.zhanbolat.chief.exception.NoSuchMethodRuntimeException;
import kz.zhanbolat.chief.exception.UnaccessableMethodException;
import kz.zhanbolat.chief.util.ReflectionInvoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class ReflectionInvokerImpl implements ReflectionInvoker {
    @Override
    public Object invokeMethod(Object instance, String methodName, Object... args) {
        Method[] declaredMethods = instance.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (Objects.equals(declaredMethod.getName(), methodName)) {
                try {
                    return declaredMethod.invoke(instance, args);
                } catch (IllegalAccessException e) {
                    throw new UnaccessableMethodException(e.getMessage(), e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new NoSuchMethodRuntimeException("No such method with name: " + methodName);
    }
}
