package kz.zhanbolat.chief.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD,
        ElementType.METHOD, ElementType.TYPE})
@Repeatable(ThisCodeSmell.List.class)
public @interface ThisCodeSmell {
    String reviewer();

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD,
            ElementType.METHOD, ElementType.TYPE})
    @interface List {
        ThisCodeSmell[] value();
    }
}
