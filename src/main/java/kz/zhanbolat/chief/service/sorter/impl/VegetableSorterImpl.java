package kz.zhanbolat.chief.service.sorter.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.organic.OrganicIngredient;
import kz.zhanbolat.chief.service.sorter.VegetableSorter;
import kz.zhanbolat.chief.util.ReflectionClassPrinter;
import kz.zhanbolat.chief.util.impl.ReflectionClassPrinterImpl;

import java.util.ArrayList;
import java.util.List;

public class VegetableSorterImpl extends AbstractIngredientSorter implements VegetableSorter {
    private static final ReflectionClassPrinter printer = new ReflectionClassPrinterImpl();

    public VegetableSorterImpl() {
        printer.print(this.getClass());
    }

    @Override
    public List<OrganicIngredient> sortByWeightAsc(List<Ingredient> ingredients) {
        List<OrganicIngredient> vegetableIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            vegetableIngredients.add(((OrganicIngredient) ingredient));
        }
        vegetableIngredients.sort(new WeightComparator());
        return vegetableIngredients;
    }
}
