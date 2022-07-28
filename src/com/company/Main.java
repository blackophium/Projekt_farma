package com.company;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

// ******************************************************************** KONFIGURACJA PODSTAWOWA ***********************************************************************************

        Scanner scanner = new Scanner(System.in);

        gameStatus newGame = new gameStatus();
        // data i pieniazki
        newGame.weekCounter = 0;
        newGame.userWallet = 10000.0;
        // budynki i teren
        newGame.buildingCount = 0;
        newGame.freeAreaInHA = 0;
        // ziarno
        newGame.seedPszenicaCounter = 0;
        newGame.seedOwiesCounter = 0;
        newGame.seedSlonecznikCounter = 0;
        newGame.seedMarchewCounter = 0;
        newGame.seedZiemniakCounter = 0;

        // rosliny

        // zwierzeta
        newGame.animalSpeciesCount = 0;

        // stan gry
        newGame.shouldContinue = true;

        // podstawowe budynki
        Building House = new Building("Dom", 4000.0, 0.01);
        Building Barn = new Building("Stodola", 2000.0, 0.5);
        Building Enclosure = new Building("Wybieg", 5000.0, 2);
        Building Chillzone = new Building("Strefa chillu", 900.0, 0.5);
        Building Chapel = new Building("Kapliczka", 300.0, 0.01);

        // robocze kontrolery stanu przypisania rozmiaru ziemii do budynkow i rozdysponowania budynkow z generatora
        int firstBuildingCounter = newGame.buildingCount;
        newGame.freeAreaInHA = newGame.sizeInHA;

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
                System.out.println(FarmGenerator.farms.get(0));
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
        System.out.println(" ");
        System.out.println("Wstepna konfiguracja jest juz prawie gotowa!");
        System.out.println(" ");

//        //test zapisu stanu początkowego
//        System.out.println("Test zapisu:");
//        System.out.println(newGame.sizeInHA);
//        System.out.println(newGame.buildingCount);
//        System.out.println(newGame.userWallet);


        // wybieramy przeznaczenie podstawowych wygenerowanych budynkow - pozniej bedzie mozna dokupic
        System.out.println("Masz do dyspozycji: " + newGame.buildingCount + " budynki i " + newGame.userWallet + " monet.");
        System.out.println("Najwyzszy czas okreslic ich przeznaczenie i kupic wyposazenie.");
        System.out.println("W sklepie dostepne jest kilka wariantow wyposazenia. Dokonaj wyboru!");

        while (firstBuildingCounter > 0) {
            if (newGame.userWallet != 0 && newGame.sizeInHA != 0) {
                System.out.println("Dostepne budynki:");
                System.out.println("1. " + House.name + ", cena: " + House.price + ", powierzchnia: " + House.sizeInHa + " HA");
                System.out.println("2. " + Barn.name + ", cena: " + Barn.price + ", powierzchnia: " + Barn.sizeInHa + " HA");
                System.out.println("3. " + Enclosure.name + ", cena: " + Enclosure.price + ", powierzchnia: " + Enclosure.sizeInHa + " HA");
                System.out.println("4. " + Chillzone.name + ", cena: " + Chillzone.price + ", powierzchnia: " + Chillzone.sizeInHa + " HA");
                System.out.println("5. " + Chapel.name + ", cena: " + Chapel.price + ", powierzchnia: " + Chapel.sizeInHa + " HA");

                // mechanizm wyboru przeznaczenia podstawowych budynków z generatora - aktualizuje "wielkość" dostępnej wolnej ziemii
                // oraz dodaje wybrane budynki do listy budynków uzytkownika
                // na koniec pętli userowi zostaje 0 budynkow do rozdysponowania i dzieki temu mozemy rozpoczac wlasciwa rozgrywke

                // **** KUPOWANIE PIERWSZYCH BUDYNKOW **** //
                System.out.println("Podaj numer budynku ktory wybierasz do zakupu:");
                int buildingUserChoice = scanner.nextInt();
                switch (buildingUserChoice) {
                    case 1:
                        if(newGame.userWallet >= House.price && newGame.freeAreaInHA >= House.sizeInHa) {
                            newGame.userWallet = newGame.userWallet - House.price;
                            newGame.freeAreaInHA = newGame.freeAreaInHA - House.sizeInHa;
                            firstBuildingCounter = firstBuildingCounter - 1;
                            Building.userBuildings.add(House);
                        } else System.out.println("Niestety nie stac Cie na ten budynek. Wybierz inny!");
                        if(firstBuildingCounter != 0) {
                            System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki, " + newGame.freeAreaInHA + " HA przestrzeni i " + newGame.userWallet + " monet.");
                        }
                        break;
                    case 2:
                        if(newGame.userWallet >= Barn.price && newGame.freeAreaInHA >= Barn.sizeInHa) {
                            newGame.userWallet = newGame.userWallet - Barn.price;
                            newGame.freeAreaInHA = newGame.freeAreaInHA - Barn.sizeInHa;
                            firstBuildingCounter = firstBuildingCounter - 1;
                            Building.userBuildings.add(Barn);
                        } else System.out.println("Niestety nie stac Cie na ten budynek lub brakuje Ci miejsca. Wybierz inny!");
                        if(firstBuildingCounter != 0) {
                            System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki, " + newGame.freeAreaInHA + " HA przestrzeni i " + newGame.userWallet + " monet.");
                        }
                        break;
                    case 3:
                        if(newGame.userWallet >= Enclosure.price && newGame.freeAreaInHA >= Enclosure.sizeInHa) {
                            newGame.userWallet = newGame.userWallet - Enclosure.price;
                            newGame.freeAreaInHA = newGame.freeAreaInHA - Enclosure.sizeInHa;
                            firstBuildingCounter = firstBuildingCounter - 1;
                            Building.userBuildings.add(Enclosure);
                        } else System.out.println("Niestety nie stac Cie na ten budynek lub brakuje Ci miejsca. Wybierz inny!");
                        if(firstBuildingCounter != 0) {
                            System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki, " + newGame.freeAreaInHA + " HA przestrzeni i " + newGame.userWallet + " monet.");
                        }
                        break;
                    case 4:
                        if(newGame.userWallet >= Chillzone.price && newGame.freeAreaInHA >= Chillzone.sizeInHa) {
                            newGame.userWallet = newGame.userWallet - Chillzone.price;
                            newGame.freeAreaInHA = newGame.freeAreaInHA - Chillzone.sizeInHa;
                            firstBuildingCounter = firstBuildingCounter - 1;
                            Building.userBuildings.add(Chillzone);
                        } else System.out.println("Niestety nie stac Cie na ten budynek lub brakuje Ci miejsca. Wybierz inny!");
                        if(firstBuildingCounter != 0) {
                            System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki, " + newGame.freeAreaInHA + " HA przestrzeni i " + newGame.userWallet + " monet.");
                        }
                    case 5:
                        if(newGame.userWallet >= Chapel.price && newGame.freeAreaInHA >= Chapel.sizeInHa) {
                            newGame.userWallet = newGame.userWallet - Chapel.price;
                            newGame.freeAreaInHA = newGame.freeAreaInHA - Chapel.sizeInHa;
                            firstBuildingCounter = firstBuildingCounter - 1;
                            Building.userBuildings.add(Chapel);
                        } else System.out.println("Niestety nie stac Cie na ten budynek lub brakuje Ci miejsca. Wybierz inny!");
                        if(firstBuildingCounter !=0) {
                            System.out.println("Masz do dyspozycji jeszcze: " + firstBuildingCounter + " budynki i " + newGame.userWallet + " monet.");
                        }
                }

            }
        }

        // w tym miejscu rozpoczyna się wlasciwa rozgrywka, uzytkownik wybral jedna z pieciu losowo wygenerowanych farm, ma
        // okreslona ilosc wolnej ziemii na dzialce, ma okreslona ilosc budynkow o okreslonym przeznaczeniu
        // jego stan finansowy przyjal jakas wartosc, wiec mamy poczatkowy stan rozgrywki
        // zaczynamy od tygodnia nr 1

        System.out.println("Wykorzystales juz wszystkie dostepne na poczatku gry budynki.");
        System.out.println("Zaczynamy rozgrywke!!!");

