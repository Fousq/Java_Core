package kz.zhanbolat.chief.service.handler;

import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.Ingredient;

import java.util.List;

public interface CookHandler {
    Dish cook(List<Ingredient> ingredients);
    CookHandler setNextHandler(CookHandler cookHandler);
}
