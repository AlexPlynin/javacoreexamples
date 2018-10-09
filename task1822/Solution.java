package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName  = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BufferedReader brIn = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

           String line;
            while ((line=brIn.readLine())!=null){
                if (Integer.parseInt(line.split(" ")[0])==Integer.parseInt(args[0])){
                    System.out.println(line);
                }
            }
            brIn.close();

    }
}
