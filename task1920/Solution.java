package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);

        BufferedReader br = new BufferedReader(fileReader);
        String line;
        // HashMap<String,Double> map = new HashMap<>();
        TreeMap<String, Double> map = new TreeMap<>();
        while ((line = br.readLine()) != null) {

            String[] mass = line.split(" ");
            if (map.containsKey(mass[0])) {

                map.replace(mass[0], map.get(mass[0]) + Double.parseDouble(mass[1]));
                continue;
            }
            map.put(mass[0], Double.parseDouble(mass[1]));


        }


        double max = 0;
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (max < pair.getValue()) {
                max = pair.getValue();
            }
            //System.out.println(pair.getKey() + " " + pair.getValue());

        }
        // System.out.println(max);
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
            //System.out.println(pair.getKey() + " " + pair.getValue());

        }
        fileReader.close();

        // System.out.println(map);

    }
}
