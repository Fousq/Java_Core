package kz.zhanbolat.chief;

import kz.zhanbolat.chief.annotation.ThisCodeSmell;
import kz.zhanbolat.chief.annotation.handler.ThisCodeSmellAnnotationHandler;
import kz.zhanbolat.chief.annotation.handler.impl.ThisCodeSmellAnnotationHandlerImpl;
import kz.zhanbolat.chief.entity.Ingredient;
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
import kz.zhanbolat.chief.util.ReflectionScanner;
import kz.zhanbolat.chief.util.ReflectionScannerImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@ThisCodeSmell(reviewer = "Zhanbolat")
public class Application {

    @ThisCodeSmell(reviewer = "Zhanbolat")
    @ThisCodeSmell(reviewer = "Another reviewer")
    public static void main(String[] args) {
        ReflectionScanner scanner = new ReflectionScannerImpl();
        Class<?>[] classes = new Class[0];
        try {
             classes = scanner.getClasses(Application.class.getPackage().getName());
        } catch (IOException e) {
            System.err.println("Failed to get classes");
        }
        ThisCodeSmellAnnotationHandler<String, Integer> thisCodeSmellAnnotationHandler = new ThisCodeSmellAnnotationHandlerImpl();
        System.out.println("The start of ThisCodeSmell annotation handler:");
        thisCodeSmellAnnotationHandler.handle(classes);
        System.out.println("The end of ThisCodeSmell annotation handler.");

        ChiefService chiefService = new ChiefServiceImpl();
        Dish greekSalad = chiefService.cookDish(DishType.GREEK_SALAD);
        System.out.println("Greek salad:");
        for (Ingredient ingredient : greekSalad.getCookedIngredients()) {
            System.out.println(ingredient);
        }

        System.out.println("Total calories: " + greekSalad.getCalories() + " gram");
        IngredientFilter vegetableFilter = new VegetableIngredientFilter();
        List<Ingredient> greekSaladVegetables = vegetableFilter.filterIngredients(greekSalad.getCookedIngredients());
        VegetableSorter vegetableSorter = new VegetableSorterImpl();
        List<OrganicIngredient> sortedVegetables = vegetableSorter.sortByWeightAsc(greekSaladVegetables);
        System.out.println("Sorted vegetables: " + Arrays.toString(sortedVegetables.toArray()));

        System.out.println("\nBorsch:");
        Dish borsch = chiefService.cookDish(DishType.BORSCH);
        for (Ingredient cookedIngredient : borsch.getCookedIngredients()) {
            System.out.println(cookedIngredient);
        }
        System.out.println("Total calories: " + borsch.getCalories() + " gram");

        IngredientFinder ingredientFinder = new IngredientFinderImpl();
        SearchParams params = SearchParams.builder().setBoiled(true).setMinWeight(200).setMaxWeight(500).build();
        Ingredient ingredient = ingredientFinder.findIngredient(params, borsch.getCookedIngredients());
        System.out.println("Found: " + ingredient);

        System.out.println(thisCodeSmellAnnotationHandler.getCodeAreaReviewersSortedMap());
    }
}
