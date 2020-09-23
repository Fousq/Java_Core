package kz.zhanbolat.chief.service.filter;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.List;

@FunctionalInterface
public interface IngredientFilter {
    List<Ingredient> filterIngredients(List<Ingredient> ingredients);
}
