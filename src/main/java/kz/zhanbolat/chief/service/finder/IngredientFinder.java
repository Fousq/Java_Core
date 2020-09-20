package kz.zhanbolat.chief.service.finder;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.List;

public interface IngredientFinder {
    Ingredient findIngredient(SearchParams params, List<Ingredient> ingredients);
}
