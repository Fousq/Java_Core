package kz.zhanbolat.chief.service.sorter;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;

import java.util.List;

public interface VegetableSorter {
    List<OrganicIngredient> sortByWeightAsc(List<Ingredient> ingredients);
}
