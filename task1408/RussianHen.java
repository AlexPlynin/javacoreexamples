package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country {
    String countryName = Country.RUSSIA;
    @Override
    public int getCountOfEggsPerMonth() {
        return 140;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ " Моя страна - "+Country.RUSSIA+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
