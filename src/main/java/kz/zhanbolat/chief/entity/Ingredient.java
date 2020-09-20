package kz.zhanbolat.chief.entity;

import java.util.Objects;

public abstract class Ingredient {
    protected String name;
    // the weight is measured in grams
    protected int weight;
    protected boolean isSliced;
    protected boolean isBoiled;
    protected boolean isFired;

    protected Ingredient(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isSliced() {
        return isSliced;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }

    public boolean isBoiled() {
        return isBoiled;
    }

    public void setBoiled(boolean boiled) {
        isBoiled = boiled;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return weight == that.weight &&
                isSliced == that.isSliced &&
                isBoiled == that.isBoiled &&
                isFired == that.isFired &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, isSliced, isBoiled, isFired);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", isSliced=").append(isSliced);
        sb.append(", isBoiled=").append(isBoiled);
        sb.append(", isFired=").append(isFired);
        sb.append('}');
        return sb.toString();
    }
}
