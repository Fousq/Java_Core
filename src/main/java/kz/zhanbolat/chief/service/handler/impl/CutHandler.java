package kz.zhanbolat.chief.service.handler.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredient;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredient;
import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CutHandler implements CookHandler {
    private CookHandler handler;

    @Override
    public Dish cook(List<kz.zhanbolat.chief.entity.Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (!(ingredient instanceof SauceIngredient
                    || ingredient instanceof SpiceIngredient)) {
                ingredient.setSliced(true);
            }
            cookedIngredients.add(ingredient);
        }
        if (Objects.nonNull(handler)) {
            return handler.cook(cookedIngredients);
        }
        return new Dish(cookedIngredients);
    }

    @Override
    public CookHandler setNextHandler(CookHandler handler) {
        this.handler = handler;
        return this;
    }

}
