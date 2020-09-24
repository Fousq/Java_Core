package kz.zhanbolat.chief.service.processor;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;

import java.util.List;

@FunctionalInterface
public interface CookProcessor {
    List<Ingredient> cook(List<Ingredient> ingredients);
}
