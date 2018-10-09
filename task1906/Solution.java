package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        String file2 = bf.readLine();
        bf.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int count = 1;
        while (fileReader.ready()) {

            int i = fileReader.read();
            if (count%2==0) {
                fileWriter.write(i);

            }

            count++;

        }

        fileReader.close();
        fileWriter.close();
       // bf.close();

    }
}
