package kz.zhanbolat.chief.entity.fridge;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

public enum IngredientSetFactory {
    INSTANCE();

    public IngredientSet create(Ingredient ingredient, int requiredQuantity) {
        List<Ingredient> ingredients = new ArrayList<>(requiredQuantity);
        while(requiredQuantity != 0) {
            ingredients.add(ingredient);
            requiredQuantity--;
        }
        return new IngredientSet(ingredients);
    }
}
