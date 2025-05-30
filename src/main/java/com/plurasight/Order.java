package com.plurasight;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Represents a full customer order with sandwiches, drinks, and chips
public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chipsList;

    // Constructor initializes empty lists
    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chipsList = new ArrayList<>();
    }

    // Add items to the order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    // Calculate the total price of the order
    public double calculateTotal() {
        double total = 0.0;

        for (Sandwich s : sandwiches) {
            total += s.calculatePrice();
        }

        for (Drink d : drinks) {
            total += d.getPrice();
        }

        for (Chips c : chipsList) {
            total += c.getPrice();
        }

        return total;
    }

    // Build a summary of the entire order
    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== ORDER SUMMARY =====\n\n");

        // Sandwiches
        for (int i = 0; i < sandwiches.size(); i++) {
            sb.append("Sandwich #").append(i + 1).append(":\n");
            sb.append(sandwiches.get(i).getDescription()).append("\n");
        }

        // Drinks
        for (int i = 0; i < drinks.size(); i++) {
            sb.append("Drink #").append(i + 1).append(": ");
            sb.append(drinks.get(i).getDescription()).append("\n");
        }

        // Chips
        for (int i = 0; i < chipsList.size(); i++) {
            sb.append("Chips #").append(i + 1).append(": ");
            sb.append(chipsList.get(i).getDescription()).append("\n");
        }

        // Total
        sb.append("\nTotal: $").append(String.format("%.2f", calculateTotal())).append("\n");

        return sb.toString();
    }

    // Save the order summary to a receipt file in a "receipts" folder
    public void saveToReceipt() {
        // Use date and time as file name
        String fileName = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";
        String filePath = "receipts/" + fileName;

        try {
            // Create the receipts folder if it doesn’t exist
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get("receipts"));

            FileWriter writer = new FileWriter(filePath);
            writer.write(getOrderSummary());
            writer.close();

            System.out.println("Receipt saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}

