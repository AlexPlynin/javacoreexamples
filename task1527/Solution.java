package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Программа должна выводить данные на экран в соответствии с условием.
3. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
4. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/


public class Solution {
    //new Solution().isNumber();
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = bufferedReader.readLine().toString();
            String k = s.substring(s.indexOf('?'), s.length());//add your code here
            char[] kOfChars = k.toCharArray();
            ArrayList<String> list = new ArrayList<>();
           // ArrayList<Character> list12 = new ArrayList<>();
            String f="";
            for (int i = 1; i <kOfChars.length ; i++) {
                //System.out.print(kOfChars[i]);
//                while (kOfChars[i]!='&'){
//
//                    f=f+Character.toString(kOfChars[i]);
//                }
                if (kOfChars[i]!='&') {
                    f=f+Character.toString(kOfChars[i]);
                    if (i==kOfChars.length-1){
                        if (f.contains("=")){
                            list.add(f);
                            f=f.substring(0,f.indexOf("="));
                            System.out.print(f+" \n");
                            // f="";
                        }
                        else {
                        System.out.print(f+" ");

                        }
                        break;
                    }

                }
                else {
                    //for (int j = 0; j <f.length() ; j++) {
//tp://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo&pes124565&shakal=345657&psina
                   // }
                    if (f.contains("=")){
                        list.add(f);
                        f=f.substring(0,f.indexOf("="));
                        System.out.print(f+" ");
                       // f="";
                    } else {
                        list.add(f);
                        System.out.print(f+" ");
                        //f = "";
                    }
                    f="";
                    //continue;
                }
                //f="";
                //System.out.println(list);
            }
            //System.out.println(list);
            for (String s2:list) {
               if (s2.contains("obj")){
                  s2=s2.substring(s2.indexOf("=")+1,s2.length());
                  try {
                      alert(Double.valueOf(s2));
                  }
                  catch (Exception e){
                      alert(s2);
                  }
               }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
