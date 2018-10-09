package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fout = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileInputStream fis2 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileInputStream fis3 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ) {
            byte[] buffer = new byte[fis2.available()];
            byte[] buffer2 = new byte[fis3.available()];
            fis2.read(buffer);
            fis3.read(buffer2);
            fout.write(buffer);
            fout.write(buffer2);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
