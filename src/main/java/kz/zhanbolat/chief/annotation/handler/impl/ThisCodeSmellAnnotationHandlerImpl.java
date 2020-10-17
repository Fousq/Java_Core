package kz.zhanbolat.chief.annotation.handler.impl;

import kz.zhanbolat.chief.annotation.ThisCodeSmell;
import kz.zhanbolat.chief.annotation.handler.ThisCodeSmellAnnotationHandler;

import java.lang.reflect.*;
import java.util.*;

public class ThisCodeSmellAnnotationHandlerImpl implements ThisCodeSmellAnnotationHandler<String, Integer> {
    // this map is used to store the values for easier sorting via tree map
    private static final Map<String, Integer> map = new HashMap<>();
    private static final Map<String, Integer> sortedMap;

    static {
        ReviewersAmountComparator comparator = new ReviewersAmountComparator(map);
        sortedMap = new TreeMap<>(comparator);
    }

    @Override
    public void handle(Class<?>[] classes) {
        for (Class<?> clazz : classes) {
            print(clazz);
            for (Field field : clazz.getDeclaredFields()) {
                print(field);
            }
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                print(constructor);
            }
            for (Method method : clazz.getDeclaredMethods()) {
                print(method);
            }
        }
    }

    @Override
    public Map<String, Integer> getCodeAreaReviewersSortedMap() {
        sortedMap.putAll(map);
        return Collections.unmodifiableMap(sortedMap);
    }

    private <T extends AnnotatedElement> void print(T instance) {
        if (instance.isAnnotationPresent(ThisCodeSmell.List.class) || instance.isAnnotationPresent(ThisCodeSmell.class)) {
            StringBuilder builder = new StringBuilder("Annotated with ThisCodeSmell annotation: ");
            builder.append(instance.toString()).append("; Reviewers [");
            ThisCodeSmell[] annotations;
            ThisCodeSmell.List[] repeatableAnnotations = instance.getDeclaredAnnotationsByType(ThisCodeSmell.List.class);
            if (repeatableAnnotations.length == 1) {
                annotations = repeatableAnnotations[0].value();
            } else {
                annotations = instance.getAnnotationsByType(ThisCodeSmell.class);
            }
            for (int i = 0; i < annotations.length; i++) {
                builder.append("Reviewer: ").append(annotations[i].reviewer())
                        .append(i == annotations.length - 1 ? "" : ", ");
            }
            builder.append("]; ").append("Amount of reviewers: ").append(annotations.length);
            System.out.println(builder.toString());
            map.put(instance.toString(), annotations.length);
        }
    }

    private static class ReviewersAmountComparator implements Comparator<String> {
        Map<String, Integer> map;

        private ReviewersAmountComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            if (map.get(o1) >= map.get(o2)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
