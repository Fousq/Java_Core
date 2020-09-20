package kz.zhanbolat.chief.service.sorter.impl;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.Comparator;

public abstract class AbstractIngredientSorter {

    protected static class WeightComparator implements Comparator<Ingredient> {

        @Override
        public int compare(Ingredient o1, Ingredient o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
