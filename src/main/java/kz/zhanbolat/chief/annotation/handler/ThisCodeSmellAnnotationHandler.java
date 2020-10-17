package kz.zhanbolat.chief.annotation.handler;

import java.util.Map;

public interface ThisCodeSmellAnnotationHandler<T, K> {
    void handle(Class<?>[] classes);
    Map<T, K> getCodeAreaReviewersSortedMap();
}
