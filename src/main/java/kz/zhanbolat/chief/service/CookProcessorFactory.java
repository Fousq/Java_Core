package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.ingredient.cheese.CheeseIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.meat.MeatIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredientFactory;
import kz.zhanbolat.chief.service.processor.CookProcessor;
import kz.zhanbolat.chief.service.processor.impl.*;

import java.util.Arrays;
import java.util.List;


// TODO: REFACTOR
public enum CookProcessorFactory {
    GREEK_SALAD_HANDLERS(DishType.GREEK_SALAD, new RemoveSeedsProcessor(OrganicIngredientFactory.BELL_PEPPER.getName()),
            new PeelProcessor(OrganicIngredientFactory.ONION.getName()),
            new CutProcessor(OrganicIngredientFactory.CUCUMBER.getName(),
                    OrganicIngredientFactory.BELL_PEPPER.getName(),
                    OrganicIngredientFactory.TOMATO.getName(),
                    OrganicIngredientFactory.ONION.getName(),
                    CheeseIngredientFactory.FETA_CHEESE.getName(),
                    OrganicIngredientFactory.PITTED_OLIVE.getName())),
    BORSCH_HANDLERS(DishType.BORSCH, new PeelProcessor(OrganicIngredientFactory.ONION.getName(),
                    OrganicIngredientFactory.CARROT.getName(),
                    OrganicIngredientFactory.BEET.getName()),
            new CutProcessor(MeatIngredientFactory.COW_PULP.getName(),
                    OrganicIngredientFactory.ONION.getName(),
                    OrganicIngredientFactory.CARROT.getName(),
                    OrganicIngredientFactory.CABBAGE.getName(),
                    OrganicIngredientFactory.BEET.getName()),
            new BoilProcessor(MeatIngredientFactory.COW_PULP.getName()),
            new FryProcessor(OrganicIngredientFactory.BEET.getName(),
                    OrganicIngredientFactory.ONION.getName(),
                    OrganicIngredientFactory.CARROT.getName(),
                    SauceIngredientFactory.VEGETABLE_OIL.getName()),
            new PeelProcessor(OrganicIngredientFactory.POTATOES.getName()),
            new CutProcessor(OrganicIngredientFactory.POTATOES.getName()),
            new BoilProcessor(OrganicIngredientFactory.POTATOES.getName(),
                    OrganicIngredientFactory.CABBAGE.getName(),
                    OrganicIngredientFactory.BEET.getName(),
                    OrganicIngredientFactory.ONION.getName(),
                    OrganicIngredientFactory.CARROT.getName(),
                    SpiceIngredientFactory.BAY_LEAVES.getName(),
                    SpiceIngredientFactory.SALT.getName(),
                    SpiceIngredientFactory.PEPPER.getName(),
                    SauceIngredientFactory.VINEGAR.getName(),
                    SauceIngredientFactory.TOMATO_PASTE.getName()));

    private final DishType dishType;
    private final List<CookProcessor> cookProcessors;

    CookProcessorFactory(DishType dishType, CookProcessor... cookProcessors) {
        this.dishType = dishType;
        this.cookProcessors = Arrays.asList(cookProcessors);
    }

    public DishType getDishType() {
        return dishType;
    }

    public List<CookProcessor> getCookProcessors() {
        return cookProcessors;
    }
}
