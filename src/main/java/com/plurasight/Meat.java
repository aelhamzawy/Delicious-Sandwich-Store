package com.plurasight;

// Represents a premium topping: Meat (e.g. Ham, Steak)
public class Meat extends Topping {

    // Constructor passes name and extra flag to the Topping base class
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    // Calculates the price of the meat based on sandwich size and whether it's extra
    @Override
    public double getPrice(String sandwichSize) {
        double basePrice = 0.0;

        // Pricing logic based on size
        if (sandwichSize.equals("4")) {
            basePrice = 1.00; // Base price for 4"
            if (isExtra) basePrice += 0.50; // Add cost if extra
        } else if (sandwichSize.equals("8")) {
            basePrice = 2.00;
            if (isExtra) basePrice += 1.00;
        } else if (sandwichSize.equals("12")) {
            basePrice = 3.00;
            if (isExtra) basePrice += 1.50;
        }

        return basePrice; // Return total price
    }
}
