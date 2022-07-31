package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Seed.*;

public class Plant {
    String plantName;
    public double hectarArea;
    public int efficiencyHA;
    public double costOfGrowHA;
    public double costOfCollect;
    public double plantPrice;                  // koszt zasiania
    public int plantAgeInWeeks;                // w tygodniach
    public int timeToCollectInWeeks;           // mozna wykorzystac modulo
    public int timeToHydrateInWeeks;
    public int timeToFertilizeInWeeks;
    public boolean abilityToSeed;              // mozna wykorzystac modulo
    public boolean needsWater;
    public boolean ableToCollect;
    public boolean ableToSell;
    public boolean needsFertilizer;
    public double efficiencyOfPlant;

    public Plant(String plantName, double hectarArea, int efficiencyHA, double costOfGrowHA, double costOfCollect, double plantPrice, int plantAgeInWeeks, int timeToCollectInWeeks, int timeToHydrateInWeeks, int timeToFertilizeInWeeks, boolean abilityToSeed, boolean needsWater, boolean ableToCollect, boolean ableToSell, boolean needsFertilizer, double efficiencyOfPlant) {
        this.hectarArea = hectarArea;
        this.plantName = plantName;
        this.efficiencyHA = efficiencyHA;
        this.costOfGrowHA = costOfGrowHA;
        this.costOfCollect = costOfCollect;
        this.plantPrice = plantPrice;
        this.plantAgeInWeeks = plantAgeInWeeks;
        this.timeToCollectInWeeks = timeToCollectInWeeks;
        this.timeToHydrateInWeeks = timeToHydrateInWeeks;
        this.timeToFertilizeInWeeks = timeToFertilizeInWeeks;
        this.abilityToSeed = abilityToSeed;
        this.needsWater = needsWater;
        this.ableToCollect = ableToCollect;
        this.ableToSell = ableToSell;
        this.needsFertilizer = needsFertilizer;
        this.efficiencyOfPlant = efficiencyOfPlant;
    }

    // skaner
    static Scanner scanner = new Scanner(System.in);

    // tworzymy obiekty typu plant z odpowiednimi parametrami:
    static Plant Pszenica = new Plant("Pszenica", 0,  5, 5, 5, 5, 0, 5, 2, 3, false, false, false, false, false, 5);
    static Plant Owies = new Plant("Owies", 0, 5, 5, 5, 5, 0, 5, 2, 3, false, false, false, false, false, 5);
    static Plant Slonecznik = new Plant("Slonecznik", 0, 5, 5, 5, 5, 0, 5, 2, 3, false, false, false, false, false, 5);
    static Plant Marchew = new Plant("Marchew",0, 5, 5, 5, 5, 0, 5, 2, 3, false, false, false, false, false, 5);
    static Plant Ziemniak = new Plant("Ziemniak",0, 5, 5, 5, 5, 0, 5, 2, 3, false, false, false, false, false, 5);


    // lista do gromadzenia roslin usera
    public static List<Plant> userPlants = new ArrayList<>();

    //  tworzymy tablice w ktorej bedziemy zapisywac statusy roslin, zostanie ona utworzona wraz z nowa gra, w trakcie gry bedzie aktualizowana
/*    public static void createListOfPlants() {
        userPlants.add(Pszenica);
        userPlants.add(Owies);
        userPlants.add(Slonecznik);
        userPlants.add(Marchew);
        userPlants.add(Ziemniak);
    }*/

    // metody wyswietlajace
    public void displayPlantSeedParameters(){
        System.out.println("Nazwa rosliny: " + plantName);
        System.out.println("Koszt zasiania: " + plantPrice);
        System.out.println("Ziaren/sadzonek na 1HA: " + efficiencyHA);
        System.out.println("Trzeba podlewać co: " + timeToHydrateInWeeks + " rund");
        System.out.println("Trzeba nawozic co: " + timeToFertilizeInWeeks + " rund");
        System.out.println("Można zebrać po: " + timeToCollectInWeeks + " rund");
    }

    public void displayPlantParameters(){
        System.out.println("Nazwa rosliny: " + plantName);
        System.out.println("Czy potrzebuje podlania: " + needsWater);
        System.out.println("Czy potrzebuje nawozu: " + needsFertilizer);
        System.out.println("Czy można zebrać plon: " + ableToCollect);
    }

    public void displaySeedToPlant() {
        System.out.println("Nazwa rosliny: " + plantName);

        // jak zaciagnac liczbe nasion z seed? -.-
        //System.out.printf("Liczba nasion: ", Seed.userSeeds.get(2), Pszenica);
        System.out.println("Nasiona potrzebne na hektar: " + efficiencyHA);
        System.out.println("Z jednego hektaru otrzymasz: " + efficiencyOfPlant + " TON");
    }



