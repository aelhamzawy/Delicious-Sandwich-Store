package com.plurasight;

public class Meat extends Topping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(String sandwichSize) {
        double basePrice = 0.0;

        // Set price based on size
        if (sandwichSize.equals("4")) {
            basePrice = 1.00;
            if (isExtra) basePrice += 0.50;
        } else if (sandwichSize.equals("8")) {
            basePrice = 2.00;
            if (isExtra) basePrice += 1.00;
        } else if (sandwichSize.equals("12")) {
            basePrice = 3.00;
            if (isExtra) basePrice += 1.50;
        }

        return basePrice;
    }
}
