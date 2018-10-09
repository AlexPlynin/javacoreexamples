package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите название планеты");
            String s = scanner.nextLine();
            if (s.equals(Planet.EARTH) || s.equals(Planet.MOON) || s.equals(Planet.SUN)) {
                if (s.equals(Planet.EARTH)) {
                    thePlanet = Earth.getInstance();
                    System.out.println(thePlanet.getClass().getSimpleName());
                }
                if (s.equals(Planet.MOON)) {
                    thePlanet = Moon.getInstance();
                    System.out.println(thePlanet.getClass().getSimpleName());
                }
                if (s.equals(Planet.SUN)) {
                    thePlanet = Sun.getInstance();
                    System.out.println(thePlanet.getClass().getSimpleName());
                }


            } else {
                System.out.println("Совпадений не найдено");
                thePlanet = null;
            }//хотя он и так нулл
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
