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
        for (Ingredient ingredient : greekSalad.getCookedIngredients()) {
            System.out.println(ingredient);
        }
    }
}
