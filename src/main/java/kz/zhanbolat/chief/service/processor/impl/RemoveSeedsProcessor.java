package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.entity.dish.CookIngredient;
import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.fridge.Fridge;
import kz.zhanbolat.chief.entity.fridge.IngredientSet;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredient;
import kz.zhanbolat.chief.service.processor.CookProcessor;

import java.util.ArrayList;
import java.util.List;

public class RemoveSeedsProcessor extends AbstractProcessor implements CookProcessor {
    public RemoveSeedsProcessor(List<CookIngredient> toCook) {
        super(toCook);
    }

    public RemoveSeedsProcessor(CookIngredient... toCook) {
        super(toCook);
    }

    @Override
    public Dish cook(Fridge fridge) {
        List<Ingredient> cookedIngredients = new ArrayList<>();
        for (IngredientSet ingredientSet : fridge.getIngredients()) {
            if (isIngredientRequired(ingredientSet.getIngredientName())) {
                List<Ingredient> ingredients = handleRemove(getIngredientsFromFridge(fridge, ingredientSet.getIngredientName()));
                cookedIngredients.addAll(ingredients);
            }
        }
        return cookedIngredients;
    }

    private List<Ingredient> handleRemove(List<Ingredient> ingredients) {
        List<Ingredient> handledIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            OrganicIngredient organicIngredient = (OrganicIngredient) ingredient;
            if (organicIngredient.isContainsSeeds()) {
                organicIngredient.setContainsSeeds(false);
            }
            handledIngredients.add(ingredient);
        }
        return handledIngredients;
    }
}
