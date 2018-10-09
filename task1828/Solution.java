package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите имя файла");
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String subString;
        while ((line = br.readLine()) != null) {

            System.out.println(line);
            if ((subString = line.substring(0, 8)).contains(" ")) {
                subString = subString.substring(0, subString.indexOf(" "));
            }
            //else subString = line.substring(0, 7);
            //System.out.println(subString);
            list.add(line);


        }



    }
}
