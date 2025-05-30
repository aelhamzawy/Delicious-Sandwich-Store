package com.plurasight;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==== DELI-cious Sandwich Shop ====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startNewOrder(scanner);
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }

    public static void startNewOrder(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Sandwich sandwich = buildSandwich(scanner);
                    order.addSandwich(sandwich);
                    break;
                case "2":
                    Drink drink = buildDrink(scanner);
                    order.addDrink(drink);
                    break;
                case "3":
                    Chips chips = buildChips(scanner);
                    order.addChips(chips);
                    break;
                case "4":
                    System.out.println("\n" + order.getOrderSummary());
                    System.out.print("Confirm order? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        order.saveToReceipt();
                        ordering = false;
                    }
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static Sandwich buildSandwich(Scanner scanner) {
        System.out.println("\n--- Build Your Sandwich ---");

        System.out.print("Choose bread (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Choose size (4, 8, 12): ");
        String size = scanner.nextLine();

        System.out.print("Do you want it toasted? (y/n): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // Add meats
        System.out.print("Add meats (comma-separated, options: steak, ham, salami, roast beef, chicken, bacon): ");
        String[] meats = scanner.nextLine().split(",");
        for (String meat : meats) {
            meat = meat.trim();
            if (!meat.isEmpty()) {
                System.out.print("Extra " + meat + "? (y/n): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");
                sandwich.addTopping(new Meat(meat, isExtra));
            }
        }

        // Add cheeses
        System.out.print("Add cheeses (comma-separated, options: american, provolone, cheddar, swiss): ");
        String[] cheeses = scanner.nextLine().split(",");
        for (String cheese : cheeses) {
            cheese = cheese.trim();
            if (!cheese.isEmpty()) {
                System.out.print("Extra " + cheese + "? (y/n): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");
                sandwich.addTopping(new Cheese(cheese, isExtra));
            }
        }

        // Regular toppings
        System.out.print("Add regular toppings (comma-separated, options: lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms): ");
        String[] regulars = scanner.nextLine().split(",");
        for (String reg : regulars) {
            reg = reg.trim();
            if (!reg.isEmpty()) {
                sandwich.addTopping(new RegularTopping(reg));
            }
        }

        // Sauces
        System.out.print("Add sauces (comma-separated, options: mayo, mustard, ketchup, ranch, thousand islands, vinaigrette): ");
        String[] sauces = scanner.nextLine().split(",");
        for (String sauce : sauces) {
            sauce = sauce.trim();
            if (!sauce.isEmpty()) {
                sandwich.addTopping(new RegularTopping(sauce));
            }
        }

        System.out.println("Sandwich added!");
        return sandwich;
    }

    public static Drink buildDrink(Scanner scanner) {
        System.out.print("Choose drink size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }

    public static Chips buildChips(Scanner scanner) {
        System.out.print("Enter chip type (e.g., BBQ, Plain, Sour Cream): ");
        String type = scanner.nextLine();
        return new Chips(type);
    }
}
