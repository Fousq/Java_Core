package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.ingredient.cheese.CheeseIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.meat.MeatIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.sauce.SauceIngredientFactory;
import kz.zhanbolat.chief.entity.ingredient.spice.SpiceIngredientFactory;
import kz.zhanbolat.chief.service.handler.CookHandler;
import kz.zhanbolat.chief.service.handler.impl.*;


public enum CookHandlerFactory {
    GREEK_SALAD_HANDLERS(DishType.GREEK_SALAD, new RemoveSeedsHandler(OrganicIngredientFactory.BELL_PEPPER.getName())
            .setNextHandler(new PeelHandler(OrganicIngredientFactory.ONION.getName())
                    .setNextHandler(new CutHandler(OrganicIngredientFactory.CUCUMBER.getName(),
                            OrganicIngredientFactory.BELL_PEPPER.getName(),
                            OrganicIngredientFactory.TOMATO.getName(),
                            OrganicIngredientFactory.ONION.getName(),
                            CheeseIngredientFactory.FETA_CHEESE.getName(),
                            OrganicIngredientFactory.PITTED_OLIVE.getName())))),
    BORSCH_HANDLERS(DishType.BORSCH, new PeelHandler(OrganicIngredientFactory.ONION.getName(),
            OrganicIngredientFactory.CARROT.getName(),
            OrganicIngredientFactory.BEET.getName())
            .setNextHandler(new CutHandler(MeatIngredientFactory.COW_PULP.getName(),
            OrganicIngredientFactory.ONION.getName(),
            OrganicIngredientFactory.CARROT.getName(),
            OrganicIngredientFactory.CABBAGE.getName(),
            OrganicIngredientFactory.BEET.getName())
            .setNextHandler(new BoilHandler(MeatIngredientFactory.COW_PULP.getName())
                    .setNextHandler(new FryHandler(OrganicIngredientFactory.BEET.getName(),
                            OrganicIngredientFactory.ONION.getName(),
                            OrganicIngredientFactory.CARROT.getName(),
                            SauceIngredientFactory.VEGETABLE_OIL.getName())
                            .setNextHandler(new PeelHandler(OrganicIngredientFactory.POTATOES.getName())
                                    .setNextHandler(new CutHandler(OrganicIngredientFactory.POTATOES.getName())
                                            .setNextHandler(new BoilHandler(OrganicIngredientFactory.POTATOES.getName(),
                                                    OrganicIngredientFactory.CABBAGE.getName(),
                                                    OrganicIngredientFactory.BEET.getName(),
                                                    OrganicIngredientFactory.ONION.getName(),
                                                    OrganicIngredientFactory.CARROT.getName(),
                                                    SpiceIngredientFactory.BAY_LEAVES.getName(),
                                                    SpiceIngredientFactory.SALT.getName(),
                                                    SpiceIngredientFactory.PEPPER.getName(),
                                                    SauceIngredientFactory.VINEGAR.getName(),
                                                    SauceIngredientFactory.TOMATO_PASTE.getName()))))))));

    private final DishType dishType;
    private final CookHandler cookHandler;

    CookHandlerFactory(DishType dishType, CookHandler cookHandler) {
        this.dishType = dishType;
        this.cookHandler = cookHandler;
    }

    public DishType getDishType() {
        return dishType;
    }

    public CookHandler getCookHandler() {
        return cookHandler;
    }
}
