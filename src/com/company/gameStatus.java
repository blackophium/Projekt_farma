package com.company;

// deklaracje zmiennych związanych ze stanem bieżącej rozgrywki
public class gameStatus {
    public String farmName;
    public double sizeInHA;
    public double freeAreaInHA;
    public int weekCounter;                     // numer rundy
    public double userWallet;                   // ilość kasy
    public int buildingCount;
    public int animalSpeciesCount;
    public int plantSpeciesCount;
    public boolean shouldContinue;

    public gameStatus() {
        this.farmName = farmName;
        this.sizeInHA = sizeInHA;
        this.freeAreaInHA = freeAreaInHA;
        this.weekCounter = weekCounter;
        this.userWallet = userWallet;
        this.buildingCount = buildingCount;
        this.animalSpeciesCount = animalSpeciesCount;
        this.plantSpeciesCount = plantSpeciesCount;
        this.shouldContinue = shouldContinue;
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



