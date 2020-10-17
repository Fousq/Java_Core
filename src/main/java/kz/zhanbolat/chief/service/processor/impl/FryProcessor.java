package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredient;
import kz.zhanbolat.chief.exception.NoOilAddedException;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;

public class FryProcessor extends AbstractProcessor implements CookProcessor {
    public FryProcessor(List<String> toCook) {
        super(toCook);
    }

    public FryProcessor(String... toCook) {
        super(toCook);
    }

    @Override
    public List<Ingredient> cook(List<Ingredient> ingredients) {
        if (!oilAdded(ingredients)) {
            throw new NoOilAddedException("No oil was added to fry");
        }
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                if (isIngredientOil(ingredient)) {
                    ((SauceIngredient) ingredient).setCapacity(0);
                }
                ingredient.setFried(true);
            }
            cookedIngredients.add(ingredient);
        }
        return ingredients;
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
}
