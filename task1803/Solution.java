package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    static String fileName;

    public static void main(String[] args) throws Exception {


        //String filename;
        //System.out.println("Введите имя файоа");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();

        }
        try (FileInputStream fis = new FileInputStream(fileName)) {
            ArrayList<Integer> listOfByte = new ArrayList<>();
            while (fis.available() > 0) {
                listOfByte.add(fis.read());


            }
            //System.out.println(listOfByte);
            Integer[] massOfBytes = listOfByte.toArray(new Integer[0]);
            Map<Integer, Integer> mapOfBytes = new HashMap<>();
            int count = 0;
            for (int i = 0; i < massOfBytes.length; i++) {
                for (int j = 0; j < massOfBytes.length; j++) {
                    if (massOfBytes[i] == massOfBytes[j]) {
                        count++;
                    }
                }
                mapOfBytes.put(massOfBytes[i], count);
                count = 0;
            }
            massOfBytes = mapOfBytes.keySet().toArray(new Integer[0]);


            //System.out.println(massOfBytes);
           // System.out.println(mapOfBytes);
            int max = mapOfBytes.get(massOfBytes[0]);
            for (int i = 0; i < massOfBytes.length; i++) {
                if (mapOfBytes.get(massOfBytes[i]) > max) {
                        max=mapOfBytes.get(massOfBytes[i]);
                }
            }
            for (int i = 0; i <massOfBytes.length ; i++) {
                if (mapOfBytes.get(massOfBytes[i])==max)
                    System.out.print(massOfBytes[i]+" ");
            }
           // System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
