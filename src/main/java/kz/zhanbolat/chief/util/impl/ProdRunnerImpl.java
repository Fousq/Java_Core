package kz.zhanbolat.chief.util.impl;

import kz.zhanbolat.chief.annotation.ProdCode;
import kz.zhanbolat.chief.exception.InvalidInvokeException;
import kz.zhanbolat.chief.util.ProdCodeRunModel;
import kz.zhanbolat.chief.util.ProdRunner;
import kz.zhanbolat.chief.util.ReflectionScanner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ProdRunnerImpl implements ProdRunner {
    private static final String ROOT_PACKAGE_NAME = "kz.zhanbolat.chief";
    private static final ReflectionScanner scanner = new ReflectionScannerImpl();
    // as key use the value of toString() of methods
    private final Map<String, ProdCodeRunModel> methodsParamsMap;

    public ProdRunnerImpl() {
        methodsParamsMap = new HashMap<>();
    }

    public ProdRunnerImpl(Map<String, ProdCodeRunModel> methodsParamsMap) {
        this.methodsParamsMap = methodsParamsMap;
    }

    @Override
    public void run() throws IOException {
        Class<?>[] classes = scanner.getClasses(ROOT_PACKAGE_NAME);
        Object result = null;
        for (Class<?> clazz : classes) {
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(ProdCode.class)) {
                    ProdCodeRunModel prodCodeRunModel = methodsParamsMap.get(method.getName());
                    if (Objects.isNull(prodCodeRunModel)) {
                        throw new InvalidInvokeException("No objects to invoke the method " + method.getName());
                    }
                    if (method.getParameterCount() >= 1) {
                        if (prodCodeRunModel.getParameters().size() != method.getParameterCount()) {
                            throw new InvalidInvokeException("The parameters count is not equal.");
                        }
                        try {
                            result = method.invoke(prodCodeRunModel.getInstance(), prodCodeRunModel.getParameters().toArray());
                        } catch (Exception e) {
                            System.out.println("Cannot invoke method " + method.getName() + " with parameters "
                                    + prodCodeRunModel.getParameters() + ", cause: " + e.getMessage());
                        }
                    } else {
                        try {
                            result = method.invoke(prodCodeRunModel.getInstance());
                        } catch (Exception e) {
                            System.out.println("Cannot invoke method " + method.getName() + ", cause: " + e.getMessage());
                        }
                    }
                    System.out.println("The " + method.getName() + " method result: " + result);
                }
            }
        }
    }
}
