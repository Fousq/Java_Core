package kz.zhanbolat.chief;

import kz.zhanbolat.chief.service.ChiefService;
import kz.zhanbolat.chief.service.DishType;
import kz.zhanbolat.chief.service.impl.ChiefServiceImpl;
import kz.zhanbolat.chief.util.ProdCodeRunModel;
import kz.zhanbolat.chief.util.ProdRunner;
import kz.zhanbolat.chief.util.impl.ProdRunnerImpl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        Map<String, ProdCodeRunModel> methodsParamsMap = new HashMap<>();
        try {
            methodsParamsMap.put(getMethod("cookDish", ChiefService.class).getName(),
                    new ProdCodeRunModel(new ChiefServiceImpl(), DishType.GREEK_SALAD));
        } catch (NoSuchMethodException e) {
            System.err.println("Cannot get the method. " + e.getMessage());
        }
        ProdRunner runner = new ProdRunnerImpl(methodsParamsMap);
        try {
            runner.run();
        } catch (IOException e) {
            System.err.println("Cannot start the runner. " + e.getMessage());
        }
    }

    private static Method getMethod(String methodName, Class<?> clazz) throws NoSuchMethodException {
        for (Method method : clazz.getMethods()) {
            if (Objects.equals(method.getName(), methodName)) {
                return method;
            }
        }
        throw new NoSuchMethodException("No such method " + methodName);
    }
}
