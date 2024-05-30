# Delicious Sandwiches Application

This Java application simulates a sandwich shop where users can place orders for sandwiches, drinks, and chips.

## Classes

### 1. Main

- `Main` class contains the main method to start the application.
- It initializes a `UserInterface` object and calls the `display()` method to begin the user interface.

### 2. Product

- `Product` is an abstract class representing a generic product with a price.
- It provides methods to calculate and retrieve the price of the product.

### 3. Sandwich

- `Sandwich` class extends `Product`.
- Represents a sandwich product with various customizable options such as bread type, meat, cheese, toppings, and sauces.
- It initializes predefined lists of bread, meat, cheese, toppings, and sauces.
- Provides methods to set and get sandwich details.

### 4. Drink

- `Drink` class extends `Product`.
- Represents a drink product with a customizable size.
- Provides methods to set and get drink details.

### 5. Chips

- `Chips` class extends `Product`.
- Represents a chips product.
- Provides methods to set and get chips details.

### 6. Order

- `Order` class manages the user's order.
- It stores a list of sandwiches, selected size, drink size, and flags indicating whether a drink or chips are added.
- Provides methods to calculate the total price of the order and manage order items.

### 7. UserInterface

- `UserInterface` class handles user interactions through the command-line interface.
- It allows users to place new orders, add sandwiches, drinks, and chips to the order, and checkout.
- Provides methods to display menus, handle user input, and generate a text file receipt.

## Usage

1. Run the `Main` class to start the application.
2. Follow the prompts on the command line to place orders, customize sandwich options, add drinks and chips, and proceed to checkout.
3. After checkout, a receipt file with the order details will be generated in the project directory.