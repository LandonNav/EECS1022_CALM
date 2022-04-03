package com.example.calm_app;

public class Stock {
    //Instance variables
    private String name;
    private String symbol;
    private double value;

    //Main constructor
    public Stock(String name, String symbol, double value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
    }

    //Getter methods
    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getValue() {
        return this.value;
    }

    //Setter methods
    public void setValue(double newVal) {
        this.value = newVal;
    }
}