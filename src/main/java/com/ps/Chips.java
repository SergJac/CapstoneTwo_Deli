package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Chips extends Product{

    private static List<String> chipList = new ArrayList<>();

    public Chips(double price) {
        super(price);
    }

    static {

        chipList.add("Lay's Classic Potato Chips");
        chipList.add("Doritos Nacho Cheese");
        chipList.add("Pringles Original");
        chipList.add("Cheetos Crunchy");
        chipList.add("Tostitos Scoops");
        chipList.add("Fritos Original Corn Chips");

    }

    public static List<String> getChipList() {
        return chipList;
    }
}
