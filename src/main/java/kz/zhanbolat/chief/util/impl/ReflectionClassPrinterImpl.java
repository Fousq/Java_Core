package kz.zhanbolat.chief.util.impl;

import kz.zhanbolat.chief.util.ReflectionClassPrinter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionClassPrinterImpl implements ReflectionClassPrinter {
    @Override
    public void print(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        builder.append("Class name: ")
                .append(clazz.getName())
                .append(", constructors: ");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            builder.append("[ modifiers=")
                    .append(Modifier.toString(constructor.getModifiers()))
                    .append(", arguments=")
                    .append(Arrays.toString(constructor.getParameterTypes()))
                    .append(" ]");
        }
        builder.append(", fields: ");
        for (Field declaredField : clazz.getDeclaredFields()) {
            builder.append("[ modifiers=")
                    .append(Modifier.toString(declaredField.getModifiers()))
                    .append(", class=")
                    .append(declaredField.getType().getName())
                    .append(", name=")
                    .append(declaredField.getName());
            if (declaredField.getDeclaredAnnotations().length > 0) {
                builder.append(", annotations=");
                for (Annotation declaredAnnotation : declaredField.getDeclaredAnnotations()) {
                    builder.append(formatAnnotation(declaredAnnotation));
                }
            }
            builder.append(" ]");
        }
        builder.append(", methods: ");
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            builder.append("[ modifiers=")
                    .append(Modifier.toString(declaredMethod.getModifiers()))
                    .append(", return type=")
                    .append(declaredMethod.getReturnType().getName())
                    .append(", name=")
                    .append(declaredMethod.getName())
                    .append(", arguments=")
                    .append(Arrays.toString(declaredMethod.getParameterTypes()))
                    .append(" ]");
            if (declaredMethod.getDeclaredAnnotations().length > 0) {
                builder.append(", annotations=");
                for (Annotation declaredAnnotation : declaredMethod.getDeclaredAnnotations()) {
                    builder.append(formatAnnotation(declaredAnnotation));
                }
            }
        }
        if (clazz.getInterfaces().length > 0) {
            builder.append(", interfaces: ");
            for (Class<?> clazzInterface : clazz.getInterfaces()) {
                builder.append("[ name=")
                        .append(clazzInterface.getName()).append(" ]");
            }
        }
        if (clazz.getAnnotations().length > 0) {
            builder.append(", annotations: ");
            for (Annotation clazzAnnotation : clazz.getAnnotations()) {
                builder.append(formatAnnotation(clazzAnnotation));
            }
        }
        builder.append(".");
        System.out.println(builder.toString());
    }

    private String formatAnnotation(Annotation annotation) {
        return new StringBuilder("[ name=")
                .append(annotation.getClass().getName())
                .append(" ]").toString();
    }
}
