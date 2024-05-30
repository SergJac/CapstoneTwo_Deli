package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;

    private int size;
    private String drinkSize;
    private boolean drinkAdded;
    private boolean chipsAdded;

    public Order(int size) {
        this.size = size;
        this.drinkSize = "";
        this.drinkAdded = false;
        this.chipsAdded = false;
    }

    public Order() {
        this.sandwiches = new ArrayList<>();
    }


    public double getBreadPrice(int sizeChoice){
        double breadPrice = 0.0;

        switch (sizeChoice) {
            case 1:
                breadPrice = 5.50;
                break;
            case 2:
                breadPrice = 7.00;
                break;
            case 3:
                breadPrice = 8.50;
                break;
            default:
                System.out.println("Invalid bread size.");
                break;
        }

        return breadPrice;
    }



    public double getMeatPrice(int sizeChoice) {
        double meatPrice = 0.0;

        switch (sizeChoice) {
            case 1:
                meatPrice = 1.00;
                break;
            case 2:
                meatPrice = 2.00;
                break;
            case 3:
                meatPrice = 3.00;
                break;
        }
        return meatPrice;
    }

    public double getExtraMeatPrice(int sizeChoice) {
        double extraMeatPrice = 0.0;

        switch (sizeChoice) {
            case 1:
                extraMeatPrice = 0.50;
                break;
            case 2:
                extraMeatPrice = 1.00;
                break;
            case 3:
                extraMeatPrice = 1.50;
                break;
        }
        return extraMeatPrice;
    }

    public double getCheesePrice(int sizeChoice) {
        double cheesePrice = 0.0;

        switch (sizeChoice) {
            case 1:
                cheesePrice = 0.75;
                break;
            case 2:
                cheesePrice = 1.50;
                break;
            case 3:
                cheesePrice = 2.25;
                break;
        }
        return cheesePrice;
    }

    public double getExtraCheesePrice(int sizeChoice) {
        double extraCheesePrice = 0.0;

        switch (sizeChoice) {
            case 1:
                extraCheesePrice = 0.30;
                break;
            case 2:
                extraCheesePrice = 0.60;
                break;
            case 3:
                extraCheesePrice = 0.90;
                break;
        }
        return extraCheesePrice;
    }

    public double getDrinkPrice(int drinkSizeChoice){
        double drinkPrice = 0.0;

        switch (drinkSizeChoice) {
            case 1:
                drinkPrice = 2.00;
                break;
            case 2:
                drinkPrice = 2.50;
                break;
            case 3:
                drinkPrice = 3.00;
                break;
        }
        return drinkPrice;
    }

    public double getChipsPrice(){
        double chipsPrice = 1.50;
        return chipsPrice;
    }

    public double getCheckoutTotal(int sandwichSizeChoice,
                                   boolean extraMeat,
                                   boolean extraCheese,
                                   int drinkSizeChoice,
                                   boolean chipsAdded
    ) {
        double totalPrice = getBreadPrice(sandwichSizeChoice) +
                getMeatPrice(sandwichSizeChoice) +
                getCheesePrice(sandwichSizeChoice);
        if (extraMeat) {
            totalPrice += getExtraMeatPrice(sandwichSizeChoice);
        }

        if (extraCheese) {
            totalPrice += getExtraCheesePrice(sandwichSizeChoice);
        }

        if (drinkAdded) {
            totalPrice += getDrinkPrice(drinkSizeChoice);
        }
        if (chipsAdded) {
            totalPrice += getChipsPrice();
        }

        return totalPrice;
    }

    public void addSandwich(Sandwich sandwich){
        this.sandwiches.add(sandwich);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public int getSize () {
            return size;
    }
    public void setSize (int size){
            this.size = size;
        }
    public String getDrinkSize () {
            return drinkSize;
        }
    public void setDrinkSize (String drinkSize){
            this.drinkSize = drinkSize;
        }

    public boolean isDrinkAdded() {
        return drinkAdded;
    }

    public void setDrinkAdded(boolean drinkAdded) {
        this.drinkAdded = drinkAdded;
    }

    public boolean isChipsAdded() {
        return chipsAdded;
    }

    public void setChipsAdded(boolean chipsAdded) {
        this.chipsAdded = chipsAdded;
    }

    @Override
    public String toString() {
        return "Order{" +
                "size=" + size +
                ", drinkSize='" + drinkSize + '\'' +
                ", drinkAdded=" + drinkAdded +
                ", chipsAdded=" + chipsAdded +
                '}';
    }
}
