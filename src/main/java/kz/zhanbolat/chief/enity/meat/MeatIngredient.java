package kz.zhanbolat.chief.enity.meat;

import kz.zhanbolat.chief.enity.Freshness;
import kz.zhanbolat.chief.enity.Ingredient;
import kz.zhanbolat.chief.enity.Softness;

import java.util.Objects;

public class MeatIngredient extends Ingredient {
    private String name;
    private AnimalType animalType;

    public MeatIngredient(Builder builder) {
        this.name = builder.ingredient.getName();
        this.animalType = builder.ingredient.getAnimalType();
        this.freshness = builder.freshness;
        this.softness = builder.softness;
        this.weight = builder.weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MeatIngredient that = (MeatIngredient) o;
        return Objects.equals(name, that.name) &&
                animalType == that.animalType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, animalType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MeatIngredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", animalType=").append(animalType);
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
        private MeatIngredients ingredient;
        private Freshness freshness;
        private Softness softness;
        private int weight;

        public Builder setMeatIngredient(MeatIngredients ingredient) {
            this.ingredient = ingredient;

            return this;
        }

        public Builder setFreshness(Freshness freshness) {
            this.freshness = freshness;

            return this;
        }

        public Builder setSoftness(Softness softness) {
            this.softness = softness;

            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;

            return this;
        }

        public MeatIngredient build() {
            return new MeatIngredient(this);
        }
    }
}
