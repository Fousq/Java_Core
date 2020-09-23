package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;

public class BoilProcessor extends AbstractProcessor implements CookProcessor {

    public BoilProcessor(List<String> toCook) {
        super(toCook);
    }

    public BoilProcessor(String... toCook) {
        super(toCook);
    }

    @Override
    public List<Ingredient> cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                ingredient.setBoiled(true);
            }
            cookedIngredients.add(ingredient);
        }
        return cookedIngredients;
    }
}
