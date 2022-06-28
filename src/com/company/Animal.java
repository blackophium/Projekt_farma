package com.company;

public class Animal {
    private String name;
    private double buyPrice;
    private double growInAWeek;
    private int weeksUntilAdult;
    private String acceptableFood;
    private int weight;
    private int ageInWeeks;
    public boolean flagIsYoung;
    public boolean flagAbleToSell;
    public double chanceToReproduce;

    public Animal(String name, double buyPrice, double growInAWeek, int weeksUntilAdult, String acceptableFood, int weight, int ageInWeeks, boolean flagIsYoung, boolean flagAbleToSell, double chanceToReproduce) {

        this.name = name;
        this.buyPrice = buyPrice;
        this.growInAWeek = growInAWeek;
        this.weeksUntilAdult = weeksUntilAdult;
        this.acceptableFood = acceptableFood;
        this.weight = weight;
        this.ageInWeeks = ageInWeeks;
        this.flagIsYoung = flagIsYoung;
        this.flagAbleToSell = flagAbleToSell;
        this.chanceToReproduce = chanceToReproduce;
    }
}

