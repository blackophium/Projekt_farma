package com.company;

// deklaracje zmiennych związanych ze stanem bieżącej rozgrywki
public class gameStatus {
    // basic
    public String farmName;
    public double sizeInHA;
    // teritory
    public double freeAreaInHA;
    // licznik rund
    public int weekCounter;
    // licznik portfela
    public double userWallet;
    // licznik budynków ogółem
    public int buildingCount;
    // liczniki ziarna
    public int seedPszenicaCounter;
    public int seedOwiesCounter;
    public int seedSlonecznikCounter;
    public int seedMarchewCounter;
    public int seedZiemniakCounter;
    // zwierzeta
    public int animalSpeciesCount;
    public boolean shouldContinue;

    public gameStatus() {
        this.farmName = farmName;
        this.sizeInHA = sizeInHA;
        this.freeAreaInHA = freeAreaInHA;
        this.weekCounter = weekCounter;
        this.userWallet = userWallet;

        // budynki ogolem
        this.buildingCount = buildingCount;

        // ziarno
        this.seedPszenicaCounter = seedPszenicaCounter;
        this.seedOwiesCounter = seedOwiesCounter;
        this.seedSlonecznikCounter = seedSlonecznikCounter;
        this.seedMarchewCounter = seedMarchewCounter;
        this.seedZiemniakCounter = seedZiemniakCounter;

        // zwierzeta
        this.animalSpeciesCount = animalSpeciesCount;

        this.shouldContinue = shouldContinue;
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

    // status podstawowych parametrów gry
    public void displayGameStatus(){
        System.out.println("***** STAN ROZGRYWKI: Farma " + farmName + " *****");
        System.out.println("Aktualnie trwa: " + weekCounter + " tydzien rozgrywki.");
        System.out.println("Masz: " + userWallet + " monet do wykorzystania.");
        System.out.println("Twoja farma ma: " + sizeInHA + " HA powierzchni.");
        System.out.println("Masz do dyspozycji: " + freeAreaInHA + " HA ziemii.");
        System.out.println("Dysponujesz: " + buildingCount + " budynkami.");
    }

    // status ilosci ziarna/sadzonek
    public void displaySeedsStatus() {
        System.out.println("Oto zgromadzone przez Ciebie nasiona i sadzonki:");
        System.out.println("1. Pszenica: " + seedPszenicaCounter + " szt.");
        System.out.println("2. Owies: " + seedOwiesCounter + " szt.");
        System.out.println("3. Slonecznik: " + seedSlonecznikCounter + " szt.");
        System.out.println("4. Marchew: " + seedMarchewCounter + " szt.");
        System.out.println("5. Ziemniak: " + seedZiemniakCounter + " szt.");
    }



    // zakonczenie gry - odpowiednik exitu - niestety nie ma zapisu :(
    public void finishTheGame(){
        System.out.println("Dziekuje za gre! Do zobaczenia nastepnym razem!");
        shouldContinue = false;
    }



// *** GETTERY ***

    // getter wyrzucający numer rundy (tygodnia)
    public int getWeekCounter() {
    return weekCounter;
    }

    // getter wyrzucający stan portfela
    public double getUserWallet() {
    return userWallet;
    }
}