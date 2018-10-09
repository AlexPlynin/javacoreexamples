package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader((new InputStreamReader(System.in))).readLine())) {

            if (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                for (int i = buffer.length-1; i >= 0; i--) {
                    fileOutputStream.write(buffer[i]);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
