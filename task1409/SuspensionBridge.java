package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    private static int CARSCOUNT = 780;

//    public SuspensionBridge(int carsCount) {
//        this.carsCount = carsCount;
//
//    }

    @Override
    public int getCarsCount() {
        return CARSCOUNT;
    }
}
