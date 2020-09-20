package kz.zhanbolat.chief.entity.ingredient.sauce;

public enum SauceIngredientFactory {
    OLIVE_OIL("Olive oil", true), LIMON_JUICE("Limon juice", false),
    TOMATO_PASTE("Tomato paste", false), VINEGAR("Vinegar", false),
    VEGETABLE_OIL("Vegetable oil", true);

    private final String name;
    private final boolean isOil;

    SauceIngredientFactory(String name, boolean isOil) {
        this.name = name;
        this.isOil = isOil;
    }

    public String getName() {
        return name;
    }

    public SauceIngredient create(int capacity) {
        return new SauceIngredient(name, capacity, isOil);
    }
}
