package com.company;

import java.util.*;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.round;

public class Building implements Buyable, Saleable {
    public String name;
    public double price;
    public double sizeInHa;

    public Building(String name, double price, double sizeInHa) {
        this.name = name;
        this.price = price;
        this.sizeInHa = sizeInHa;
    }

    // lista do gromadzenia budynkow usera
    public static List<Building> userBuildings = new ArrayList<>();

    // metody do wyswietlania - format
    public void displayBuildingInfo() {
        System.out.println("Nazwa budynku: " + name);
        System.out.println("Wielkosc w HA: " + sizeInHa);
    }

    // metody do wyswietlania - tablica
    public static void displayBuildings() {
        for (Building building : userBuildings) {
            building.displayBuildingInfo();
            System.out.println();
        }
    }

    public static void buy(gameStatus game) {
        System.out.println("W tej chwili posiadasz: " + game.buildingCount + " budynkow.");
        System.out.println("Masz do dyspozycji: " + game.userWallet + "monet.");

    }

    public static void sell(gameStatus game) {


    }

}

