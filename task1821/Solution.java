package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[256];
        char c = 't';
        // System.out.println( c);
        //int c = fis.read();
        System.out.println((char) -127);
        while (fis.available() > 0) {

            int readByte = fis.read();
            System.out.println(readByte);
            buffer[readByte & 0b11111111]++;


        }


         System.out.println(Arrays.toString(buffer));
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] > 0) System.out.println((char) i + " " + buffer[i]);
        }
        fis.close();

    }
}
