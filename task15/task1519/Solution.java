package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            while (!(s = bufferedReader.readLine()).equals("exit")) {
                
               // if (s
                try {
                    if (s.contains(".")) {
                        print(Double.valueOf(s));
                    } else {
                        if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) {
                            print((short) Integer.parseInt(s));
                        } else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) {
                            print(Integer.valueOf(s));
                        } else print(s);
                    }
                }
                catch (Exception e){
                    //print(s); печатаю строку по ошибке поскольку буфер ридером изначально читаем именно тип Стринг и по ошибке преобразования переходим сюда
                    print(s);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
