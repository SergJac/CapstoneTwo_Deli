package com.ps;

public abstract class Product {

    private double price;

    public Product(double price) {
        this.price = price;
    }

    public double calcPrice(){
        return this.price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                '}';
    }
}
