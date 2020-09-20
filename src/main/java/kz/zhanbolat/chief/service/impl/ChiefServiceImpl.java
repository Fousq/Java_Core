package kz.zhanbolat.chief.service.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.service.CookHandlerFactory;
import kz.zhanbolat.chief.service.DishIngredientFactory;
import kz.zhanbolat.chief.service.ChiefService;
import kz.zhanbolat.chief.service.DishType;
import kz.zhanbolat.chief.service.exception.NoIngredientsFoundException;
import kz.zhanbolat.chief.service.exception.NoSuchDishFound;
import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.List;

public class ChiefServiceImpl implements ChiefService {

    @Override
    public Dish cookDish(DishType dishType) {
        return getCookHandlerByDish(dishType).cook(getIngredientsByDish(dishType));
    }

    private List<Ingredient> getIngredientsByDish(DishType dishType) {
        for (DishIngredientFactory dishIngredient : DishIngredientFactory.values()) {
            if (dishIngredient.getDishes() == dishType) {
                return dishIngredient.getIngredients();
            }
        }
        throw new NoIngredientsFoundException("No ingredient was found for " + dishType.getName());
    }

    private CookHandler getCookHandlerByDish(DishType dishType) {
        for (CookHandlerFactory cookHandlerFactory : CookHandlerFactory.values()) {
            if (cookHandlerFactory.getDishType() == dishType) {
                return cookHandlerFactory.getCookHandler();
            }
        }
        throw new NoSuchDishFound("Chief doesn't know how to cook the \"" + dishType.getName() + "\"");
    }
}
