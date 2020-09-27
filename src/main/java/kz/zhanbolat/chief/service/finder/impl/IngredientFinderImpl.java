package kz.zhanbolat.chief.service.finder.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.exception.IngredientNotFoundException;
import kz.zhanbolat.chief.service.finder.IngredientFinder;
import kz.zhanbolat.chief.service.finder.SearchParams;
import kz.zhanbolat.chief.util.ReflectionClassPrinter;
import kz.zhanbolat.chief.util.impl.ReflectionClassPrinterImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IngredientFinderImpl implements IngredientFinder {
    private static final ReflectionClassPrinter printer = new ReflectionClassPrinterImpl();

    public IngredientFinderImpl() {
        printer.print(this.getClass());
    }

    @Override
    public Ingredient findIngredient(SearchParams params, List<Ingredient> ingredients) {
        if (Objects.isNull(ingredients) || ingredients.size() == 0) {
            throw new IllegalArgumentException("Empty list of ingredient cannot be accepted.");
        }
        if (Objects.nonNull(params.isFried())) {
            ingredients = findIsFriedIngredients(ingredients, params.isFried());
        }
        if (Objects.nonNull(params.isBoiled())) {
            ingredients = findIsBoiledIngredients(ingredients, params.isBoiled());
        }
        if (Objects.nonNull(params.isSliced())) {
            ingredients = findIsSlicedIngredients(ingredients, params.isSliced());
        }
        if (Objects.nonNull(params.getMaxWeight())) {
            ingredients = findBelowMaxWeightIngredients(ingredients, params.getMaxWeight());
        }
        if (Objects.nonNull(params.getMinWeight())) {
            ingredients = findAboveMinWeightIngredients(ingredients, params.getMinWeight());
        }
        if (ingredients.size() == 0) {
            throw new IngredientNotFoundException("Cannot find ingredient with such parameters");
        }
        return ingredients.get(0);
    }

    private List<Ingredient> findAboveMinWeightIngredients(List<Ingredient> ingredients, int minWeight) {
        List<Ingredient> matchedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getWeight() >= minWeight) {
                matchedIngredients.add(ingredient);
            }
        }
        return matchedIngredients;
    }

    private List<Ingredient> findBelowMaxWeightIngredients(List<Ingredient> ingredients, int maxWeight) {
        List<Ingredient> matchedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getWeight() <= maxWeight) {
                matchedIngredients.add(ingredient);
            }
        }
        return matchedIngredients;
    }

    private List<Ingredient> findIsSlicedIngredients(List<Ingredient> ingredients, boolean isSliced) {
        List<Ingredient> matchedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isSliced() == isSliced) {
                matchedIngredients.add(ingredient);
            }
        }
        return matchedIngredients;
    }

    private List<Ingredient> findIsFriedIngredients(List<Ingredient> ingredients, boolean isFried) {
        List<Ingredient> matchedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isFried() == isFried) {
                matchedIngredients.add(ingredient);
            }
        }
        return matchedIngredients;
    }

    private List<Ingredient> findIsBoiledIngredients(List<Ingredient> ingredients, boolean isBoiled) {
        List<Ingredient> matchedIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isBoiled() == isBoiled) {
                matchedIngredients.add(ingredient);
            }
        }
        return matchedIngredients;
    }
}
