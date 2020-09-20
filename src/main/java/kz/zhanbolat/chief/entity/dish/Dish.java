package kz.zhanbolat.chief.entity.dish;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dish {
    private List<Ingredient> cookedIngredients;

    public Dish() {
        cookedIngredients = new ArrayList<>();
    }

    public Dish(List<Ingredient> ingredients) {
        this.cookedIngredients = ingredients;
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
}
