package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static String fileName;
//    static String line;

    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Введите имя файла");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();// напишите тут ваш код
        }
        ArrayList<Integer> list = new ArrayList<>();
        try (FileInputStream fI = new FileInputStream(fileName); BufferedReader br2 = new BufferedReader(new InputStreamReader(fI))) {
            String line;
            while ((line = br2.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        //System.out.println(list);
        oddSortNPrint(list);
    }

    public static void oddSortNPrint(ArrayList<Integer> list) {
        Integer[] arrList = new Integer[list.size() - 1];// Cast List to Integer[]
        arrList = list.toArray(arrList);
        //System.out.println(arrList);
//        for (Integer i : arrList) {
//            System.out.println(i);
//        }


        Arrays.sort(arrList);
        for (Integer i : arrList) {
            if (i % 2 == 0)
                System.out.println(i);

        }


    }
}
