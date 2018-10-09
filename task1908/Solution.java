package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bf.readLine();
        String fileName2 = bf.readLine();
        bf.close();
        bf = new BufferedReader(new FileReader(fileName1));

        BufferedWriter bout = new BufferedWriter(new FileWriter(fileName2));
        Pattern pattern = Pattern.compile("\\b\\d+\\b");//граница слова
        //
        ///
        Matcher matcher;
        String line;
        while ((line=bf.readLine())!=null) {
            //System.out.println(line);
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                //System.out.println(line.substring(matcher.start(), matcher.end()));
                //bout.write(line.substring(matcher.start(), matcher.end())+" ");
                bout.write(line.substring(matcher.start(), matcher.end())+" ");
                bout.flush();
            }

        }
        bf.close();
        bout.close();
//        while ((line=bf.readLine())!=null){
//
//
//
//        }
    }
}
