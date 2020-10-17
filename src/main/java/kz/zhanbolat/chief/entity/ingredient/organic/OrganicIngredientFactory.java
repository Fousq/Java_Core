package kz.zhanbolat.chief.entity.ingredient.organic;

import kz.zhanbolat.chief.entity.ingredient.Softness;

// Enum to declare organic ingredients
public enum OrganicIngredientFactory {
    TOMATO("Tomato", OrganicType.VEGETABLE, true, false, Softness.SOFT),
    BELL_PEPPER("Bell pepper", OrganicType.VEGETABLE, true, false, Softness.SOFT),
    CUCUMBER("Cucumber", OrganicType.VEGETABLE, false, true, Softness.SOFT),
    PITTED_OLIVE("Pitted olive", OrganicType.VEGETABLE, false, false, Softness.SOFT),
    ONION("Onion", OrganicType.VEGETABLE, false, true, Softness.HARD),
    POTATOES("Potatoes", OrganicType.VEGETABLE, false, true, Softness.HARD),
    CABBAGE("CABBAGE", OrganicType.VEGETABLE, false, true, Softness.SOFT),
    BEET("Beet", OrganicType.VEGETABLE, false, true, Softness.HARD),
    CARROT("Carrot", OrganicType.VEGETABLE, false, true, Softness.HARD),
    GARLIC("Garlic", OrganicType.VEGETABLE, false, false, Softness.HARD);

    private final String name;
    private final OrganicType organicType;
    private final boolean containsSeeds;
    private final boolean isPeelable;
    private final Softness softness;

    OrganicIngredientFactory(String name, OrganicType organicType, boolean containsSeeds,
                             boolean isPeelable, Softness softness) {
        this.name = name;
        this.organicType = organicType;
        this.containsSeeds = containsSeeds;
        this.isPeelable = isPeelable;
        this.softness = softness;
    }

    public String getName() {
        return name;
    }

    public OrganicType getOrganicType() {
        return organicType;
    }

    public boolean isContainsSeeds() {
        return containsSeeds;
    }

    public boolean isPeelable() {
        return isPeelable;
    }

    public Softness getSoftness() {
        return softness;
    }

    public OrganicIngredient create(int weight) {
        return OrganicIngredient.builder()
                .setOrganicIngredient(this)
                .setWeight(weight)
                .build();
    }
}
