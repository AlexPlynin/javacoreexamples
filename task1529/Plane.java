package com.javarush.task.task15.task1529;

public class Plane implements Flyable {
    private int nubmerOfPersons;

    public Plane(int numbOfPersons) {
        this.nubmerOfPersons = numbOfPersons;
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " is flying");
    }
}
