package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;

public class RemoveSeedsProcessor extends AbstractProcessor implements CookProcessor {
    public RemoveSeedsProcessor(List<String> toCook) {
        super(toCook);
    }

    public RemoveSeedsProcessor(String... toCook) {
        super(toCook);
    }

    @Override
    public List<Ingredient> cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                cookedIngredients.add(handleRemove(((OrganicIngredient) ingredient)));
            } else {
                cookedIngredients.add(ingredient);
            }
        }
        return cookedIngredients;
    }

    private Ingredient handleRemove(OrganicIngredient ingredient) {
        if (ingredient.isContainsSeeds()) {
            ingredient.setContainsSeeds(false);
        }
        return ingredient;
    }
}
