package kz.zhanbolat.chief.service.processor;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.List;

public interface CookProcessor {
    List<Ingredient> cook(List<Ingredient> ingredients);
}