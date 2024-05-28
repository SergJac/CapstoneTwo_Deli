package com.ps;

import java.util.ArrayList;

public class Order {

    private int size;
    private String drinkSize;

    private ArrayList<Product> customerOrder;

    public Order(int size, String drinkSize) {
        this.size = size;
        this.drinkSize = drinkSize;

        this.customerOrder = new ArrayList<>();
    }

    public int breadSizeOptions(){
        return size;
    }

    public String getBreadPrice(){
        int chosenBreadSize = breadSizeOptions();
        double breadPrice = 0.0;

        if (chosenBreadSize == 4){
            breadPrice = 5.50;
        } else if (chosenBreadSize == 8){
            breadPrice = 7.00;
        } else if (chosenBreadSize == 12){
            breadPrice = 8.50;
        }
        return String.format("%.2f", breadPrice);
    }

    public String getMeatPrice(){
        int chosenBreadSize = breadSizeOptions();
        double meatPrice = 0.0;

        if (chosenBreadSize == 4){
            meatPrice = 1.00;
        } else if (chosenBreadSize == 8){
            meatPrice = 2.00;
        } else if (chosenBreadSize == 12){
            meatPrice = 3.00;
        }
        return String.format("%.2f", meatPrice);
    }

    public String getExtraMeat(){
        int chosenBreadSize = breadSizeOptions();
        double extraMeatPrice = 0.0;

        if (chosenBreadSize == 4){
            extraMeatPrice = 0.50;
        } else if (chosenBreadSize == 8){
            extraMeatPrice = 1.00;
        } else if (chosenBreadSize == 12){
            extraMeatPrice = 1.50;
        }
        return String.format("%.2f", extraMeatPrice);
    }

    public String getCheesePrice(){
        int chosenBreadSize = breadSizeOptions();
        double cheesePrice = 0.0;

        if (chosenBreadSize == 4){
            cheesePrice = 0.75;
        } else if (chosenBreadSize == 8){
            cheesePrice = 1.50;
        } else if (chosenBreadSize == 12){
            cheesePrice = 2.25;
        }
        return String.format("%.2f", cheesePrice);
    }

    public String getExtraCheese(){
        int chosenBreadSize = breadSizeOptions();
        double extraCheesePrice = 0.0;

        if (chosenBreadSize == 4){
            extraCheesePrice = 0.30;
        } else if (chosenBreadSize == 8){
            extraCheesePrice = 0.60;
        } else if (chosenBreadSize == 12){
            extraCheesePrice = 0.90;
        }
        return String.format("%.2f", extraCheesePrice);
    }

    public void addProduct(Product product){
        this.customerOrder.add(product);
    }

    public String getDrinkPrice(){

        String chosenDrinkSize = drinkSize;
        double drinkPrice = 0.0;

        if (chosenDrinkSize == "Small"){
            drinkPrice = 2.00;
        } else if (chosenDrinkSize == "Medium"){
            drinkPrice = 2.50;
        } else if (chosenDrinkSize == "Large"){
            drinkPrice = 3.00;
        }
        return String.format("%.2f", drinkPrice);
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Order{" +
                "size=" + size +
                '}';
    }
}
