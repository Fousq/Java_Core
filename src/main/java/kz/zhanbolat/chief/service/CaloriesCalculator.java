package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;

import java.util.List;

public interface CaloriesCalculator {
    long calculate(List<Ingredient> ingredients);
}
