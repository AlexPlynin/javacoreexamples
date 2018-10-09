package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fis1 = new FileInputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);

        byte[] buffer = new byte[fis1.available()];
        byte[] buffer2 = new byte[fis2.available()];


        fis1.read(buffer);
        fis2.read(buffer2);
        fis1.close();

        FileOutputStream fout1 = new FileOutputStream(fileName1);

        fout1.write(buffer2);
        fout1.write(buffer);


        fis2.close();
        fout1.close();


        //FileOutputStream fout1 = new FileOutputStream(fileName1);

    }
}
