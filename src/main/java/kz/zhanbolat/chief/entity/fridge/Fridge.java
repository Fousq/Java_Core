package kz.zhanbolat.chief.entity.fridge;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.exception.AboveExistingException;
import kz.zhanbolat.chief.exception.NoIngredientsFoundException;
import kz.zhanbolat.chief.exception.NoSuchDishException;

import java.util.*;

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
        try {
            return getIngredientSet(ingredientName).getIngredients();
        } catch (NoIngredientsFoundException e) {
            throw new NoSuchDishException("Such dish cannot be cooked.");
        }
    }

    public List<Ingredient> getIngredientsWithSpecificAmount(String ingredientName, int amount) {
        List<Ingredient> ingredients = null;
        try {
            ingredients = getIngredientSet(ingredientName).getIngredients(amount);
        } catch (AboveExistingException e) {
            // TODO: add handler to buy ingredient
            ingredients = Collections.emptyList();
        } catch (NoIngredientsFoundException e) {
            throw new NoSuchDishException("Such dish cannot be cooked.");
        }
        return ingredients;
    }

    private IngredientSet getIngredientSet(String ingredientName) throws NoIngredientsFoundException {
        for (IngredientSet ingredientSet : ingredients) {
            if (Objects.equals(ingredientName, ingredientSet.getIngredientName())) {
                return ingredientSet;
            }
        }
        throw new NoIngredientsFoundException("No ingredient with such name \"" + ingredientName + "\"");
    }
}