// ******************************************************************** LET THE GAME BEGIN! *************************************************************************************

        // *** MENU GLOWNE *** //
        while (newGame.shouldContinue) {
            System.out.println(":::::MENU GLOWNE::::");
            System.out.println("1. Wyswietl stan gry.");                    // done
            System.out.println("2. Kup lub sprzedaj ziemie uprawna.");      // done
            System.out.println("3. Kup lub sprzedaj budynek.");             // done
            System.out.println("4. Kup lub sprzedaj nasiona.");             // done
            System.out.println("5. Kup lub sprzedaj zwierze.");             //
            System.out.println("6. Posadz rosliny.");                       //
            System.out.println("7. Zbierz plony.");                         //
            System.out.println("8. Wyswietl stan zapasow.");                //
            System.out.println("9. Wyswietl informacje o zwierzetach.");    //
            System.out.println("10. Wyswietl informacje o roslinach. ");    //
            System.out.println("11. Rozpocznij nowa runde. ");              //
            System.out.println("12. Zakoncz gre. ");                        //

            int gameUserChoice = scanner.nextInt();

            switch(gameUserChoice){
                case 1:
                     newGame.displayGameStatus();
                    break;
                // *** KUPNO/SPRZEDAZ ZIEMII UPRAWNEJ *** //
                case 2:
                    System.out.println("Aby kupic ziemie wpisz: 1, aby sprzedac wpisz: 2.");
                    int buyOrSellArea = scanner.nextInt();
                            if(buyOrSellArea == 1) {
                                teritory.buy(newGame);
                            } else if(buyOrSellArea == 2) {
                                teritory.sell(newGame);
                            } else {
                                System.out.println("Wybrano bledne polecenie. Nastapi powrot do menu glownego.");
                            }
                // *** KUPNO/SPRZEDAZ BUDYNKOW *** //
                case 3:
                    System.out.println("Aby kupic budynek wpisz: 1, aby sprzedac wpisz: 2.");
                    int buyOrSellBuilding = scanner.nextInt();
                        if(buyOrSellBuilding == 1) {
                            Building.buy(newGame);
                        } else if(buyOrSellBuilding == 2) {
                            Building.sell(newGame);
                        } else {
                            System.out.println("Wybrano bledne polecenie. Nastapi powrot do menu glownego.");
                        }
                    break;
                // *** KUPNO/SPRZEDAZ NASION *** //
                case 4:
                    // method
                    break;
//                case 5:
//                    // method
//                    break;
//                case 6:
//                    // method
//                    break;
//                case 7:
//                    // method
//                    break;
//                case 8:
//                    // method
//                    break;
//                case 9:
//                    // method
//                    break;
//                case 10:
//                    // method
//                    break;
//                case 11:
//                    newGame.startNewRound();
//                    break;
//                case 12:
//                    newGame.finishTheGame();
//                    break;


            }
        }

    }
}

