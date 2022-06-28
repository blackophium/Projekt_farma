package com.company;

import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        // parametry podstawowe
        Scanner scanner = new Scanner(System.in);
        gameStatus newGame = new gameStatus();
        newGame.weekCounter = 0;
        newGame.userWallet = 10000.0;
        newGame.animalSpeciesCount = 0;
        newGame.plantSpeciesCount = 0;
        newGame.shouldContinue = true;


        System.out.println("Witaj w symulatorze farmy! Aby rozpoczac nowa gre podaj swoje imie...");
        String playerName = scanner.nextLine();
        System.out.println("Czesc " + playerName + " za chwile rozpocznie sie Twoja przygoda na wsi!");


        // generujemy farmy do wyboru

        System.out.println("Na start prosze abys wygenerowal sobie 5 farm. W tym celu wprowadz ich nazwy:");

        for (int i = 1; i < 6; i++) {
            System.out.println("Farma numer: " + i);
            FarmGenerator.generateFarm();
        }

        System.out.println("Oto lista dostepnych dla Ciebie farm:");
        FarmGenerator.displayFarms();

        // wybór farmy przez użytkownika

        System.out.println("Prosze wybierz jedna z wygenerowanych farm by przejsc dalej. W tym celu wpisz numer wyboru:");
        int farmUserChoice = scanner.nextInt();

        // do parametrów początkowych gry przypisuję parametry wybranej farmy
        // gra zabezpieczona jest tak, że na poczatku zawsze stac nas na kazdy z wyborow, bo pozniej juz nie zmieniamy farmy tylko rozbudowujemy ją
        switch (farmUserChoice) {

            case 1:
                //System.out.println(FarmGenerator.farms.get(0));
                newGame.farmName = FarmGenerator.farms.get(0).farmName;
                newGame.sizeInHA = FarmGenerator.farms.get(0).sizeInHA;
                newGame.buildingCount = FarmGenerator.farms.get(0).buildingCount;
                newGame.userWallet = newGame.userWallet - FarmGenerator.farms.get(0).price;
                break;
            case 2:
                System.out.println(FarmGenerator.farms.get(1));
                newGame.farmName = FarmGenerator.farms.get(1).farmName;
                newGame.sizeInHA = FarmGenerator.farms.get(1).sizeInHA;
                newGame.buildingCount = FarmGenerator.farms.get(1).buildingCount;
                newGame.userWallet = newGame.userWallet - FarmGenerator.farms.get(1).price;
                break;
            case 3:
                System.out.println(FarmGenerator.farms.get(2));
                newGame.farmName = FarmGenerator.farms.get(2).farmName;
                newGame.sizeInHA = FarmGenerator.farms.get(2).sizeInHA;
                newGame.buildingCount = FarmGenerator.farms.get(2).buildingCount;
                newGame.userWallet = newGame.userWallet - FarmGenerator.farms.get(2).price;
                break;
            case 4:
                System.out.println(FarmGenerator.farms.get(3));
                newGame.farmName = FarmGenerator.farms.get(3).farmName;
                newGame.sizeInHA = FarmGenerator.farms.get(3).sizeInHA;
                newGame.buildingCount = FarmGenerator.farms.get(3).buildingCount;
                newGame.userWallet = newGame.userWallet - FarmGenerator.farms.get(3).price;
                break;
            case 5:
                System.out.println(FarmGenerator.farms.get(4));
                newGame.farmName = FarmGenerator.farms.get(4).farmName;
                newGame.sizeInHA = FarmGenerator.farms.get(4).sizeInHA;
                newGame.buildingCount = FarmGenerator.farms.get(4).buildingCount;
                newGame.userWallet = newGame.userWallet - FarmGenerator.farms.get(4).price;
                break;
        }

        System.out.println("Wstepna konfiguracja jest juz prawie gotowa!");

        // test zapisu stanu początkowego
        // System.out.println(newGame.sizeInHA);
        // System.out.println(newGame.buildingCount);
        // System.out.println(newGame.userWallet);

        System.out.println("Masz do dyspozycji: " + newGame.buildingCount + "budynki.");
        System.out.println("Najwyzszy czas okreslic ich przeznaczenie i kupic wyposazenie.");
        System.out.println("W sklepie dostepne jest kilka wariantow wyposazenia. Dokonaj wyboru!");

        // roboczo tworze sobie jakies budynki zeby rozdysponowac ta wygenerowana ilosc przed przejsciem do glownego menu
        Building House = new Building("Dom", 4000.0, 0.01);
        Building Barn = new Building("Stodola", 2000.0, 0.5);
        Building Enclosure = new Building("Wybieg", 5000.0, 2);
        Building Chillzone = new Building("Strefa chillu", 900.0, 0.5);
        Building Chapel = new Building("Kapliczka", 300.0, 0.01);

        int firstBuildingCounter = newGame.buildingCount;
        double freeAreaInHA = newGame.sizeInHA;
        if (firstBuildingCounter > 0) {
            if (newGame.userWallet > 0 && newGame.sizeInHA > 0) {
                System.out.println("Dostepne budynki:");
                System.out.println("1. " + House.name + ", cena: " + House.price + ", powierzchnia: " + House.sizeInHa + " HA");
                System.out.println("2. " + Barn.name + ", cena: " + Barn.price + ", powierzchnia: " + Barn.sizeInHa + " HA");
                System.out.println("3. " + Enclosure.name + ", cena: " + Enclosure.price + ", powierzchnia: " + Enclosure.sizeInHa + " HA");
                System.out.println("4. " + Chillzone.name + ", cena: " + Chillzone.price + ", powierzchnia: " + Chillzone.sizeInHa + " HA");
                System.out.println("5. " + Chapel.name + ", cena: " + Chapel.price + ", powierzchnia: " + Chapel.sizeInHa + " HA");
                System.out.println("");


                // mechanizm wyboru przeznaczenia podstawowych budynków z generatora - aktualizuje "wielkość" dostępnej ziemii
                // oraz dodaje wybrane budynki do listy budynków uzytkownika
                // na koniec pętli userowi zostaje 0 budynkow do rozdysponowania i dzieki temu mozemy rozpoczac wlasciwa rozgrywke

                System.out.println("Podaj numer budynku który wybierasz do zakupu:");
                int buildingUserChoice = scanner.nextInt();
                switch (buildingUserChoice) {
                    case 1:
                        newGame.userWallet = newGame.userWallet - House.price;
                        freeAreaInHA = newGame.sizeInHA - House.sizeInHa;
                        firstBuildingCounter = firstBuildingCounter - 1;
                        Building.userBuildings.add(House);
                        System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki i " + newGame.userWallet + " pieniędzy.");
                        break;
                    case 2:
                        newGame.userWallet = newGame.userWallet - Barn.price;
                        freeAreaInHA = newGame.sizeInHA - Barn.sizeInHa;
                        firstBuildingCounter = firstBuildingCounter - 1;
                        Building.userBuildings.add(Barn);
                        System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki i " + newGame.userWallet + " pieniędzy.");
                        break;
                    case 3:
                        newGame.userWallet = newGame.userWallet - Enclosure.price;
                        freeAreaInHA = newGame.sizeInHA - Enclosure.sizeInHa;
                        firstBuildingCounter = firstBuildingCounter - 1;
                        Building.userBuildings.add(Enclosure);
                        System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki i " + newGame.userWallet + " pieniędzy.");
                        break;
                    case 4:
                        newGame.userWallet = newGame.userWallet - Chillzone.price;
                        freeAreaInHA = newGame.sizeInHA - Chillzone.sizeInHa;
                        firstBuildingCounter = firstBuildingCounter - 1;
                        Building.userBuildings.add(Chillzone);
                        System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki i " + newGame.userWallet + " pieniędzy.");
                    case 5:
                        newGame.userWallet = newGame.userWallet - Chapel.price;
                        freeAreaInHA = newGame.sizeInHA - Chapel.sizeInHa;
                        firstBuildingCounter = firstBuildingCounter - 1;
                        Building.userBuildings.add(Chapel);
                        System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki i " + newGame.userWallet + " pieniędzy.");
                }

            } else System.out.println("Nie masz juz pieniedzy.");
        } else System.out.println("Wykorzystales juz wszystkie dostepne na poczatku gry budynki.");


        // w tym miejscu rozpoczyna się wlasciwa rozgrywka, uzytkownik wybral jedna z pieciu losowo wygenerowanych farm, ma
        // okreslona ilosc wolnej ziemii na dzialce, ma okreslona ilosc budynkow o okreslonym przeznaczeniu
        // jego stan finansowy przyjal jakas wartosc, wiec mamy poczatkowy stan rozgrywki
        // zaczynamy od tygodnia nr 1

        System.out.println("Zaczynamy!");

        while (newGame.shouldContinue) {
            System.out.println(":::::MENU GLOWNE::::");
            System.out.println("1. Wyswietl stan gry.");
            System.out.println("2. Kup lub sprzedaj ziemie uprawna.");
            System.out.println("3. Kup nowy budynek.");
            System.out.println("4. Kup zwierze lub roślinę.");
            System.out.println("5. Sprzedaj zwierze lub rosline.");
            System.out.println("6. Posadz rosliny.");
            System.out.println("7. Zbierz plony.");
            System.out.println("8. Wyswietl stan zapasow.");
            System.out.println("9. Wyswietl informacje o zwierzetach.");
            System.out.println("10. Wyswietl informacje o roslinach. ");
            System.out.println("11. Rozpocznij nowa runde. ");
            System.out.println("12. Zakoncz gre. ");

            int gameUserChoice = scanner.nextInt();
            switch(gameUserChoice){
                case 1:
                    // gameStatus.printGameStatus();
                    break;
                case 2:
                    //method
                    break;
                case 3:
                    //method
                    break;




            }
        }

    }
}

