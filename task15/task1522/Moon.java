package com.javarush.task.task15.task1522;

public final class Moon implements Planet {
    private static Moon instance;


    private Moon() {
    }

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();//к конструктору имеют доступ только внутренние член класса
        }

        return instance;
    }
}

