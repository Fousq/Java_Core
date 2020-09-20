package kz.zhanbolat.chief.service;

public enum DishType {
    GREEK_SALAD("Greek salad");

    private final String name;

    DishType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
