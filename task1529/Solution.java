package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String s;
            if ((s=bufferedReader.readLine()).equals("helicopter")){
                result = new Helicopter();
                result.fly();

            }
            else if (s.equals("plane")){
                System.out.println("Введите колличество пасажиров");

                result = new Plane(Integer.parseInt(bufferedReader.readLine()));
                result.fly();
            }




        }
        catch(Exception e){

        }

        //add your code here - добавьте код тут
    }
}
