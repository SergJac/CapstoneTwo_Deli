package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Drink extends Product{

    private static List<String> drinkList = new ArrayList<>();

    private String size;

    static {
        drinkList.add("Pepsi");
        drinkList.add("Coca Cola");
        drinkList.add("Sprite");
        drinkList.add("Ginger Ale");
        drinkList.add("Orange Juice");
        drinkList.add("Apple Juice");
        drinkList.add("Iced Tea");
        drinkList.add("Water");
    }

    public Drink(double price, String size) {
        super(price);
        this.size = size;

        this.drinkList.get(0);
    }

    public static List<String> getDrinkList() {
        return drinkList;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                '}';
    }
}
