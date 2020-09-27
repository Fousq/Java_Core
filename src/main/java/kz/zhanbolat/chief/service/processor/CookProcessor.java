package kz.zhanbolat.chief.service.processor;

import kz.zhanbolat.chief.annotation.UseArrayList;
import kz.zhanbolat.chief.entity.Ingredient;

import java.util.List;

@FunctionalInterface
public interface CookProcessor {
    @UseArrayList
    List<Ingredient> cook(List<Ingredient> ingredients);
}
