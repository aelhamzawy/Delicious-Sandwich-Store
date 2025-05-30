package com.plurasight;

// Abstract base class for all toppings
public abstract class Topping {
    protected String name;      // Name of the topping (e.g. "Ham", "Lettuce")
    protected boolean isExtra;  // Whether the customer wants extra portion of this topping

    // Constructor initializes the name and extra flag
    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    // Returns the name, and adds "(extra)" if it's extra
    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

    // Abstract method to be implemented by subclasses to calculate price based on sandwich size
    public abstract double getPrice(String sandwichSize);
}
