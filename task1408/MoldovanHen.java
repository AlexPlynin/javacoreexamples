package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country {
    String countryName = Country.MOLDOVA;

    @Override
    public int getCountOfEggsPerMonth() {
        return 340;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ " Моя страна - "+Country.MOLDOVA+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
