package kz.zhanbolat.chief.enity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Ingredient {
    protected Freshness freshness;
    protected Softness softness;
    // the weight is measured in grams
    protected int weight;
    protected LocalDate expirationDate;

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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingredent = (Ingredient) o;
        return weight == ingredent.weight &&
                freshness == ingredent.freshness &&
                softness == ingredent.softness &&
                Objects.equals(expirationDate, ingredent.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freshness, softness, weight, expirationDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredent{");
        sb.append("freshness=").append(freshness);
        sb.append(", softness=").append(softness);
        sb.append(", weight=").append(weight);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append('}');
        return sb.toString();
    }
}
