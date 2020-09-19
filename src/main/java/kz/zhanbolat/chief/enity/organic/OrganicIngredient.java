package kz.zhanbolat.chief.enity.organic;

import kz.zhanbolat.chief.enity.Freshness;
import kz.zhanbolat.chief.enity.Ingredient;
import kz.zhanbolat.chief.enity.Softness;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class OrganicIngredient extends Ingredient {
    private String name;
    private boolean containsSeeds;
    private boolean isPeelable;

    public OrganicIngredient(Builder builder) {
        this.name = builder.ingredient.getName();
        this.freshness = builder.freshness;
        this.softness = builder.softness;
        this.weight = builder.weight;
        this.expirationDate = builder.expirationDate;
        this.containsSeeds = builder.ingredient.isContainsSeeds();
        this.isPeelable = builder.ingredient.isPeelable();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContainsSeeds() {
        return containsSeeds;
    }

    public void setContainsSeeds(boolean containsSeeds) {
        this.containsSeeds = containsSeeds;
    }

    public boolean isPeelable() {
        return isPeelable;
    }

    public void setPeelable(boolean peelable) {
        this.isPeelable = peelable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrganicIngredient that = (OrganicIngredient) o;
        return containsSeeds == that.containsSeeds &&
                isPeelable == that.isPeelable &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, containsSeeds, isPeelable);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganicIngredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", containsSeeds=").append(containsSeeds);
        sb.append(", isPeelable=").append(isPeelable);
        sb.append(", freshness=").append(freshness);
        sb.append(", softness=").append(softness);
        sb.append(", weight=").append(weight);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append('}');
        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private OrganicIngredients ingredient;
        private Softness softness;
        private Freshness freshness;
        private LocalDate expirationDate;
        private int weight;

        private Builder() {
        }

        public Builder setOrganicIngredient(OrganicIngredients ingredient) {
            this.ingredient = ingredient;

            return this;
        }

        public Builder setSoftness(Softness softness) {
            this.softness = softness;

            return this;
        }

        public Builder setFreshness(Freshness freshness) {
            this.freshness = freshness;

            return this;
        }

        public Builder setExpirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;

            if (Objects.isNull(freshness)) {
                freshness = determineFreshness(expirationDate);
            }

            return this;
        }

        public Builder setExpirationDate(Date expirationDate) {
            this.expirationDate = LocalDate.ofInstant(expirationDate.toInstant(), ZoneId.systemDefault());

            if (Objects.isNull(freshness)) {
                freshness = determineFreshness(this.expirationDate);
            }

            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;

            return this;
        }

        private Freshness determineFreshness(LocalDate expirationDate) {
            return expirationDate.isAfter(LocalDate.now()) ? Freshness.FRESH : Freshness.STALE;
        }

        public OrganicIngredient build() {
            return new OrganicIngredient(this);
        }
    }
}
