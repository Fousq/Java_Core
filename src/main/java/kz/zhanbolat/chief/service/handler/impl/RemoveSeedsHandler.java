package kz.zhanbolat.chief.service.handler.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredient;
import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveSeedsHandler extends AbstractHandler implements CookHandler {
    public RemoveSeedsHandler(List<String> toCook) {
        super(toCook);
    }

    public RemoveSeedsHandler(String... toCook) {
        super(toCook);
    }

    @Override
    public Dish cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                cookedIngredients.add(handleRemove(((OrganicIngredient) ingredient)));
            } else {
                cookedIngredients.add(ingredient);
            }
        }
        if (Objects.nonNull(cookHandler)) {
            return cookHandler.cook(cookedIngredients);
        }
        return new Dish(cookedIngredients);
    }

    private Ingredient handleRemove(OrganicIngredient ingredient) {
        if (ingredient.isContainsSeeds()) {
            ingredient.setContainsSeeds(false);
        }
        return ingredient;
    }

    @Override
    public CookHandler setNextHandler(CookHandler cookHandler) {
        this.cookHandler = cookHandler;
        return this;
    }
}
