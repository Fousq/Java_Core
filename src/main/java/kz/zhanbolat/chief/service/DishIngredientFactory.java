package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.cheese.CheeseIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.meat.MeatIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredient;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredient;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredientFactory;
import kz.zhanbolat.chief.util.ReflectionClassPrinter;
import kz.zhanbolat.chief.util.impl.ReflectionClassPrinterImpl;

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
                    SpiceIngredientFactory.PEPPER.create(30))),
    BORSCH_INGREDIENTS(DishType.BORSCH, Arrays.asList(MeatIngredientFactory.COW_PULP.create(1000),
            OrganicIngredientFactory.POTATOES.create(500),
            OrganicIngredientFactory.CABBAGE.create(300),
            OrganicIngredientFactory.BEET.create(400),
            OrganicIngredientFactory.CARROT.create(200),
            OrganicIngredientFactory.ONION.create(200),
            SauceIngredientFactory.TOMATO_PASTE.create(60),
            SauceIngredientFactory.VINEGAR.create(10),
            OrganicIngredientFactory.GARLIC.create(100),
            SpiceIngredientFactory.BAY_LEAVES.create(15),
            SpiceIngredientFactory.SALT.create(60),
            SpiceIngredientFactory.PEPPER.create(70),
            SauceIngredientFactory.VEGETABLE_OIL.create(100)));

    private DishType dishType;
    private List<Ingredient> ingredients;
    private final ReflectionClassPrinter printer = new ReflectionClassPrinterImpl();

    DishIngredientFactory(DishType dishType, List<Ingredient> ingredients) {
        this.dishType = dishType;
        this.ingredients = ingredients;
        printer.print(this.getClass());
    }

    public DishType getDishes() {
        return dishType;
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }


}
