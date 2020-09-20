package kz.zhanbolat.chief.entity.ingredient.meat;

// Enum to declare meat ingredients
public enum MeatIngredientFactory {
    CHICKEN_CHEST("Chicken chest", AnimalType.CHICKEN),
    COW_PULP("Cow pulp", AnimalType.COW);

    private String name;
    private AnimalType animalType;

    MeatIngredientFactory(String name, AnimalType animalType) {
        this.name = name;
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public MeatIngredient create(int weight) {
        return new MeatIngredient(name, weight, animalType);
    }
}
