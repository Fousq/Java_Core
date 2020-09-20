package kz.zhanbolat.chief;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.service.ChiefService;
import kz.zhanbolat.chief.service.DishType;
import kz.zhanbolat.chief.service.impl.ChiefServiceImpl;

public class Application {

    public static void main(String[] args) {
        ChiefService chiefService = new ChiefServiceImpl();
        Dish greekSalad = chiefService.cookDish(DishType.GREEK_SALAD);
        System.out.println("Greek salad:");
        for (Ingredient ingredient : greekSalad.getCookedIngredients()) {
            System.out.println(ingredient);
        }
        System.out.println("Borsch:");
        Dish borsch = chiefService.cookDish(DishType.BORSCH);
        for (Ingredient cookedIngredient : borsch.getCookedIngredients()) {
            System.out.println(cookedIngredient);
        }
    }
}
