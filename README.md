# 🥪 DELI-cious Sandwich Shop Application

---

## 📖 Project Overview

This Java console application automates order processing for **DELI-cious**, a custom sandwich shop. Customers can fully customize sandwiches (bread, size, toppings, sauces, toasted) and add drinks and chips to their order. The application calculates pricing and saves detailed receipts as timestamped text files.

---

## ✨ Features

- 🍞 Choose bread type: white, wheat, rye, wrap  
- 📏 Select sandwich size: 4", 8", or 12"  
- 🥩 Add premium toppings: meats and cheeses (extra cost for additional servings)  
- 🥗 Add regular toppings and sauces (included at no extra charge)  
- 🔥 Option to toast the sandwich  
- 🥤 Add drinks with size and flavor options  
- 🍟 Add chips  
- 🛒 Multiple items per order  
- 🧾 View order summary before checkout  
- 💾 Save receipt files automatically in a `receipts/` folder with timestamped filenames  

---

## ⚙️ Requirements

- Java Development Kit (JDK) 8 or higher  
- No external libraries required  

---

## 🚀 How to Run

1. Open terminal or command prompt and navigate to the project directory.  
2. Compile all Java files:  
   ```bash
   javac *.java
# 🏗️ Project Structure Overview
###  "I followed an Object-Oriented Programming (OOP) structure to keep the code clean, organized, and easy to extend."

### 🔹 1. Abstract Class for Shared Behavior
I created an abstract class Topping to store shared data like the topping name and whether it's extra.

It also contains a getName() method and an abstract getPrice() method that every topping class must implement.

### 🔹 2. One Class per Topping Type
Each topping (like cheese, bacon, tomato) is a separate class that extends Topping.

These classes implement the price logic based on sandwich size and extra status.

### 🔹 3. Polymorphism for Flexibility
All toppings are treated as the general Topping type in code, but each one behaves differently thanks to method overriding (getPrice()).

This allows easy expansion—new toppings can be added without changing existing logic.

### 🔹 4. Simple Main Program for Testing
The main() method is used to test and display different toppings, their names, and prices based on size and extra flag.

            +----------------------+
            |     <<abstract>>     |
            |       Topping        |
            +----------------------+
            | - name: String       |
            | - isExtra: boolean   |
            +----------------------+
            | + getName(): String  |
            | + getPrice(sandwichSize: String): double |
            +----------------------+
                     ▲
         ┌───────────┼────────────┐
         │           │            │
+----------------+ +----------------+ +-----------------+
| CheeseTopping  | | BaconTopping   | | VeggieTopping   |   <- examples
+----------------+ +----------------+ +-----------------+
| (inherits from Topping)            |
| + getPrice(sandwichSize: String)  |
+-----------------------------------+

               +----------------------+
               |        Drink         |
               +----------------------+
               | - size: String       |
               | - flavor: String     |
               +----------------------+
               | + getPrice(): double |
               | + getDescription(): String |
               +----------------------+


## 🧠 Challenges & Solutions
## 1. 🧾 Naming Toppings Clearly
Challenge: Needed to show when a topping is marked as “extra.”

Solution: Used getName() method to return the name with “(extra)” added automatically.

## 2. 🧮 Different Prices for Different Sizes
Challenge: Each sandwich size has a different price.

Solution: Used a switch statement inside each topping class to set the price for small, medium, and large sandwiches.

## 3. 🔁 Avoid Repeating Code
Challenge: Didn’t want to repeat the same code in every topping class.

Solution: Created a base Topping class with shared code like name and isExtra.

## 4. ➕ Add More Toppings Easily
Challenge: Wanted to add new toppings in the future without changing old code.

Solution: Made each topping its own class that extends Topping, so adding a new one is simple.

## 5. ⚠️ Handle Wrong Size Input
Challenge: What if someone types a size that doesn’t exist?

Solution: Added a default case in the price method to return 0.0 if the size is invalid.
