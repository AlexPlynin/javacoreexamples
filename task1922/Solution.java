package com.javarush.task.task19.task1922;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        //contains
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader br2 = new BufferedReader(fileReader);
        String line;
        while ((line = br2.readLine()) != null) {
            String[] mass = line.split(" ");
            int index = 0;
            for (int i = 0; i < mass.length; i++) {
                if (words.contains(mass[i])) {
                    index++;
                }

            }
            if (index == 2) {
                System.out.println(line);

            }


        }
        br.close();
        br2.close();
        fileReader.close();

    }
}
