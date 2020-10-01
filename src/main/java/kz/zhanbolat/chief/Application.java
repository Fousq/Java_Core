package kz.zhanbolat.chief;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.service.ChiefService;
import kz.zhanbolat.chief.service.DishType;
import kz.zhanbolat.chief.service.filter.IngredientFilter;
import kz.zhanbolat.chief.service.filter.impl.VegetableIngredientFilter;
import kz.zhanbolat.chief.service.finder.IngredientFinder;
import kz.zhanbolat.chief.service.finder.SearchParams;
import kz.zhanbolat.chief.service.finder.impl.IngredientFinderImpl;
import kz.zhanbolat.chief.service.impl.ChiefServiceImpl;
import kz.zhanbolat.chief.service.sorter.VegetableSorter;
import kz.zhanbolat.chief.service.sorter.impl.VegetableSorterImpl;
import kz.zhanbolat.chief.util.ReflectionClassPrinter;
import kz.zhanbolat.chief.util.ReflectionCreator;
import kz.zhanbolat.chief.util.ReflectionInvoker;
import kz.zhanbolat.chief.util.ReflectionScanner;
import kz.zhanbolat.chief.util.impl.ReflectionClassPrinterImpl;
import kz.zhanbolat.chief.util.impl.ReflectionCreatorImpl;
import kz.zhanbolat.chief.util.impl.ReflectionInvokerImpl;
import kz.zhanbolat.chief.util.impl.ReflectionScannerImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* TODO: Add entity fridge to store ingredients with the specific quantity,
    add handler on ingredient's endness, think about adding the takeout for foods
*/
public class Application {
    private static final ReflectionCreator reflectionCreator = new ReflectionCreatorImpl();
    private static final ReflectionInvoker reflectionInvoker = new ReflectionInvokerImpl();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ChiefService chiefService = reflectionCreator.instantiate(ChiefServiceImpl.class);
        Dish greekSalad = (Dish) reflectionInvoker.invokeMethod(chiefService, "cookDish",
                DishType.GREEK_SALAD);
        System.out.println("Greek salad:");
        for (Ingredient ingredient : greekSalad.getCookedIngredients()) {
            System.out.println(ingredient);
        }

        System.out.println("Total calories: " + greekSalad.getCalories() + " gram");
        IngredientFilter vegetableFilter = reflectionCreator.instantiate(VegetableIngredientFilter.class);
        List<Ingredient> greekSaladVegetables = (List<Ingredient>) reflectionInvoker.invokeMethod(vegetableFilter,
                "filterIngredients", greekSalad.getCookedIngredients());
        VegetableSorter vegetableSorter = reflectionCreator.instantiate(VegetableSorterImpl.class);
        List<OrganicIngredient> sortedVegetables = (List<OrganicIngredient>) reflectionInvoker.invokeMethod(vegetableSorter,
                "sortByWeightAsc", greekSaladVegetables);
        System.out.println("Sorted vegetables: " + Arrays.toString(sortedVegetables.toArray()));

        System.out.println("\nBorsch:");
        Dish borsch = (Dish) reflectionInvoker.invokeMethod(chiefService, "cookDish",
                DishType.BORSCH);
        for (Ingredient cookedIngredient : borsch.getCookedIngredients()) {
            System.out.println(cookedIngredient);
        }
        System.out.println("Total calories: " + borsch.getCalories() + " gram");

        IngredientFinder ingredientFinder = reflectionCreator.instantiate(IngredientFinderImpl.class);
        SearchParams params = SearchParams.builder().setBoiled(true).setMinWeight(200).setMaxWeight(500).build();
        Ingredient ingredient = (Ingredient) reflectionInvoker.invokeMethod(ingredientFinder, "findIngredient",
                params, borsch.getCookedIngredients());
        System.out.println("Found: " + ingredient);
        runPrinting();
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
