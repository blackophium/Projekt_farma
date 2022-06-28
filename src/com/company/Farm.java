package com.company;

// deklaracja
public class Farm {
    public String farmName;
    public double sizeInHA;
    public int buildingCount;
    public double price;

// konstruktor
    public Farm(String farmName, double sizeInHA, int buildingCount, double price) {
        this.farmName = farmName;
        this.sizeInHA = sizeInHA;
        this.buildingCount = buildingCount;
        this.price = price;
    }

    // gettery
    public String getFarmName() {return farmName;}
    public double getSizeInHA() {return sizeInHA;}
    public double getBuildingCount() {return buildingCount;}
    public double getPrice() {return price;}

    // metoda wyświetlająca farmy
    public void displayFarmInfo(){
        System.out.println("Nazwa farmy: " + farmName);
        System.out.println("Wielkosc w HA: " + sizeInHA);
        System.out.println("Ilosc budynkow: " + buildingCount);
        System.out.println("Cena: " + getPrice());
    }
}
