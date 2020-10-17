package kz.zhanbolat.chief.util;

public interface ReflectionInvoker {
    Object invokeMethod(Object instance, String methodName, Object... args);
}
