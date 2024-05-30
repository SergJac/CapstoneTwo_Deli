package com.ps;

public class Drink extends Product{

    private String size;

    public Drink(double price, String size) {
        super(price);
        this.size = size;
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
