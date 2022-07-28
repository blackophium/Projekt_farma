package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plant {
    String plantName;
    public double efficiencyHA;
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

    public Plant(String plantName, double efficiencyHA, double costOfGrowHA, double costOfCollect, double plantPrice, int plantAgeInWeeks, int timeToCollectInWeeks, int timeToHydrateInWeeks, int timeToFertilizeInWeeks, boolean abilityToSeed, boolean needsWater, boolean ableToCollect, boolean ableToSell, boolean needsFertilizer, double efficiencyOfPlant) {
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
    Scanner scanner = new Scanner(System.in);

    // lista do gromadzenia roslin usera
    public static List<Plant> userPlants = new ArrayList<>();

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
        //System.out.println("Liczba nasion: " + Seed.getHowManySeeds(plantName));
        System.out.println("Nasiona potrzebne na hektar: " + efficiencyHA);
        System.out.println("Z jednego hektaru otrzymasz: " + efficiencyOfPlant + " TON");
    }


    // tworzymy obiekty typu plant z odpowiednimi parametrami:


    public void plantAPlant(){







    }

}



