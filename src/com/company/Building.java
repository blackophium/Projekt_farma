package com.company;

import java.util.*;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.round;

public class Building implements Buyable, Sellable {
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

    // zestaw budynkow do kupna
    static Building House = new Building("Dom", 4000.0, 0.01);
    static Building Barn = new Building("Stodola", 2000.0, 0.5);
    static Building Enclosure = new Building("Wybieg", 5000.0, 2);
    static Building Chillzone = new Building("Strefa chillu", 900.0, 0.5);
    static Building Chapel = new Building("Kapliczka", 300.0, 0.01);
    static Building Well = new Building("Studnia", 800.0, 0.01);

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // metody do wyswietlania - format
    public void displayBuildingInfo() {
        System.out.println("Nazwa budynku: " + name);
        System.out.println("Cena: " + price);
        System.out.println("Wielkosc w HA: " + sizeInHa);
    }

    // metody do wyswietlania - tablica
    public static void displayBuildings() {
        for (Building building : userBuildings) {
            building.displayBuildingInfo();
            System.out.println();
        }
    }


    // metoda kupna
    public static void buy(gameStatus game) {
        System.out.println("W tej chwili posiadasz: " + game.buildingCount + " budynkow.");
        System.out.println("Masz do dyspozycji: " + game.userWallet + "monet.");

        // wprowadzmy rozne stany mozliwosci zakupu danego typu budynku w danej rundzie,
        // przy kazdej rundzie dostepne beda 2 z 6 typow budynkow o **zmiennej cenie - moze wprowadze pozniej

        // randomy z zakresu 1-6 do wygenerowania budynków
        int randomBuilding1 = random.nextInt(6)+1;
        int randomBuilding2 = random.nextInt(6)+1;

        System.out.println("Jesli chcesz zobaczyc liste dostepnych budynkow wybierz 1.");

        int userChoice = scanner.nextInt();
        if (userChoice == 1 && game.userWallet != 0){
            System.out.println("Dostepne budynki:");

            // teoretycznie przy takim zestawie ifow instrukcje powinny wykonac sie po kolei wpadajac w okreslone luki lub nie...
            if(randomBuilding1 == 1 || randomBuilding2 == 1) {
                House.displayBuildingInfo();
                System.out.println("Jesli chcesz kupic wybierz 1.");
                int decision1 = scanner.nextInt();
                if(decision1 == 1 && game.userWallet > House.price){
                    game.buildingCount = game.buildingCount +1;
                    userBuildings.add(House);
                    game.userWallet = game.userWallet - House.price;
                    System.out.println("Gratulacje, kupiles nowy dom!");
            }}
            if(randomBuilding1 == 2 || randomBuilding2 == 2) {
                Barn.displayBuildingInfo();
                System.out.println("Jesli chcesz kupic wybierz 1.");
                int decision2 = scanner.nextInt();
                if(decision2 == 1 && game.userWallet > Barn.price){
                    game.buildingCount = game.buildingCount +1;
                    userBuildings.add(Barn);
                    game.userWallet = game.userWallet - Barn.price;
                    System.out.println("Gratulacje, kupiles nowa stodole!");
            }}
            if(randomBuilding1 == 3 || randomBuilding2 == 3) {
                Enclosure.displayBuildingInfo();
                System.out.println("Jesli chcesz kupic wybierz 1.");
                int decision3 = scanner.nextInt();
                if(decision3 == 1 && game.userWallet > Enclosure.price){
                    game.buildingCount = game.buildingCount +1;
                    userBuildings.add(Enclosure);
                    game.userWallet = game.userWallet - Enclosure.price;
                    System.out.println("Gratulacje, kupiles nowy wybieg!");
            }}
            if(randomBuilding1 == 4 || randomBuilding2 == 4) {
                Chillzone.displayBuildingInfo();
                System.out.println("Jesli chcesz kupic wybierz 1.");
                int decision4 = scanner.nextInt();
                if(decision4 == 1 && game.userWallet > Chillzone.price){
                    game.buildingCount = game.buildingCount +1;
                    userBuildings.add(Chillzone);
                    game.userWallet = game.userWallet - Chillzone.price;
                    System.out.println("Gratulacje, kupiles nowa strefe chillu!");
            }}
            if(randomBuilding1 == 5 || randomBuilding2 == 5) {
                Chapel.displayBuildingInfo();
                System.out.println("Jesli chcesz kupic wybierz 1.");
                int decision5 = scanner.nextInt();
                if(decision5 == 1 && game.userWallet > Chapel.price){
                    game.buildingCount = game.buildingCount +1;
                    userBuildings.add(Chapel);
                    game.userWallet = game.userWallet - Chapel.price;
                    System.out.println("Gratulacje, kupiles nowa kapliczke!");
                }}
            if(randomBuilding1 == 6 || randomBuilding2 == 6) {
                Well.displayBuildingInfo();
                System.out.println("Jesli chcesz kupic wybierz 1.");
                int decision6 = scanner.nextInt();
                if(decision6 == 1 && game.userWallet > Well.price){
                    game.buildingCount = game.buildingCount + 1;
                    userBuildings.add(Well);
                    game.userWallet = game.userWallet - Well.price;
                    System.out.println("Gratulacje, kupiles nowa studnie!");
            }
        } else {
            System.out.println("Wroc prosze nastepnym razem!");
        }}
    }

    // metoda sprzedaży
    public static void sell(gameStatus game) {
        if(game.buildingCount > 0) {
            System.out.println("Witaj, widze ze chcesz sprzedac ktorys ze swoich budynkow!");
            System.out.println("Oto Twoje obecne budynki:");
            displayBuildings();

            double randomPercent = random.nextDouble();
            randomPercent = round((randomPercent*(100-60)+60)/10.0);

            double sellPrice = 0;

            System.out.println("Dzisiaj moge Ci zaproponowac: " + randomPercent + " procent poczatkowej ceny.");
            System.out.println("Wpisz nazwe budynku, ktory chcesz sprzedac: ");
            String soldBuilding = scanner.nextLine();

            if(userBuildings.contains(soldBuilding)) {
                System.out.println("Masz taki budynek");
                System.out.println("Cena wynosi:");
                for (int i = 0; i < userBuildings.size(); i++) {
                    if (soldBuilding.equals(userBuildings.get(i).getName())) {
                        sellPrice = userBuildings.get(i).getPrice() * randomPercent;
                    }
                }
                System.out.println("Jesli chcesz sprzedac wpisz 1.");
                int finalSellChoice = scanner.nextInt();
                if (finalSellChoice == 1 && game.userWallet > sellPrice) {
                    game.userWallet = game.userWallet + sellPrice;
                    userBuildings.remove(soldBuilding);
                    game.buildingCount = game.buildingCount - 1;
                } else {
                    System.out.println("Brakuje Ci monet lub wybrales wyjscie.");
                }

            } else System.out.println("Niestety nie posiadasz takiego budynku.");
        } else {
            System.out.println("Niestety nie posiadasz zadnych budynkow.");
        }
    }


// *** GETTERY ***

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
}


