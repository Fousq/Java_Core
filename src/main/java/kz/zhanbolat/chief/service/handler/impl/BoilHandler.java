package kz.zhanbolat.chief.service.handler.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoilHandler extends AbstractHandler implements CookHandler {

    public BoilHandler(List<String> toCook) {
        super(toCook);
    }

    public BoilHandler(String... toCook) {
        super(toCook);
    }

    @Override
    public Dish cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                ingredient.setBoiled(true);
            }
            cookedIngredients.add(ingredient);
        }
        if (Objects.nonNull(cookHandler)) {
            return cookHandler.cook(cookedIngredients);
        }
        return new Dish(cookedIngredients);
    }

    @Override
    public CookHandler setNextHandler(CookHandler cookHandler) {
        this.cookHandler = cookHandler;
        return this;
    }
}
