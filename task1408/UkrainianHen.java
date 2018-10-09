package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country {

    String countryName = Country.UKRAINE;
    @Override
    public int getCountOfEggsPerMonth() {
        return 120;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ " Моя страна - "+Country.UKRAINE+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
