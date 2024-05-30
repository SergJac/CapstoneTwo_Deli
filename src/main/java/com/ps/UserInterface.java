package com.ps;

import javax.sound.midi.Soundbank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserInterface {

    private Order order;
    private String chosenSize;
    private String size;
    private boolean toasted;
    private int sandwichSizeChoice;
    private int breadChoice;
    private int meatChoice;
    private boolean extraMeat;
    private int cheeseChoice;
    private boolean extraCheese;
    private List<String> selectedToppings;
    private List<String> selectedSauces;
    private int drinkSizeChoice;
    private String chosenDrinkSize = "";
    private int chosenDrinkIndex = -1;

    public static Scanner scanner = new Scanner(System.in);



    public void display() {
        int mainMenuCommand;

        do {
            System.out.println("------ Home Screen ------");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            try {
                mainMenuCommand = scanner.nextInt();
                scanner.nextLine();

                switch (mainMenuCommand) {
                    case 1:
                        handleNewOrder();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        System.out.println();
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid choice. Please choose a valid option.");
                scanner.nextLine();
                System.out.println();
                mainMenuCommand = -1;
            }

        }while (mainMenuCommand != 0);
    }

    private void handleNewOrder() {
        int choice;

        Order order = new Order();
        this.order = order;

        do {
            System.out.println("------ New Order ------");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drinks");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            try {
                System.out.print("Please enter your selection: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println();
                        addSandwich(scanner, order, size);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        addDrink(scanner, order, size);
                        break;
                    case 3:
                        System.out.println();
                        addChips(order);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println();
                        displayCheckout();
                        System.out.println();
                        break;
                    case 0:
                        System.out.println("Cancelling the order. Returning to main menu.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        System.out.println();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please choose a valid option.");
                scanner.nextLine();
                System.out.println();
                choice = -1;
            }

        } while (choice != 0);
    }

    public void addSandwich(Scanner scanner, Order order, String size) {

        double price = 0;
        String bread;
        String meat;
        String cheese;

        int sizeChoice;

        do {
            System.out.println("Select sandwich size: ");
            System.out.println("1) 4 Inches");
            System.out.println("2) 8 Inches");
            System.out.println("3) 12 Inches");

            try {

                sizeChoice = scanner.nextInt();
                scanner.nextLine();

                switch (sizeChoice) {
                    case 1:
                        size = "4 Inches";
                        break;
                    case 2:
                        size = "8 Inches";
                        break;
                    case 3:
                        size = "12 Inches";
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        System.out.println();
                        continue;
                }

                this.sandwichSizeChoice = sizeChoice;
                this.chosenSize = size;

                System.out.println("Bread size has been added!");

            Sandwich sandwich = new Sandwich(price, size);

            System.out.println();

            int breadChoice;

            do {
                System.out.println("Select your bread: ");
                for (int i = 0; i < Sandwich.getBreadList().size(); i++) {
                    System.out.println((i + 1) + ") " + Sandwich.getBreadList().get(i));
                }

                try {

                    breadChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (breadChoice >= 1 && breadChoice <= Sandwich.getBreadList().size()) {
                        bread = Sandwich.getBreadList().get(breadChoice - 1);
                        sandwich.setBread(bread);

                    } else {
                        System.out.println("Invalid option. Please choose again.");
                        System.out.println();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    System.out.println();
                    breadChoice = -1;
                }

            } while (breadChoice < 1 || breadChoice > Sandwich.getBreadList().size());

            System.out.println("Your bread type has been added!");

            System.out.println();

            boolean validChoice = false;

            do {

                System.out.println("Do you want the bread toasted? (yes/no)");
                String toastedChoice = scanner.next();

                if (toastedChoice.equalsIgnoreCase("yes")) {
                    setToasted(true);
                    System.out.println("Sandwich will be toasted!");
                    validChoice = true;
                } else if (toastedChoice.equalsIgnoreCase("no")) {
                    setToasted(false);
                    System.out.println("Bread will not be toasted!");
                    validChoice = true;
                } else {
                    System.out.println("Invalid option.Please choose again.");
                    System.out.println();
                }

            } while(!validChoice);

            System.out.println();

            int meatChoice;
            boolean extraMeat = false;

            do {
                System.out.println("Select your meat: ");
                for (int i = 0; i < Sandwich.getMeatList().size(); i++) {
                    System.out.println((i + 1) + ") " + Sandwich.getMeatList().get(i));
                }

                try {

                    meatChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (meatChoice >= 1 && meatChoice <= Sandwich.getMeatList().size()) {
                        meat = Sandwich.getMeatList().get(meatChoice - 1);
                        sandwich.setMeat(meat);

                        System.out.println("Your meat has been added!");

                        System.out.println();

                        do {

                            System.out.println("Do you want extra meat? (yes/no)");
                            String extraMeatChoice = scanner.nextLine();

                            if (extraMeatChoice.equalsIgnoreCase("yes")) {
                                extraMeat = true;
                                System.out.println("Your extra meat has been added!");
                                break;
                            } else if (extraMeatChoice.equalsIgnoreCase("no")) {
                                break;
                            } else {
                                System.out.println("Invalid option. Please choose again.");
                                System.out.println();
                            }

                        } while (true);

                    } else {
                        System.out.println("Invalid option. Please choose again.");
                        System.out.println();
                    }

                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    System.out.println();
                    meatChoice = -1;
                }

            } while (meatChoice < 1 || meatChoice > Sandwich.getMeatList().size());

            System.out.println();

            int cheeseChoice;
            boolean extraCheese = false;

            do {
                System.out.println("Select your cheese: ");
                for (int i = 0; i < Sandwich.getCheeseList().size(); i++) {
                    System.out.println((i + 1) + ") " + Sandwich.getCheeseList().get(i));
                }

                try {

                    cheeseChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (cheeseChoice >= 1 && cheeseChoice <= Sandwich.getCheeseList().size()) {
                        cheese = Sandwich.getCheeseList().get(cheeseChoice - 1);
                        sandwich.setCheese(cheese);

                        System.out.println("Your cheese has been added!");

                        System.out.println();

                        do {

                            System.out.println("Do you want extra cheese? (yes/no)");
                            String extraCheeseChoice = scanner.nextLine();

                            if (extraCheeseChoice.equalsIgnoreCase("yes")) {
                                extraCheese = true;
                                System.out.println("Your extra cheese has been added!");
                                break;
                            } else if (extraCheeseChoice.equalsIgnoreCase("no")) {
                                break;
                            } else {
                                System.out.println("Invalid option. Please choose again.");
                                System.out.println();
                            }

                        } while (true);

                    } else {
                        System.out.println("Invalid option. Please choose again.");
                        System.out.println();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    System.out.println();
                    cheeseChoice = -1;
                }

            } while (cheeseChoice < 1 || cheeseChoice > Sandwich.getCheeseList().size());

            this.breadChoice = breadChoice;
            this.meatChoice = meatChoice;
            this.extraMeat = extraMeat;
            this.cheeseChoice = cheeseChoice;
            this.extraCheese = extraCheese;

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please choose a valid option.");
                scanner.nextLine();
                System.out.println();
                sizeChoice = -1;
            }

        } while (sizeChoice < 1 || sizeChoice > 3);

        System.out.println();

        Sandwich sandwich = new Sandwich(price, size);

        List<String> selectedToppings = new ArrayList<>();

        int toppingsChoice;
        String continueChoice = "";

        do {
            System.out.println("Select your toppings: ");
            System.out.println("0) No toppings");
            for (int i = 0; i < Sandwich.getToppingsList().size(); i++) {
                System.out.println((i + 1) + ") " + Sandwich.getToppingsList().get(i));
            }

            try {
                toppingsChoice = scanner.nextInt();
                scanner.nextLine();

                if (toppingsChoice == 0){
                    break;
                } else if (toppingsChoice >= 1 && toppingsChoice <= Sandwich.getToppingsList().size()) {
                    String selectedTopping = Sandwich.getToppingsList().get(toppingsChoice - 1);
                    selectedToppings.add(selectedTopping);
                } else {
                    System.out.println("Invalid option. Please choose again.");
                    System.out.println();
                    continue;
                }

                System.out.println("Do you want to add more toppings? (yes/no)");
                continueChoice = scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                System.out.println();
                continueChoice = "yes";
            }

        } while (continueChoice.equalsIgnoreCase("yes"));

        System.out.println("Your topping(s) option(s) have been added!");

        System.out.println();

        List<String> selectedSauces = new ArrayList<>();

        int sauceChoice;
        String continueSauceChoice = "";

        do {
            System.out.println("Select your sauce(s): ");
            System.out.println("0) No sauce");
            for (int i = 0; i < Sandwich.getSaucesList().size(); i++) {
                System.out.println((i + 1) + ") " + Sandwich.getSaucesList().get(i));
            }

            try {

                sauceChoice = scanner.nextInt();
                scanner.nextLine();

                if (sauceChoice == 0) {
                    break;
                } else if (sauceChoice >= 1 && sauceChoice <= Sandwich.getSaucesList().size()) {
                    String selectedSauce = Sandwich.getSaucesList().get(sauceChoice - 1);
                    selectedSauces.add(selectedSauce);
                } else {
                    System.out.println("Invalid option. Please choose again.");
                    System.out.println();
                }

                System.out.println("Do you want to add more Sauces? (yes/no)");
                continueSauceChoice = scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                System.out.println();
                continueSauceChoice = "yes";
            }

        } while (continueSauceChoice.equalsIgnoreCase("yes"));

        sandwich.setToppings(selectedToppings.toString());
        sandwich.setSauces(selectedSauces.toString());

        this.selectedToppings = selectedToppings;
        this.selectedSauces = selectedSauces;

        System.out.println("Your sauce(s) option(s) have been added!");

        order.addSandwich(sandwich);

    }

    private void addDrink(Scanner scanner, Order order, String size) {
        order.setDrinkAdded(true);
        int drinkSizeChoice = 0;

        do {

            System.out.println("Select drink: ");
            List<String> drinkList = Drink.getDrinkList();
            for (int i=0;i<drinkList.size();i++){
                System.out.println((i+1) + ") " + drinkList.get(i));
            }

            try {
                int drinkChoice = scanner.nextInt();
                scanner.nextLine();

                if (drinkChoice < 1 || drinkChoice > drinkList.size()){
                    System.out.println("Invalid option. Please choose again.");
                    System.out.println();
                    continue;
                }

                chosenDrinkIndex = drinkChoice - 1;

                System.out.println("Select drink size: ");
                System.out.println("1) Small");
                System.out.println("2) Medium");
                System.out.println("3) Large");


                drinkSizeChoice = scanner.nextInt();
                scanner.nextLine();

                switch (drinkSizeChoice) {
                    case 1:
                        size = "Small";
                        break;
                    case 2:
                        size = "Medium";
                        break;
                    case 3:
                        size = "Large";
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        System.out.println();
                        continue;
                }

                this.drinkSizeChoice = drinkSizeChoice;
                this.chosenDrinkSize = size;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                System.out.println();
                continue;
            }

            } while (drinkSizeChoice < 1 || drinkSizeChoice > 3);

        System.out.println("Your drink has been added!");

        System.out.println();
    }

    private void addChips(Order order){
        order.setChipsAdded(true);

        System.out.println("Please select your chips: ");

        List<String> chipList = Chips.getChipList();
        for (int i=0;i<chipList.size();i++){
            System.out.println((i+1) + ") " + chipList.get(i));
        }

        int selectedChipIndex = 0;
        boolean validInput = false;

        while (!validInput){
            if (scanner.hasNextInt()){
                selectedChipIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedChipIndex >= 1 && selectedChipIndex <= chipList.size()){
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        String selectedChip = chipList.get(selectedChipIndex - 1);
        double chipsPrice = order.getChipsPrice();

        order.setSelectedChip(selectedChip);
        order.setSelectedChipPrice(chipsPrice);

        System.out.println("You have selected: " + selectedChip);
        System.out.println("Your chips have been added!");
    }



    public void displayCheckout(){

        System.out.println("----- Checkout -----");
        System.out.println("Sandwich Size: " + this.chosenSize);
        System.out.println("Selected Bread: " + Sandwich.getBreadList().get(this.breadChoice - 1));
        System.out.println("Bread Toasted: " + (this.toasted ? "Yes" : "No"));
        System.out.printf("Bread Price: $ %.2f%n", order.getBreadPrice(this.sandwichSizeChoice));

        System.out.println("Selected Meat: " + Sandwich.getMeatList().get(this.meatChoice - 1));
        System.out.printf("Meat Price: $ %.2f%n", order.getMeatPrice(this.sandwichSizeChoice));

        System.out.println("Extra Meat: " + (this.extraMeat ? "Yes" : "No"));
        if (this.extraMeat) {
            System.out.printf("Extra Meat Price: $ %.2f%n", order.getExtraMeatPrice(this.sandwichSizeChoice));
        }

        System.out.println("Selected Cheese: " + Sandwich.getCheeseList().get(this.cheeseChoice - 1));
        System.out.printf("Cheese Price: $ %.2f%n", order.getCheesePrice(this.sandwichSizeChoice));

        System.out.println("Extra Cheese: " + (this.extraCheese ? "Yes" : "No"));
        if (this.extraCheese) {
            System.out.printf("Extra Cheese Price: $ %.2f%n", order.getExtraCheesePrice(this.sandwichSizeChoice));
        }

        System.out.println("Selected Toppings: " + this.selectedToppings);
        System.out.println("Selected Sauces: " + this.selectedSauces);

        if (order.isDrinkAdded()){
            System.out.println("Drink Type: " + Drink.getDrinkList().get(chosenDrinkIndex));
            System.out.println("Drink Size: " + this.chosenDrinkSize);
            System.out.printf("Drink Price: $ %.2f%n", order.getDrinkPrice(this.drinkSizeChoice));
        }

        if (order.isChipsAdded()){
            System.out.printf("Chips Type: %s%n", order.getSelectedChip());
            System.out.printf("Chips Price: $ %.2f%n", order.getChipsPrice());
        }

        double totalPrice = order.getCheckoutTotal(
                this.sandwichSizeChoice,
                this.extraMeat,
                this.extraCheese,
                this.drinkSizeChoice,
                order.isChipsAdded()
        );

        System.out.printf("Total Price: $ %.2f%n", totalPrice);

        System.out.println();

        boolean validChoice = false;
        while (!validChoice) {

            System.out.println("Please CONFIRM or CANCEL your order.");
            System.out.println("1) CONFIRM order");
            System.out.println("2) CANCEL order");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                    String fileName = generateFileName();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                        writer.write("----- Receipt -----\n");
                        writer.write("Sandwich Size: " + this.chosenSize + "\n");
                        writer.write("Selected Bread: " + Sandwich.getBreadList().get(this.breadChoice - 1) + "\n");
                        writer.write("Bread Toasted: " + (this.toasted ? "Yes" : "No") + "\n");
                        writer.write(String.format("Bread Price: $ %.2f%n\n", order.getBreadPrice(this.sandwichSizeChoice)));

                        writer.write("Selected Meat: " + Sandwich.getMeatList().get(this.meatChoice - 1) + "\n");
                        writer.write(String.format("Meat Price: $ %.2f%n\n", order.getMeatPrice(this.sandwichSizeChoice)));

                        writer.write("Extra Meat: " + (this.extraMeat ? "Yes" : "No") + "\n");
                        if (this.extraMeat) {
                            writer.write(String.format("Extra Meat Price: $ %.2f%n\n", order.getExtraMeatPrice(this.sandwichSizeChoice)));
                        }

                        writer.write("Selected Cheese: " + Sandwich.getCheeseList().get(this.cheeseChoice - 1) + "\n");
                        writer.write(String.format("Cheese Price: $ %.2f%n\n", order.getCheesePrice(this.sandwichSizeChoice)));

                        writer.write("Extra Cheese: " + (this.extraCheese ? "Yes" : "No") + "\n");
                        if (this.extraCheese) {
                            writer.write(String.format("Extra Cheese Price: $ %.2f%n\n", order.getExtraCheesePrice(this.sandwichSizeChoice)));
                        }

                        writer.write("Selected Toppings: " + this.selectedToppings + "\n");
                        writer.write("Selected Sauces: " + this.selectedSauces + "\n");

                        writer.write("\n");

                        if (order.isDrinkAdded()) {
                            writer.write("Drink Type: " + Drink.getDrinkList().get(chosenDrinkIndex) + "\n");
                            writer.write("Drink Size: " + this.chosenDrinkSize + "\n");
                            writer.write(String.format("Drink Price: $ %.2f%n\n", order.getDrinkPrice(this.drinkSizeChoice)));
                        }

                        if (order.isChipsAdded()) {
                            writer.write(String.format("Chips Type: %s%n\n", order.getSelectedChip()));
                            writer.write(String.format("Chips Price: $ %.2f%n\n", order.getChipsPrice()));
                        }

                        writer.write(String.format("Total Price: $ %.2f%n\n", totalPrice));

                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                      System.out.println("Your order has been confirmed.");
                      validChoice = true;
                      break;
                    case 2:
                        System.out.println("Order canceled");
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter valid input.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter valid input.");
                scanner.nextLine();
            }
        }
        System.out.println();
        display();
    }

    private static String generateFileName(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return timestamp + ".txt";
    }

    public String getChosenSize(){
        return chosenSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}
