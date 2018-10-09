package com.javarush.task.task15.task1529;

public class Helicopter implements Flyable {
    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " is flying");
    }
}
