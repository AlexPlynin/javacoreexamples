package com.javarush.task.task14.task1419;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
            throw new ExceptionInInitializerError();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayStoreException();
        }
        catch (ArrayStoreException e){
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        }
        catch (ClassCastException e){
            exceptions.add(e);
        }
        try{
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){
            exceptions.add(e);
        }
        try{
            throw new IllegalMonitorStateException();
        }
        catch (IllegalMonitorStateException e){
            exceptions.add(e);
        }
        try{
            throw new NegativeArraySizeException();

        }
        catch (NegativeArraySizeException e){
            exceptions.add(e);
        }
        try {
            throw new NumberFormatException();
        }
        catch (NumberFormatException e){
            exceptions.add(e);
        }
        try{
            throw new SecurityException();
        }
        catch (SecurityException e){
            exceptions.add(e);
        }
        try {
            throw new UnsupportedOperationException();
        }
        catch (UnsupportedOperationException e){
            exceptions.add(e);
        }
        //напишите тут ваш код

    }
}
