package com.plurasight;

import java.util.ArrayList;
import java.util.List;

// Represents a sandwich with bread, size, toast option, and toppings
public class Sandwich {
    private String size;           // Size of the sandwich: "4", "8", or "12"
    private String breadType;      // Type of bread: "white", "wheat", etc.
    private boolean toasted;       // Whether sandwich is toasted
    private List<Topping> toppings; // List of all added toppings

    // Constructor to create a sandwich with the selected options
    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>(); // Initialize empty topping list
    }

    // Add a topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Calculate the total price of the sandwich
    public double calculatePrice() {
        double basePrice = 0;

        // Bread base price depends on sandwich size
        switch (size) {
            case "4":
                basePrice = 5.50;
                break;
            case "8":
                basePrice = 7.00;
                break;
            case "12":
                basePrice = 8.50;
                break;
        }

        // Add the price of all toppings
        for (Topping topping : toppings) {
            basePrice += topping.getPrice(size);
        }

        return basePrice;
    }

    // Get a description of the sandwich for receipts and review
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(breadType).append(" sandwich");
        sb.append(toasted ? " (Toasted)" : " (Not Toasted)");
        sb.append("\nToppings:\n");

        // List each topping
        for (Topping topping : toppings) {
            sb.append(" - ").append(topping.getName()).append("\n");
        }

        // Add total price at the end
        sb.append(String.format("Price: $%.2f\n", calculatePrice()));

        return sb.toString();
    }
}

