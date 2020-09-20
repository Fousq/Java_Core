package kz.zhanbolat.chief.entity.ingredient.spice;

public enum SpiceIngredientFactory {
    SALT("Salt", true),
    PEPPER("Pepper", true);

    private final String name;
    private final boolean isPowder;

    SpiceIngredientFactory(String name, boolean isPowder) {
        this.name = name;
        this.isPowder = isPowder;
    }

    public String getName() {
        return name;
    }

    public boolean isPowder() {
        return isPowder;
    }

    public SpiceIngredient create(int weight) {
        return new SpiceIngredient(name, weight, isPowder);
    }
}
