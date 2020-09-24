package kz.zhanbolat.chief.entity.fridge;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.exception.NoIngredientsFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Fridge {
    private final Set<IngredientSet> ingredients;

    public Fridge(Set<IngredientSet> ingredients) {
        this.ingredients = ingredients;
    }

    public Fridge() {
        ingredients = new HashSet<>();
    }

    public Set<IngredientSet> getIngredients() {
        return ingredients;
    }

    public void add(IngredientSet ingredientSet) {
        boolean isAdded = false;
        for (IngredientSet existedIngredientSet : ingredients) {
            if (Objects.equals(existedIngredientSet.getIngredientName(),
                    ingredientSet.getIngredientName())) {
                existedIngredientSet.add(ingredientSet.getIngredients());
                isAdded = true;
                break;
            }
        }
        if (!isAdded) {
            ingredients.add(ingredientSet);
        }
    }

    public List<Ingredient> getIngredients(String ingredientName) {
        return getIngredientSet(ingredientName).getIngredients();
    }

    public List<Ingredient> getIngredientsWithSpecificAmount(String ingredientName, int amount) {
        return getIngredientSet(ingredientName).getIngredients(amount);
    }

    private IngredientSet getIngredientSet(String ingredientName) {
        for (IngredientSet ingredientSet : ingredients) {
            if (Objects.equals(ingredientName, ingredientSet.getIngredientName())) {
                return ingredientSet;
            }
        }
        throw new NoIngredientsFoundException("No ingredient with such name \"" + ingredientName + "\"");
    }
}
