package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seed implements Buyable, Saleable {
    public String plantName;
    public double seedPrice;
    public int howManySeeds;
    public double efficiencyHA;
    public double costOfGrowHA;                // sprawdz czy wolna ziemia, ile chcesz zasiac, przemnoz, zagospodaruj teren, odejmij od kasy
    public double costOfCollect;

    public Seed(String plantName, double seedPrice, int howManySeeds, double efficiencyHA, double costOfGrowHA, double costOfCollect) {
        this.plantName = plantName;
        this.seedPrice = seedPrice;
        this.howManySeeds = howManySeeds;
        this.efficiencyHA = efficiencyHA;
        this.costOfGrowHA = costOfGrowHA;
        this.costOfCollect = costOfCollect;
    }

    // metoda do wyswietlania - format
    public void displaySeedsInfo() {
        System.out.println("Nazwa rosliny: " + plantName);
        System.out.println("Cena: " + seedPrice);
        System.out.println("Ilosc: " + howManySeeds);
        System.out.println("Wydajnosc: " + efficiencyHA);
        System.out.println("Koszt wzrostu/tydzien: " + costOfGrowHA);
        System.out.println("Koszt zebrania/HA: " + costOfCollect);
    }

    // metoda do wyswietlania - lista
    public static void displaySeeds() {
        for (Seed seed : userSeeds) {
            seed.displaySeedsInfo();
            System.out.println();
        }
    }

    // setter ilosci ziaren
    public void setHowManySeeds(int howManySeeds) {
        this.howManySeeds = howManySeeds;
    }

    // jakies tam randomowe ziarna

    static Seed Pszenica = new Seed("Pszenica", 100, 0, 10, 20, 5);
    static Seed Owies = new Seed("Owies", 90, 0, 20, 15, 10);
    static Seed Slonecznik = new Seed("Slonecznik", 75, 0, 11, 18, 10);
    static Seed Marchew = new Seed("Marchew", 100, 0, 20, 7, 11);
    static Seed Ziemniak = new Seed("Ziemniak", 90, 0, 40, 5, 5);

    // lista do gromadzenia ziarna
    public static List<Seed> userSeeds = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    // kupno ziarna z wyswietleniem statusu
    public static void buy(gameStatus game) {
        System.out.println("Masz do dyspozycji: " + game.userWallet + "monet.");
        System.out.println("Jesli chcesz kupic sadzonki wybierz 1.");

        // zapelniamy liste userowych roslinek ale w kazdym przypadku ilosc ziaren wynosi zero
        userSeeds.add(Pszenica);
        userSeeds.add(Owies);
        userSeeds.add(Slonecznik);
        userSeeds.add(Marchew);
        userSeeds.add(Ziemniak);

        int userChoice = scanner.nextInt();
        if (userChoice == 1 && game.userWallet != 0) {
            System.out.println("Dostepne ziarno/sadzonki:");
            System.out.println("1. Pszenica");
            System.out.println("2. Owies");
            System.out.println("3. Slonecznik");
            System.out.println("4. Marchew");
            System.out.println("5. Ziemniak");

            System.out.println("Wybierz liczbe odpowiadajaca sadzonce:");
            int decision = scanner.nextInt();

            // wybor powoduje zwiekszenie liczby ziaren na liscie i zmniejszenie ilosci gotowki
            if (decision == 1){
                System.out.println("Podaj ilosc:");
                int seedAmount = scanner.nextInt();
                // czy usera na to stac?
                if(game.userWallet > Pszenica.seedPrice * seedAmount) {
                    userSeeds.set(2, Pszenica).howManySeeds =+ seedAmount;
                    game.userWallet = game.userWallet - Pszenica.seedPrice * seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 2){
                System.out.println("Podaj ilosc:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Owies.seedPrice * seedAmount) {
                    userSeeds.set(2, Owies).howManySeeds =+ seedAmount;
                    game.userWallet = game.userWallet - Owies.seedPrice * seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 3) {
                System.out.println("Podaj ilosc:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Slonecznik.seedPrice * seedAmount) {
                    userSeeds.set(2, Slonecznik).howManySeeds = +seedAmount;
                    game.userWallet = game.userWallet - Slonecznik.seedPrice * seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 4){
                System.out.println("Podaj ilosc:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Marchew.seedPrice * seedAmount) {
                    userSeeds.set(2, Marchew).howManySeeds = +seedAmount;
                    game.userWallet = game.userWallet - Marchew.seedPrice * seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 5){
                System.out.println("Podaj ilosc:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Ziemniak.seedPrice * seedAmount) {
                    userSeeds.set(2, Ziemniak).howManySeeds =+ seedAmount;
                    game.userWallet = game.userWallet - Ziemniak.seedPrice * seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }  else System.out.println("Wroc nastepnym razem!");
        }
    }
}
