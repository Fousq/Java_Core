package kz.zhanbolat.chief.enity.organic;

// Enum to declare organic ingredients
public enum OrganicIngredients {
    TOMATO("Tomato", OrganicType.VEGETABLE, true, false);

    private String name;
    private OrganicType organicType;
    private boolean containsSeeds;
    private boolean isPeelable;

    OrganicIngredients(String name, OrganicType organicType, boolean containsSeeds, boolean isPeelable) {
        this.name = name;
        this.organicType = organicType;
        this.containsSeeds = containsSeeds;
        this.isPeelable = isPeelable;
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
}
