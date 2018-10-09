package com.javarush.task.task15.task1522;

//Lazy initialization
public final class Sun implements Planet {
    private static Sun instance;

    private Sun() {
    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();//к конструктору имеют доступ только внутренние член класса
        }

        return instance;
    }
}
