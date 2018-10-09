package com.javarush.task.task14.task1409;

public class WaterBridge implements Bridge {

    private static int CARSCOUNT = 45;

//    public WaterBridge(int carsCount) {
//        this.carsCount = carsCount;
//
//    }

    @Override
    public int getCarsCount() {
        return CARSCOUNT;
    }
}
