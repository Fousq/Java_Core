package kz.zhanbolat.chief.entity.dish;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.service.CaloriesCalculator;
import kz.zhanbolat.chief.service.impl.CaloriesCalculatorImpl;

import java.util.Collections;
import java.util.List;

public class Dish {
    private List<Ingredient> cookedIngredients;
    private CaloriesCalculator caloriesCalculator;

    public Dish(List<Ingredient> ingredients) {
        this.cookedIngredients = ingredients;
        caloriesCalculator = new CaloriesCalculatorImpl();
    }

    public List<Ingredient> getCookedIngredients() {
        return Collections.unmodifiableList(cookedIngredients);
    }

    public void setCookedIngredients(List<Ingredient> ingredients) {
        this.cookedIngredients = ingredients;
    }

    public void add(Ingredient ingredient) {
        cookedIngredients.add(ingredient);
    }

    public void remove(Ingredient ingredient) {
        cookedIngredients.remove(ingredient);
    }

    public long getCalories() {
        return caloriesCalculator.calculate(cookedIngredients);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "cookedIngredients=" + cookedIngredients +
                '}';
    }
}
