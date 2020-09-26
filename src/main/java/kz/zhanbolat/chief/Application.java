package kz.zhanbolat.chief;

import kz.zhanbolat.chief.entity.fridge.Fridge;
import kz.zhanbolat.chief.entity.fridge.IngredientSetFactory;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.cheese.CheeseIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.meat.MeatIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredientFactory;
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

/* TODO: Add handler on ingredient's endness
*/
public class Application {

    public static void main(String[] args) {
        // Init
        Fridge fridge = new Fridge();
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.TOMATO.create(200), 5));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.BELL_PEPPER.create(300), 4));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.CUCUMBER.create(100), 7));
        fridge.add(IngredientSetFactory.INSTANCE.create(CheeseIngredientFactory.FETA_CHEESE.create(150), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.PITTED_OLIVE.create(200), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(SauceIngredientFactory.OLIVE_OIL.create(100), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(SauceIngredientFactory.LIMON_JUICE.create(40), 4));
        fridge.add(IngredientSetFactory.INSTANCE.create(SpiceIngredientFactory.SALT.create(40), 100));
        fridge.add(IngredientSetFactory.INSTANCE.create(SpiceIngredientFactory.PEPPER.create(30), 100));
        fridge.add(IngredientSetFactory.INSTANCE.create(MeatIngredientFactory.COW_PULP.create(2000), 4));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.POTATOES.create(500), 10));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.CABBAGE.create(300), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.BEET.create(400), 4));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.CARROT.create(200), 5));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.ONION.create(200), 10));
        fridge.add(IngredientSetFactory.INSTANCE.create(SauceIngredientFactory.TOMATO_PASTE.create(100), 4));
        fridge.add(IngredientSetFactory.INSTANCE.create(SauceIngredientFactory.VINEGAR.create(100), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(OrganicIngredientFactory.GARLIC.create(100), 10));
        fridge.add(IngredientSetFactory.INSTANCE.create(SpiceIngredientFactory.BAY_LEAVES.create(100), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(SpiceIngredientFactory.SALT.create(100), 3));
        fridge.add(IngredientSetFactory.INSTANCE.create(SpiceIngredientFactory.PEPPER.create(100), 4));
        fridge.add(IngredientSetFactory.INSTANCE.create(SauceIngredientFactory.VEGETABLE_OIL.create(200), 3));

        ChiefService chiefService = new ChiefServiceImpl(fridge);
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
