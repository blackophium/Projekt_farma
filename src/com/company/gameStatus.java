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

    public void displayGameStatus(){
        System.out.println("***** STAN ROZGRYWKI: Farma " + farmName + " *****");
        System.out.println("Aktualnie trwa: " + weekCounter + " tydzien rozgrywki.");
        System.out.println("Masz: " + userWallet + " monet do wykorzystania.");
        System.out.println("Twoja farma ma: " + sizeInHA + " HA powierzchni.");
        System.out.println("Masz do dyspozycji: " + freeAreaInHA + " HA ziemii.");
        System.out.println("Dysponujesz: " + buildingCount + " budynkami, " + animalSpeciesCount + " zwierzetami, oraz " + plantSpeciesCount + " roslinami.");

    }

    public void startNewRound(){
    // metoda inkrementująca lub dekrementująca różne parametry po starcie nowej rundy

        // zwiększa się tydzień o jeden
        weekCounter = weekCounter + 1;
        // otrzymujemy mały bonusik finansowy (inspiracja grą Heroes III)
        userWallet = userWallet + 100;

        // rzeczy dziejące się ze zwierzętami

        // rzeczy dziejące się z roślinami

    }

    // zakonczenie gry - odpowiednik exitu
    public void finishTheGame(){
        System.out.println("Dziekuje za gre! Do zobaczenia nastepnym razem!");
        shouldContinue = false;
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



