package kz.zhanbolat.chief.entity.ingredient.sauce;

public enum SauceIngredientFactory {
    OLIVE_OIL("Olive oil"), LIMON_JUICE("Limon juice");

    private final String name;

    SauceIngredientFactory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SauceIngredient create(int capacity) {
        return new SauceIngredient(name, capacity);
    }
}
