package kz.zhanbolat.chief.entity.ingredient.spice;

import kz.zhanbolat.chief.entity.ingredient.Ingredient;

import java.util.Objects;

public class SpiceIngredient extends Ingredient {
    private boolean isPowder;

    public SpiceIngredient(String name, int weight, boolean isPowder) {
        super(name, weight);
        this.isPowder = isPowder;
    }

    public boolean isPowder() {
        return isPowder;
    }

    public void setPowder(boolean powder) {
        isPowder = powder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpiceIngredient that = (SpiceIngredient) o;
        return isPowder == that.isPowder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isPowder);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SpiceIngredient{");
        sb.append("isPowder=").append(isPowder);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", isSliced=").append(isSliced);
        sb.append(", isBoiled=").append(isBoiled);
        sb.append(", isFried=").append(isFried);
        sb.append('}');
        return sb.toString();
    }
}
