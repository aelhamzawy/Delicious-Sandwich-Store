package com.plurasight;

// Represents a premium topping: Cheese (e.g. Cheddar, Swiss)
public class Cheese extends Topping {

    // Constructor passes name and extra flag to the Topping base class
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    // Calculates the price of cheese based on sandwich size and extra option
    @Override
    public double getPrice(String sandwichSize) {
        double basePrice = 0.0;

        // Pricing logic based on size
        if (sandwichSize.equals("4")) {
            basePrice = 0.75;
            if (isExtra) basePrice += 0.30;
        } else if (sandwichSize.equals("8")) {
            basePrice = 1.50;
            if (isExtra) basePrice += 0.60;
        } else if (sandwichSize.equals("12")) {
            basePrice = 2.25;
            if (isExtra) basePrice += 0.90;
        }

        return basePrice; // Return total price
    }
}

