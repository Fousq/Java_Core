package kz.zhanbolat.chief.service.processor;

import kz.zhanbolat.chief.annotation.UseArrayList;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;

import java.util.List;

public interface CookProcessor {
    @UseArrayList
    List<Ingredient> cook(List<Ingredient> ingredients);
}
