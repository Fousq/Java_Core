package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.dish.CookIngredient;
import kz.zhanbolat.chief.entity.fridge.Fridge;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.exception.NoIngredientsFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractProcessor {
    protected List<CookIngredient> toCook;

    public AbstractProcessor(List<CookIngredient> toCook) {
        this.toCook = toCook;
    }

    public AbstractProcessor(CookIngredient... toCook) {
        this.toCook = Arrays.asList(toCook);
    }

    protected boolean isIngredientRequired(String ingredientName) {
        for (CookIngredient ingredient : toCook) {
            if (Objects.equals(ingredient.getName(), ingredientName)) {
                return true;
            }
        }
        return false;
    }

    protected CookIngredient getIngredientByName(String ingredientName) throws NoIngredientsFoundException {
        for (CookIngredient ingredient : toCook) {
            if (Objects.equals(ingredient.getName(), ingredientName)) {
                return ingredient;
            }
        }
        throw new NoIngredientsFoundException("");
    }

    protected List<Ingredient> getIngredientsFromFridge(Fridge fridge, String name) {
        return fridge.getIngredientsWithSpecificAmount(name, getIngredientByName(name).getWeight());
    }
}
