package kz.zhanbolat.chief;

import kz.zhanbolat.chief.annotation.ThisCodeSmell;
import kz.zhanbolat.chief.annotation.handler.ThisCodeSmellAnnotationHandler;
import kz.zhanbolat.chief.annotation.handler.impl.ThisCodeSmellAnnotationHandlerImpl;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.service.ChiefService;
import kz.zhanbolat.chief.service.DishType;
import kz.zhanbolat.chief.service.impl.ChiefServiceImpl;
import kz.zhanbolat.chief.util.ProdCodeRunModel;
import kz.zhanbolat.chief.util.ProdRunner;
import kz.zhanbolat.chief.util.impl.ProdRunnerImpl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;


@ThisCodeSmell(reviewer = "Zhanbolat")
/* TODO: Add entity fridge to store ingredients with the specific quantity,
    add handler on ingredient's endness, think about adding the takeout for foods
*/
public class Application {
    private static final ReflectionCreator reflectionCreator = new ReflectionCreatorImpl();
    private static final ReflectionInvoker reflectionInvoker = new ReflectionInvokerImpl();

    @ThisCodeSmell(reviewer = "Zhanbolat")
    @ThisCodeSmell(reviewer = "Another reviewer")
    public static void main(String[] args) {

    }

    private static void runPrinting() {
        ReflectionScanner scanner = new ReflectionScannerImpl();
        Class<?>[] classes = new Class[0];
        try {
            classes = scanner.getClasses(Application.class.getPackageName());
        } catch (IOException e) {
            System.err.println("Cannot get classes from " + Application.class.getPackageName());
        }
        ReflectionClassPrinter printer = new ReflectionClassPrinterImpl();
        for (Class<?> clazz : classes) {
            printer.print(clazz);
        }
    }
}
