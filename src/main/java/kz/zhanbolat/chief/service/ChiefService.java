package kz.zhanbolat.chief.service;

import kz.zhanbolat.chief.entity.dish.Dish;

public interface ChiefService {
    Dish cookDish(DishType dishType);
}
