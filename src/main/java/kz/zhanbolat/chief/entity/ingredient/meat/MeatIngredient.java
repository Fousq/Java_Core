package kz.zhanbolat.chief.entity.ingredient.meat;

import kz.zhanbolat.chief.entity.Ingredient;

import java.util.Objects;

public class MeatIngredient extends Ingredient {
    private AnimalType animalType;

    public MeatIngredient(String name, int weight, AnimalType animalType) {
        super(name, weight);
        this.animalType = animalType;
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
        sb.append("animalType=").append(animalType);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", isSliced=").append(isSliced);
        sb.append(", isBoiled=").append(isBoiled);
        sb.append(", isFried=").append(isFried);
        sb.append('}');
        return sb.toString();
    }
}
