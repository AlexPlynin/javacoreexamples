package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country {
    String countryName = Country.BELARUS;

    @Override
    public int getCountOfEggsPerMonth() {
        return 450;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
