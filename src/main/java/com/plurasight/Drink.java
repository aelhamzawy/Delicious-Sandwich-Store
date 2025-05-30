package com.plurasight;

// Represents a drink with size and flavor
public class Drink {
    private String size;    // "small", "medium", "large"
    private String flavor;  // e.g., "Coke", "Pepsi", "Sprite"

    // Constructor to create a new drink
    public Drink(String size, String flavor) {
        this.size = size.toLowerCase(); // Normalize input
        this.flavor = flavor;
    }

    // Return the price based on drink size
    public double getPrice() {
        switch (size) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.0; // Default to 0 if size is invalid
        }
    }

    // Return a description string for displaying or printing
    public String getDescription() {
        return size + " drink (" + flavor + ") - $" + String.format("%.2f", getPrice());
    }
}
