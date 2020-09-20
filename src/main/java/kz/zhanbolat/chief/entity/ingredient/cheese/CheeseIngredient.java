package kz.zhanbolat.chief.entity.ingredient.cheese;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.Objects;

public class CheeseIngredient extends Ingredient {
    private boolean isMoldy;

    public CheeseIngredient(String name, int weight, boolean isMoldy) {
        super(name, weight);
        this.isMoldy = isMoldy;
    }

    public boolean isMoldy() {
        return isMoldy;
    }

    public void setMoldy(boolean moldy) {
        isMoldy = moldy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CheeseIngredient that = (CheeseIngredient) o;
        return isMoldy == that.isMoldy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isMoldy);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheeseIngredient{");
        sb.append("isMoldy=").append(isMoldy);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", isSliced=").append(isSliced);
        sb.append(", isBoiled=").append(isBoiled);
        sb.append(", isFired=").append(isFired);
        sb.append('}');
        return sb.toString();
    }
}
