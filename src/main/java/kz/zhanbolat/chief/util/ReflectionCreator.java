package kz.zhanbolat.chief.util;

public interface ReflectionCreator {
    <T> T instantiate(Class<T> clazz, Object... parameters);
}
