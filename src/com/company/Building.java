package com.company;

import java.util.*;

public class Building {
    public String name;
    public double price;
    public double sizeInHa;

    public Building(String name, double price, double sizeInHa) {
        this.name = name;
        this.price = price;
        this.sizeInHa = sizeInHa;
    }
    
    public static List<Building> userBuildings = new ArrayList<>();

}
