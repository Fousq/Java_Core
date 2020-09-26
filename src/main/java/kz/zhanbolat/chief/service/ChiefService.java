package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.dish.Dish;
import kz.zhanbolat.chief.exception.NoIngredientsFoundException;

public interface ChiefService {
    Dish cookDish(DishType dishType) throws NoIngredientsFoundException;
}
