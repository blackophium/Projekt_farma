package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("AccessStaticViaInstance")
public class Seed implements Buyable, Sellable {
    public String plantName;
    public double seedPrice;
    public int howManySeeds;


    public Seed(String plantName, double seedPrice, int howManySeeds) {
        this.plantName = plantName;
        this.seedPrice = seedPrice;
        this.howManySeeds = howManySeeds;
    }

    // lista do gromadzenia ziarna
    public static List<Seed> userSeeds = new ArrayList<>();

    static Seed Pszenica = new Seed("Pszenica", 100, 0);
    static Seed Owies = new Seed("Owies", 90, 0);
    static Seed Slonecznik = new Seed("Slonecznik", 75, 0);
    static Seed Marchew = new Seed("Marchew", 100, 0);
    static Seed Ziemniak = new Seed("Ziemniak", 90, 0);

//  tworzymy tablice w ktorej bedziemy zapisywac statusy ziarna, zostanie ona utworzona wraz z nowa gra, w trakcie gry bedzie aktualizowana
    public static void createListOfSeeds() {
        userSeeds.add(Pszenica);
        userSeeds.add(Owies);
        userSeeds.add(Slonecznik);
        userSeeds.add(Marchew);
        userSeeds.add(Ziemniak);
    }

    // skaner
    static Scanner scanner = new Scanner(System.in);

// metoda kupna
    public static void buy(gameStatus game) {
        System.out.println("Masz do dyspozycji: " + game.userWallet + "monet.");
        System.out.println("Jesli chcesz kupic sadzonki wybierz 1.");

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
                System.out.println("Podaj ilosc pszenicy:");
                int seedAmount = scanner.nextInt();
                // czy usera na to stac?
                if(game.userWallet > Pszenica.seedPrice * seedAmount) {
                    userSeeds.set(2, Pszenica).howManySeeds += seedAmount;
                    game.userWallet = game.userWallet - Pszenica.seedPrice * seedAmount;
                    game.seedPszenicaCounter += seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 2){
                System.out.println("Podaj ilosc owsu:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Owies.seedPrice * seedAmount) {
                    userSeeds.set(2, Owies).howManySeeds += seedAmount;
                    game.userWallet = game.userWallet - Owies.seedPrice * seedAmount;
                    game.seedOwiesCounter += seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 3) {
                System.out.println("Podaj ilosc slonecznika:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Slonecznik.seedPrice * seedAmount) {
                    userSeeds.set(2, Slonecznik).howManySeeds += seedAmount;
                    game.userWallet = game.userWallet - Slonecznik.seedPrice * seedAmount;
                    game.seedSlonecznikCounter += seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 4){
                System.out.println("Podaj ilosc marchwi:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Marchew.seedPrice * seedAmount) {
                    userSeeds.set(2, Marchew).howManySeeds += seedAmount;
                    game.userWallet = game.userWallet - Marchew.seedPrice * seedAmount;
                    game.seedMarchewCounter += seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }
            else if (decision == 5){
                System.out.println("Podaj ilosc ziemniaka:");
                int seedAmount = scanner.nextInt();
                if(game.userWallet > Ziemniak.seedPrice * seedAmount) {
                    userSeeds.set(2, Ziemniak).howManySeeds += seedAmount;
                    game.userWallet = game.userWallet - Ziemniak.seedPrice * seedAmount;
                    game.seedZiemniakCounter += seedAmount;
                } else System.out.println("Niestety nie stac Cie na to.");
            }  else System.out.println("Wroc nastepnym razem!");
        }
    }



    // metoda sprzedaży
    public static void sell(gameStatus game){
        System.out.println("Jesli chcesz sprzedac nasiona wybierz 1.");
        int userChoice = scanner.nextInt();

        if(userChoice == 1) {
            System.out.println("Wybierz jakie nasiona chcesz sprzedac (podaj odpowiadajacy numer):");
            game.displaySeedsStatus();

            // sprzedaz konkretnej ilosci nasion wg decyzji usera
            int sellDecision = scanner.nextInt();

            if(sellDecision == 1 && game.seedPszenicaCounter > 0){
                System.out.println("Ile nasion chcesz sprzedac?");
                int seedAmount = scanner.nextInt();
                if(seedAmount <= game.seedPszenicaCounter){
                    userSeeds.set(2, Pszenica).howManySeeds -= seedAmount;
                    game.seedPszenicaCounter -= seedAmount;
                    game.userWallet += seedAmount * Pszenica.seedPrice;
                }
            } else System.out.println("Nie masz tylu nasion!");

            if(sellDecision == 2 && game.seedOwiesCounter > 0){
                System.out.println("Ile nasion chcesz sprzedac?");
                int seedAmount = scanner.nextInt();
                if(seedAmount <= game.seedOwiesCounter){
                    userSeeds.set(2, Owies).howManySeeds -= seedAmount;
                    game.seedOwiesCounter -= seedAmount;
                    game.userWallet += seedAmount * Owies.seedPrice;
                }
            } else System.out.println("Nie masz tylu nasion!");

            if(sellDecision == 3 && game.seedSlonecznikCounter > 0){
                System.out.println("Ile nasion chcesz sprzedac?");
                int seedAmount = scanner.nextInt();
                if(seedAmount <= game.seedSlonecznikCounter){
                    userSeeds.set(2, Slonecznik).howManySeeds -= seedAmount;
                    game.seedSlonecznikCounter -= seedAmount;
                    game.userWallet += seedAmount * Slonecznik.seedPrice;
                }
            } else System.out.println("Nie masz tylu nasion!");

            if(sellDecision == 4 && game.seedMarchewCounter > 0){
                System.out.println("Ile sadzonek chcesz sprzedac?");
                int seedAmount = scanner.nextInt();
                if(seedAmount <= game.seedMarchewCounter){
                    userSeeds.set(2, Marchew).howManySeeds -= seedAmount;
                    game.seedMarchewCounter -= seedAmount;
                    game.userWallet += seedAmount * Marchew.seedPrice;
                }
            } else System.out.println("Nie masz tylu sadzonek!");

            if(sellDecision == 5 && game.seedZiemniakCounter > 0){
                System.out.println("Ile nasion chcesz sprzedac?");
                int seedAmount = scanner.nextInt();
                if(seedAmount <= game.seedZiemniakCounter){
                    userSeeds.set(2, Ziemniak).howManySeeds -= seedAmount;
                    game.seedZiemniakCounter -= seedAmount;
                    game.userWallet += seedAmount * Ziemniak.seedPrice;
                }
            } else System.out.println("Nie masz tylu nasion!");

        } else System.out.println("Wroc prosze nastepny razem!");
    }


// *** GETTERY I SETTERY ***

    // setter ilosci ziaren
    public void setHowManySeeds(int howManySeeds) {
        this.howManySeeds = howManySeeds;
    }

    public int getHowManySeeds() {
        return howManySeeds;
    }


}

