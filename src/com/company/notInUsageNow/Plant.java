package com.company.notInUsageNow;

public class Plant {
    private String name;
    private double costOfGrowHA;
    private double costOfProtectionHA;
    private double costOfCollect;
    private double efficiencyTonesHA;
    private int timeToCollectInWeeks;
    private boolean abilityToSeed;
    private int plantAge;
    public boolean ableToCollect;
    public boolean ableToSell;

    public Plant(String name, double costOfGrowHA, double costOfProtectionHA, double costOfCollect, double efficiencyTonesHA, int timeToCollectInWeeks, boolean abilityToSeed, int plantAge, boolean ableToCollect, boolean ableToSell) {
        this.name = name;
        this.costOfGrowHA = costOfGrowHA;
        this.costOfProtectionHA = costOfProtectionHA;
        this.costOfCollect = costOfCollect;
        this.efficiencyTonesHA = efficiencyTonesHA;
        this.timeToCollectInWeeks = timeToCollectInWeeks;
        this.abilityToSeed = abilityToSeed;
        this.plantAge = plantAge;
        this.ableToCollect = ableToCollect;
        this.ableToSell = ableToSell;
    }
}
