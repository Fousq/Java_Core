package kz.zhanbolat.chief.entity.ingredient.organic;

import kz.zhanbolat.chief.entity.ingredient.Freshness;
import kz.zhanbolat.chief.entity.ingredient.Ingredient;
import kz.zhanbolat.chief.entity.ingredient.Softness;

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

        public Builder setWeight(int weight) {
            this.weight = weight;

            return this;
        }

        public OrganicIngredient build() {
            return new OrganicIngredient(this);
        }
    }
}
