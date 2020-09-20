package kz.zhanbolat.chief.entity.ingredient.organic;

import kz.zhanbolat.chief.entity.Ingredient;
import kz.zhanbolat.chief.entity.Softness;

import java.util.Objects;

public class OrganicIngredient extends Ingredient {
    private OrganicType organicType;
    private Softness softness;
    private boolean containsSeeds;
    private boolean isPeelable;

    public OrganicIngredient(Builder builder) {
        super(builder.ingredient.getName(), builder.weight);
        this.softness = builder.ingredient.getSoftness();
        this.containsSeeds = builder.ingredient.isContainsSeeds();
        this.isPeelable = builder.ingredient.isPeelable();
        this.organicType = builder.ingredient.getOrganicType();
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

    public Softness getSoftness() {
        return softness;
    }

    public void setSoftness(Softness softness) {
        this.softness = softness;
    }

    public OrganicType getOrganicType() {
        return organicType;
    }

    public void setOrganicType(OrganicType organicType) {
        this.organicType = organicType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrganicIngredient that = (OrganicIngredient) o;
        return containsSeeds == that.containsSeeds &&
                isPeelable == that.isPeelable &&
                organicType == that.organicType &&
                softness == that.softness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organicType, softness, containsSeeds, isPeelable);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganicIngredient{");
        sb.append("organicType=").append(organicType);
        sb.append(", softness=").append(softness);
        sb.append(", containsSeeds=").append(containsSeeds);
        sb.append(", isPeelable=").append(isPeelable);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", isSliced=").append(isSliced);
        sb.append(", isBoiled=").append(isBoiled);
        sb.append(", isFired=").append(isFired);
        sb.append('}');
        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private OrganicIngredientFactory ingredient;
        private int weight;

        private Builder() {
        }

        public Builder setOrganicIngredient(OrganicIngredientFactory ingredient) {
            this.ingredient = ingredient;

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
