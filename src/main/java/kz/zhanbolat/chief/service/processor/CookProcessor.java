package kz.zhanbolat.chief.service.processor;

import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.entity.fridge.Fridge;

// TODO: add required amount to cook for processors
@FunctionalInterface
public interface CookProcessor {
    Dish cook(Fridge fridge);
}
