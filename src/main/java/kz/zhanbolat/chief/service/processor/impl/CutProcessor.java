package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;

public class CutProcessor extends AbstractProcessor implements CookProcessor {
    public CutProcessor(List<String> toCook) {
        super(toCook);
    }

    public CutProcessor(String... toCook) {
        super(toCook);
    }

    @Override
    public List<Ingredient> cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                ingredient.setSliced(true);
            }
            cookedIngredients.add(ingredient);
        }
        return cookedIngredients;
    }
}
