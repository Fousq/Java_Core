package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;

public class PeelProcessor extends AbstractProcessor implements CookProcessor {

    public PeelProcessor(List<String> toCook) {
        super(toCook);
    }

    public PeelProcessor(String... toCook) {
        super(toCook);
    }

    @Override
    public List<Ingredient> cook(List<Ingredient> ingredients) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (toCook.contains(ingredient.getName())) {
                cookedIngredients.add(handlePeel(ingredient));
            } else {
                cookedIngredients.add(ingredient);
            }
        }
        return cookedIngredients;
    }

    private Ingredient handlePeel(Ingredient ingredient) {
        OrganicIngredient organicIngredient = (OrganicIngredient) ingredient;
        if (organicIngredient.isPeelable()) {
            organicIngredient.setPeelable(false);
        }
        return organicIngredient;
    }
}
