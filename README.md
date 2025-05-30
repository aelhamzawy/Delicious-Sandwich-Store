# 🥪 DELI-cious Sandwich Shop POS Application

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

🧠 Challenges & Solutions
🔄 Dynamic Price Logic
Challenge: Prices needed to change depending on sandwich size and whether the topping was extra.
Solution: Each topping subclass uses a switch statement to return the correct price. If the topping is extra, a small percentage is added to the base price.

🧹 Code Reuse
Challenge: Common behavior like topping name and "extra" label was being repeated in every subclass.
Solution: Moved the shared code to the abstract Topping class so subclasses stay clean and focused only on price logic.

🧱 Easy Expansion
Challenge: Wanted to be able to add more toppings in the future without rewriting everything.
Solution: Used inheritance. You can now create a new topping by making a new class that extends Topping and defines its own prices.

🧪 Input Handling
Challenge: Users might enter incorrect sandwich sizes like "big" or "huge."
Solution: Added simple validation to return 0.0 or an error message if the sandwich size is not recognized.

⚖️ Balanced Simplicity & Flexibility
Challenge: Needed the code to be easy to understand for learners but still show good Java OOP practices.
Solution: Used clear naming, kept methods small, and followed a clean structure using abstraction and polymorphism.
