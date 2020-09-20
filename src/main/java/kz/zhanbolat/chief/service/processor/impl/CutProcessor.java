package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CutProcessor extends AbstractProcessor implements CookProcessor {
    public CutProcessor(List<String> toCook) {
        super(toCook);
    }

    public CutProcessor(String... toCook) {
        super(toCook);
    }

    @Override
    public List<Ingredient> cook(List<kz.zhanbolat.chief.entity.Ingredient> ingredients) {
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
