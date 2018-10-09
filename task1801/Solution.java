package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Максимальный байт
*/

public class Solution {
    static String fileName;

    public static void main(String[] args) throws Exception {

        //String filename;
        //System.out.println("Введите имя файоа");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            fileName = bufferedReader.readLine();
        }
        catch (IOException e) {
        e.printStackTrace();

        }
        try (FileInputStream fis = new FileInputStream(fileName)) {
            ArrayList<Integer> listOfByte = new ArrayList<>();
            while (fis.available() > 0) {
                listOfByte.add(fis.read());


            }
            //System.out.println(listOfByte);
             Integer[] massOfBytes=  listOfByte.toArray(new Integer[0]);
            int max = massOfBytes[0];
            for (int i = 0; i <massOfBytes.length ; i++) {
                if (massOfBytes[i]>max){
                    max=massOfBytes[i];
                }

            }
            System.out.println(max);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
