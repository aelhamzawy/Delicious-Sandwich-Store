package com.plurasight;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    // Constructor
    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    // Return display name
    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

    // Abstract method to calculate price based on sandwich size
    public abstract double getPrice(String sandwichSize);
}
