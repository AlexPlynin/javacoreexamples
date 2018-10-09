package com.javarush.task.task13.task1318;

import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/* 
?????? ?????
*/

public class Solution {
    static String fileName;
    static FileInputStream in;

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            //System.out.println("Введите имя файла");
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Введено неверное имя файла");
        }

        try (FileInputStream in = new FileInputStream(fileName); BufferedReader br2 = new BufferedReader(new InputStreamReader(in))) {
            String line;
            int x;
            while ((line = br2.readLine()) != null)
                System.out.println(line);
               /* for (int i = 0; i <line.length() ; i++) {
                    if (line.charAt(i)==10) System.out.println("\\\n найдено");
                }
                */
                //System.out.print(line);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //in.close();
    }
}