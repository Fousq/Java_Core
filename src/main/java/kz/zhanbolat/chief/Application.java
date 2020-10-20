package kz.zhanbolat.chief;

import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;
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

import java.util.Arrays;
import java.util.List;

/* TODO: Add entity fridge to store ingredients with the specific quantity,
    add handler on ingredient's endness, think about adding the takeout for foods
*/

/**
 * Exercise 1. -XX:NewRatio=1 -XX:SurvivorRatio=5.
 * Exercise 2. -Xmx512M -XX:NewRatio=1 -XX:SurvivorRatio=4.
 * Exercise 3. -Xmx512M -Xmn384M -XX:SurvivorRatio=5.
 * Exercise 4. -Xmx512M -Xmn384M -XX:SurvivorRatio=1.
 */
public class Application {

    public static void main(String[] args) {
        while (true) {
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
        }
    }
}
