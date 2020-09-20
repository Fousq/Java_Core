package kz.zhanbolat.chief.entity.ingredient.cheese;

public enum CheeseIngredientFactory {
    FETA_CHEESE("Feta cheese", false);

    private final String name;
    private final boolean isMoldy;

    CheeseIngredientFactory(String name, boolean isMoldy) {
        this.name = name;
        this.isMoldy = isMoldy;
    }

    public String getName() {
        return name;
    }

    public boolean isMoldy() {
        return isMoldy;
    }

    public CheeseIngredient create(int weight) {
        return new CheeseIngredient(name, weight, isMoldy);
    }
}
