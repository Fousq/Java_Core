package kz.zhanbolat.chief.entity.ingredient.meat;

// Enum to declare meat ingredients
public enum MeatIngredients {
    CHICKEN_CHEST("Chicken chest", AnimalType.CHICKEN);

    private String name;
    private AnimalType animalType;

    MeatIngredients(String name, AnimalType animalType) {
        this.name = name;
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }
}
