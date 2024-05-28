package com.ps;

public class Chips extends Product{

    public Chips(double price) {
        super(price);
    }

    public String getChipsPrice(){
        double chipsPrice = 1.50;
        return String.format("%.2f", chipsPrice);
    }


}
