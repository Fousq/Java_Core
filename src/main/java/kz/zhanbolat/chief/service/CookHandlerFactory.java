package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.service.handler.CookHandler;
import kz.zhanbolat.chief.service.handler.impl.CutHandler;
import kz.zhanbolat.chief.service.handler.impl.PeelHandler;


public enum CookHandlerFactory {
    GREEK_SALAD_HANDLERS(DishType.GREEK_SALAD, new PeelHandler().setNextHandler(new CutHandler()));

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
