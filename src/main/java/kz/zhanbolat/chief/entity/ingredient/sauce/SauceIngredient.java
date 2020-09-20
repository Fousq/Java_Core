package kz.zhanbolat.chief.entity.ingredient.sauce;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.Objects;

public class SauceIngredient extends Ingredient {
    // measured in ml, 1 ml = 1 gram
    private int capacity;
    private boolean isOil;

    public SauceIngredient(String name, int weight, boolean isOil) {
        super(name, weight);
        this.capacity = weight;
        this.isOil = isOil;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        super.setWeight(capacity);
    }

    public boolean isOil() {
        return isOil;
    }

    public void setOil(boolean oil) {
        isOil = oil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SauceIngredient that = (SauceIngredient) o;
        return capacity == that.capacity &&
                isOil == that.isOil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, isOil);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SauceIngredient{");
        sb.append("capacity=").append(capacity);
        sb.append(", isOil=").append(isOil);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", isSliced=").append(isSliced);
        sb.append(", isBoiled=").append(isBoiled);
        sb.append(", isFired=").append(isFired);
        sb.append('}');
        return sb.toString();
    }
}
