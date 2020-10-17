package kz.zhanbolat.chief.service.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.service.CaloriesCalculator;

import java.util.List;

public class CaloriesCalculatorImpl implements CaloriesCalculator {

    @Override
    public long calculate(List<Ingredient> ingredients) {
        long sum = 0;
        for (Ingredient ingredient : ingredients) {
            sum += ingredient.getWeight();
        }
        return sum;
    }
}
