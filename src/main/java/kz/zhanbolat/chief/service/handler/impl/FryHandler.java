package kz.zhanbolat.chief.service.handler.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredient;
import kz.zhanbolat.chief.service.exception.NoOilAddedException;
import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FryHandler extends AbstractHandler implements CookHandler {
    public FryHandler(List<String> toCook) {
        super(toCook);
    }

    public FryHandler(String... toCook) {
        super(toCook);
    }

    @Override
    public Dish cook(List<Ingredient> ingredients) {
        if (!oilAdded(ingredients)) {
            throw new NoOilAddedException("No oil was added to fry");
        }
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                if (isIngredientOil(ingredient)) {
                    ((SauceIngredient) ingredient).setCapacity(0);
                }
                ingredient.setFired(true);
            }
            cookedIngredients.add(ingredient);
        }
        if (Objects.nonNull(cookHandler)) {
            return cookHandler.cook(cookedIngredients);
        }
        return new Dish(ingredients);
    }

    private boolean oilAdded(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            if (isIngredientOil(ingredient)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIngredientOil(Ingredient ingredient) {
        if (ingredient instanceof SauceIngredient) {
            return ((SauceIngredient) ingredient).isOil();
        }
        return false;
    }


    @Override
    public CookHandler setNextHandler(CookHandler cookHandler) {
        this.cookHandler = cookHandler;
        return this;
    }
}
