package kz.zhanbolat.chief.service.impl;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.service.CaloriesCalculator;
import kz.zhanbolat.chief.util.ReflectionClassPrinter;
import kz.zhanbolat.chief.util.impl.ReflectionClassPrinterImpl;

import java.util.List;

public class CaloriesCalculatorImpl implements CaloriesCalculator {
    private static final ReflectionClassPrinter printer = new ReflectionClassPrinterImpl();

    public CaloriesCalculatorImpl() {
        printer.print(this.getClass());
    }

    @Override
    public long calculate(List<Ingredient> ingredients) {
        long sum = 0;
        for (Ingredient ingredient : ingredients) {
            sum += ingredient.getWeight();
        }
        return sum;
    }
}
