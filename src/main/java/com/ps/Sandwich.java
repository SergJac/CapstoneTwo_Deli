package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product{

    private static List<String> breadList = new ArrayList<>();
    private static List<String> meatList = new ArrayList<>();
    private static List<String> cheeseList = new ArrayList<>();
    private static List<String> regToppingsList = new ArrayList<>();
    private static List<String> saucesList = new ArrayList<>();

    private String bread;
    private String meat;
    private String cheese;
    private String regToppings;
    private String sauces;
    private String sides;

    static {

        breadList.add("White");
        breadList.add("Wheat");
        breadList.add("Rye");
        breadList.add("Wrap");

        meatList.add("Steak");
        meatList.add("Ham");
        meatList.add("Salami");
        meatList.add("Roast Beef");
        meatList.add("Chicken");
        meatList.add("Bacon");

        cheeseList.add("American");
        cheeseList.add("Provolone");
        cheeseList.add("Cheddar");
        cheeseList.add("Swiss");

        regToppingsList.add("Lettuce");
        regToppingsList.add("Peppers");
        regToppingsList.add("Onions");
        regToppingsList.add("Tomatoes");
        regToppingsList.add("Jalepenos");
        regToppingsList.add("Cucumbers");
        regToppingsList.add("Pickles");
        regToppingsList.add("Guacamole");
        regToppingsList.add("Mushrooms");

        saucesList.add("Mayo");
        saucesList.add("Mustard");
        saucesList.add("Ketchup");
        saucesList.add("Ranch");
        saucesList.add("Thousand Islands");
        saucesList.add("Vinaigrette");

    }


    public Sandwich(double price, String sides) {
        super(price);
        this.sides = sides;

        this.bread = breadList.get(0);
        this.meat = meatList.get(0);
        this.cheese = cheeseList.get(0);
        this.regToppings = regToppingsList.get(0);
        this.sauces = saucesList.get(0);
    }

    public static List<String> getBreadList(){
        return breadList;
    }

    public static List<String> getMeatList(){
        return meatList;
    }

    public static List<String> getCheeseList(){
        return cheeseList;
    }

    public static List<String> getRegToppingsList(){
        return regToppingsList;
    }

    public static List<String> getSaucesList(){
        return saucesList;
    }



    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getRegToppings() {
        return regToppings;
    }

    public void setRegToppings(String regToppings) {
        this.regToppings = regToppings;
    }

    public String getSauces() {
        return sauces;
    }

    public void setSauces(String sauces) {
        this.sauces = sauces;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

}