    // sianie roslin
    public static void plantAPlant(){
        System.out.println("Jaka rosline chcialbys zasadzic?");
        System.out.println("1. Pszenica");
        System.out.println("2. Owies");
        System.out.println("3. Slonecznik");
        System.out.println("4. Marchew");
        System.out.println("5. Ziemniak");
        int plantChoice = scanner.nextInt();

        if(plantChoice ==1 && userSeeds.get(0).getHowManySeeds() > Pszenica.efficiencyHA && gameStatus.freeAreaInHA > 0 && gameStatus.userWallet > Pszenica.costOfGrowHA) {
            System.out.println("Masz do dyspozycji: " + userSeeds.get(0).getHowManySeeds() + " nasion pszenicy.");
            System.out.println("Zasiewam 1 HA ziemii pszenica...");
            // dodaje do listy pszenice
            userPlants.add(Pszenica);
            // zmieniamy counter ziarna o efektywnosc siania/HA
            gameStatus.seedPszenicaCounter -= Pszenica.efficiencyHA;
            // zmieniamy ilosc ziaren na liscie statusow ziaren
            userSeeds.set(2, Seed.Pszenica).howManySeeds -= Pszenica.efficiencyHA;
            // zmieniamy ilosc hektarow obsianych pszenica w liscie roslin usera
            userPlants.set(2, Pszenica).hectarArea += 1;
            // zmniejszamy ilosc wolnej ziemii o hektar
            gameStatus.freeAreaInHA -= 1;
            // kasujemy usera za zasianie plonu
            gameStatus.userWallet -= Pszenica.costOfGrowHA;
        }
        else if(plantChoice ==2 && userSeeds.get(1).getHowManySeeds() > Owies.efficiencyHA && gameStatus.freeAreaInHA > 0 && gameStatus.userWallet > Owies.costOfGrowHA) {
            System.out.println("Masz do dyspozycji: " + userSeeds.get(1).getHowManySeeds() + " nasion owsa.");
            System.out.println("Zasiewam 1 HA ziemii owsem...");
            // dodaje do listy pszenice
            userPlants.add(Owies);
            // zmieniamy counter ziarna o efektywnosc siania/HA
            gameStatus.seedOwiesCounter -= Owies.efficiencyHA;
            // zmieniamy ilosc ziaren na liscie statusow ziaren
            userSeeds.set(2, Seed.Owies).howManySeeds -= Owies.efficiencyHA;
            // zmieniamy ilosc hektarow obsianych pszenica w liscie roslin usera
            userPlants.set(2, Owies).hectarArea += 1;
            // zmniejszamy ilosc wolnej ziemii o hektar
            gameStatus.freeAreaInHA -= 1;
            // kasujemy usera za zasianie plonu
            gameStatus.userWallet -= Owies.costOfGrowHA;
        }
        else if(plantChoice ==3 && userSeeds.get(2).getHowManySeeds() > Slonecznik.efficiencyHA && gameStatus.freeAreaInHA > 0 && gameStatus.userWallet > Slonecznik.costOfGrowHA) {
            System.out.println("Masz do dyspozycji: " + userSeeds.get(2).getHowManySeeds() + " nasion slonecznika.");
            System.out.println("Zasiewam 1 HA ziemii slonecznikiem...");
            // dodaje do listy
            userPlants.add(Marchew);
            // zmieniamy counter ziarna o efektywnosc siania/HA
            gameStatus.seedSlonecznikCounter -= Slonecznik.efficiencyHA;
            // zmieniamy ilosc ziaren na liscie statusow ziaren
            userSeeds.set(2, Seed.Slonecznik).howManySeeds -= Slonecznik.efficiencyHA;
            // zmieniamy ilosc hektarow obsianych pszenica w liscie roslin usera
            userPlants.set(2, Slonecznik).hectarArea += 1;
            // zmniejszamy ilosc wolnej ziemii o hektar
            gameStatus.freeAreaInHA -= 1;
            // kasujemy usera za zasianie plonu
            gameStatus.userWallet -= Slonecznik.costOfGrowHA;
        }
        else if(plantChoice ==4 && userSeeds.get(3).getHowManySeeds() > Marchew.efficiencyHA && gameStatus.freeAreaInHA > 0 && gameStatus.userWallet > Marchew.costOfGrowHA) {
            System.out.println("Masz do dyspozycji: " + userSeeds.get(3).getHowManySeeds() + " sadzonek Marchwi.");
            System.out.println("Zasiewam 1 HA ziemii marchwia...");
            // dodaje do listy
            userPlants.add(Marchew);
            // zmieniamy counter ziarna o efektywnosc siania/HA
            gameStatus.seedMarchewCounter -= Marchew.efficiencyHA;
            // zmieniamy ilosc ziaren na liscie statusow ziaren
            userSeeds.set(2, Seed.Marchew).howManySeeds -= Marchew.efficiencyHA;
            // zmieniamy ilosc hektarow obsianych pszenica w liscie roslin usera
            userPlants.set(2, Marchew).hectarArea += 1;
            // zmniejszamy ilosc wolnej ziemii o hektar
            gameStatus.freeAreaInHA -= 1;
            // kasujemy usera za zasianie plonu
            gameStatus.userWallet -= Marchew.costOfGrowHA;
        }
        else if(plantChoice ==5 && userSeeds.get(4).getHowManySeeds() > Ziemniak.efficiencyHA && gameStatus.freeAreaInHA > 0 && gameStatus.userWallet > Ziemniak.costOfGrowHA) {
            System.out.println("Masz do dyspozycji: " + userSeeds.get(4).getHowManySeeds() + " sadzonek ziemniaka.");
            System.out.println("Zasiewam 1 HA ziemii ziemniakiem...");
            // dodaje do listy
            userPlants.add(Ziemniak);
            // zmieniamy counter ziarna o efektywnosc siania/HA
            gameStatus.seedZiemniakCounter -= Ziemniak.efficiencyHA;
            // zmieniamy ilosc ziaren na liscie statusow ziaren
            userSeeds.set(2, Seed.Ziemniak).howManySeeds -= Ziemniak.efficiencyHA;
            // zmieniamy ilosc hektarow obsianych pszenica w liscie roslin usera
            userPlants.set(2, Ziemniak).hectarArea += 1;
            // zmniejszamy ilosc wolnej ziemii o hektar
            gameStatus.freeAreaInHA -= 1;
            // kasujemy usera za zasianie plonu
            gameStatus.userWallet -= Ziemniak.costOfGrowHA;
        }
        else System.out.println("Niestety nie mozesz teraz zasiac zadnych roslin");
    }

    //public void


}



