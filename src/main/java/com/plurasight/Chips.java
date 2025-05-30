package com.plurasight;

// Represents a bag of chips with a fixed price
public class Chips {
    private String type; // Type of chips, e.g., "BBQ", "Plain", etc.

    // Constructor to set the chip type
    public Chips(String type) {
        this.type = type;
    }

    // Chips always cost $1.50 regardless of type
    public double getPrice() {
        return 1.50;
    }

    // Description used in receipts or order summary
    public String getDescription() {
        return "Chips: " + type + " - $1.50";
    }
}

