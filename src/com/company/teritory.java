package com.company;

import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.round;


public class teritory implements Saleable, Buyable {
    public double teritorySize;
    public static double price;

    public teritory(double teritorySize, double price) {
        this.teritorySize = teritorySize;
        this.price = price;
    }

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

//@Override
public static void buy(gameStatus game) {

    // wprowadzimy drobne wahanie ceny ziemii :)
    double random1 = rand.nextDouble();
    price = random1 * (600 - 400);
    price = round(price);

    System.out.println("Cena ziemii wynosi obecnie: " + price);
    System.out.println("Ile hektarów chcesz kupic?");
    Double teritorySize = scanner.nextDouble();
    System.out.println("Cena za: " + teritorySize + " HA ziemii wynosi: " + (price * teritorySize));

    System.out.println("Jesli jestes zdecydowany na kupno, wpisz 1, aby zrezygnowac wpisz 2.");
    int buyDecision = scanner.nextInt();
        if (buyDecision == 1) {
            System.out.println(game.userWallet);
            if (game.userWallet > price) {
                game.freeAreaInHA = game.freeAreaInHA + teritorySize;
                game.userWallet = game.userWallet - price;
                System.out.println("Kupiles: " + teritorySize + " HA ziemii.");
                System.out.println("Obecnie posiadasz: " + game.freeAreaInHA + " wolnych hektarow.");
            } else {
            System.out.println("Niestety, nie stac Cie na zakup.");
        }

        } else if (buyDecision == 2) {
        System.out.println("Ok, moze innym razem cena bardziej Cie zadowoli, przyjdz w przyszlym tygodniu! :)");
        }
}

//@Override
    public static void sell(gameStatus game){

        // wprowadzimy drobne wahanie ceny ziemii :)
        double random2 = rand.nextDouble();
        price = 400 + (600 - 400) * random2;
        price = round(price);

        System.out.println("Cena ziemii wynosi obecnie: " + price);
        System.out.println("Ile hektarów chcesz sprzedac?");
        Double teritorySize = scanner.nextDouble();

        if (teritorySize < game.freeAreaInHA) {
            System.out.println("Cena za: " + teritorySize + " HA ziemii wynosi: " + (price * teritorySize));
            System.out.println("Jesli jestes zdecydowany na sprzedaz, wpisz 1. Jeśli nie chcesz sprzedac, wpisz 2.");
            int sellDecision = scanner.nextInt();

            if(sellDecision == 1) {
                game.freeAreaInHA = game.freeAreaInHA - teritorySize;
                game.userWallet = game.userWallet + price;
                System.out.println("Sprzedales: " + teritorySize + " HA ziemii.");
                System.out.println("Posiadasz teraz: " + game.freeAreaInHA + " HA.");
            } else {
                    System.out.println("Ok, moze innym razem cena bardziej Cie zadowoli, przyjdz w przyszlym tygodniu! :)");
            }
        } else System.out.println("Niestety, nie posiadasz tyle ziemii.");
    }
}



