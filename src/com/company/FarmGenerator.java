package com.company;

import java.util.*;


public class FarmGenerator extends Farm {
    public static List<Farm> farms = new ArrayList<>();

    public FarmGenerator(String farmName, double sizeInHA, int buildingCount, double price) {
        super(farmName, sizeInHA, buildingCount, price);
    }


    /*public FarmGenerator(String farmName, double sizeInHA, int buildingCount, double price) {
        super(farmName, sizeInHA, buildingCount, price);
    }*/

    // pozwalamy użytkownikowi wprowadzić własne nazwy farm, resztę zrobi za niego generator :)
    public static void generateFarm(){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Podaj nazwe farmy: ");
        String farmName = scanner.nextLine();

        // rozmiar od 2 do 12 HA
        double sizeInHA = rand.nextInt(10)+2;

        // ilosc budynkow miedzy 1 a 3
        int buildingCount = rand.nextInt(2)+1;

        // kalkulator ceny budynku
        double price = sizeInHA * 500 + buildingCount * 1000;

        Farm farmGen = new Farm(farmName, sizeInHA, buildingCount, price);
        farms.add(farmGen);
    }

    public static void displayFarms(){
        for (Farm farm: farms){
            farm.displayFarmInfo();
            System.out.println();
        }
    }

}
