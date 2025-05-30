package com.plurasight;

// Represents a regular (free) topping like lettuce, tomato, onions, sauces, etc.
public class RegularTopping extends Topping {

    // Constructor - regular toppings are always not extra, so we set isExtra to false
    public RegularTopping(String name) {
        super(name, false);
    }

    // Price is always 0 for regular toppings, regardless of sandwich size
    @Override
    public double getPrice(String sandwichSize) {
        return 0.0;
    }
}
