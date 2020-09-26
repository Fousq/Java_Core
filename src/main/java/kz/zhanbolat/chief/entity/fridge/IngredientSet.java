package kz.zhanbolat.chief.entity.fridge;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.exception.AboveExistingException;
import kz.zhanbolat.chief.exception.DifferentIngredientsException;
import kz.zhanbolat.chief.service.CaloriesCalculator;
import kz.zhanbolat.chief.service.impl.CaloriesCalculatorImpl;

import java.util.*;

public class IngredientSet {
    private List<Ingredient> ingredients;
    private final String ingredientName;
    private static final CaloriesCalculator caloriesCalculator = new CaloriesCalculatorImpl();

    public IngredientSet(List<Ingredient> ingredients) {
        if (ingredients.size() == 0) {
            throw new IllegalArgumentException("No ingredients");
        }
        if (!isOneIngredientSet(ingredients)) {
            throw new DifferentIngredientsException("Ingredient's set cannot have different ingredients.");
        }
        this.ingredients = ingredients;
        ingredientName = ingredients.get(0).getName();
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> takenIngredients = new ArrayList<>(ingredients);
        ingredients = Collections.emptyList();
        return takenIngredients;
    }

    public List<Ingredient> getIngredients(int amount) throws AboveExistingException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be below zero.");
        }
        if (amount > ingredients.size()) {
            throw new AboveExistingException("The required amount is above the existing amount.");
        }
        List<Ingredient> takenIngredients = new ArrayList<>(amount);
        while (amount != 0) {
            takenIngredients.add(ingredients.get(0));
            ingredients.remove(0);
            amount--;
        }
        return takenIngredients;
    }

    public int getQuantity() {
        return ingredients.size();
    }

    public long getTotalWeight() {
        return caloriesCalculator.calculate(ingredients);
    }

    public String getIngredientName() {
        return ingredients.get(0).getName();
    }

    private boolean isOneIngredientSet(List<Ingredient> ingredients) {
        Ingredient originalIngredient = ingredients.get(0);
        for (int i = 1; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            if (!Objects.equals(originalIngredient.getName(), ingredient.getName())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return getQuantity() == 0;
    }

    public boolean add(Ingredient ingredient) {
        if (!Objects.equals(ingredient.getName(), ingredientName)) {
            return false;
        }
        return ingredients.add(ingredient);
    }

    public boolean add(List<Ingredient> ingredients) {
        if (ingredients.size() == 0 && !isOneIngredientSet(ingredients)
                && !Objects.equals(ingredients.get(0).getName(), ingredientName)) {
            return false;
        }
        return this.ingredients.addAll(ingredients);
    }
}
