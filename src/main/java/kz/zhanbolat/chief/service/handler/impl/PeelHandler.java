package kz.zhanbolat.chief.service.handler.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredient;
import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PeelHandler extends AbstractHandler implements CookHandler {

    public PeelHandler(List<String> toCook) {
        super(toCook);
    }

    public PeelHandler(String... toCook) {
        super(toCook);
    }

    @Override
    public Dish cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                cookedIngredients.add(handlePeel(ingredient));
            } else {
                cookedIngredients.add(ingredient);
            }
        }
        if (Objects.nonNull(cookHandler)) {
            return cookHandler.cook(ingredients);
        }
        return new Dish(cookedIngredients);
    }

    private Ingredient handlePeel(Ingredient ingredient) {
        OrganicIngredient organicIngredient = (OrganicIngredient) ingredient;
        if (organicIngredient.isPeelable()) {
            organicIngredient.setPeelable(false);
        }
        return organicIngredient;
    }

    @Override
    public CookHandler setNextHandler(CookHandler cookHandler) {
        this.cookHandler = cookHandler;
        return this;
    }
}