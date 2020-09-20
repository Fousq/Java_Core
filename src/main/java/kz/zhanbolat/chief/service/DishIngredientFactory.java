package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.cheese.CheeseIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredientFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DishIngredientFactory {
    GREEK_SALAD_INGREDIENTS(DishType.GREEK_SALAD,
            Arrays.asList(OrganicIngredientFactory.TOMATO.create(200),
                    OrganicIngredientFactory.BELL_PEPPER.create(300),
                    OrganicIngredientFactory.CUCUMBER.create(100),
                    CheeseIngredientFactory.FETA_CHEESE.create(150),
                    OrganicIngredientFactory.PITTED_OLIVE.create(200),
                    SauceIngredientFactory.OLIVE_OIL.create(100),
                    SauceIngredientFactory.LIMON_JUICE.create(40),
                    SpiceIngredientFactory.SALT.create(40),
                    SpiceIngredientFactory.PEPPER.create(30)));

    private DishType dishType;
    private List<Ingredient> ingredients;

    DishIngredientFactory(DishType dishType, List<Ingredient> ingredients) {
        this.dishType = dishType;
        this.ingredients = ingredients;
    }

    public DishType getDishes() {
        return dishType;
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }


}
