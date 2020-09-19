package kz.zhanbolat.chief.entity.ingredient;

import java.util.Objects;

public abstract class Ingredient {
    protected Freshness freshness;
    protected Softness softness;
    // the weight is measured in grams
    protected int weight;

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }

    public Softness getSoftness() {
        return softness;
    }

    public void setSoftness(Softness softness) {
        this.softness = softness;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingredent = (Ingredient) o;
        return weight == ingredent.weight &&
                freshness == ingredent.freshness &&
                softness == ingredent.softness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freshness, softness, weight);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredent{");
        sb.append("freshness=").append(freshness);
        sb.append(", softness=").append(softness);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
