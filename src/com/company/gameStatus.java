package com.company;

// deklaracje zmiennych związanych ze stanem bieżącej rozgrywki
public class gameStatus {
    public String farmName;
    public double sizeInHA;
    public int weekCounter;                     // numer rundy
    public double userWallet;                   // ilość kasy
    public int buildingCount;
    public int animalSpeciesCount;
    public int plantSpeciesCount;
    boolean shouldContinue;

    public gameStatus() {
        this.farmName = farmName;
        this.sizeInHA = sizeInHA;
        this.weekCounter = weekCounter;
        this.userWallet = userWallet;
        this.buildingCount = buildingCount;
        this.animalSpeciesCount = animalSpeciesCount;
        this.plantSpeciesCount = plantSpeciesCount;
        this.shouldContinue = shouldContinue;
    }

    public void printGameStatus(){
        System.out.println("Tydzień rozgrywki: " +weekCounter +".");
        System.out.println("Twoja farma nazywa się: " + farmName);
        System.out.println("Aktualnie posiadasz: " +sizeInHA + " hektarow ziemii.");
        System.out.println("Dysponujesz lacznie: " +buildingCount+ " budynkami.");
        System.out.println("Masz lacznie: " + animalSpeciesCount + " zwierzat, oraz: "+plantSpeciesCount+" rodzajow roslin.");
    }

    // getter wyrzucający numer rundy (tygodnia)
    public int getWeekCounter() {
    return weekCounter;
    }

    // getter wyrzucający stan portfela
    public double getUserWallet() {
    return userWallet;
    }
}



