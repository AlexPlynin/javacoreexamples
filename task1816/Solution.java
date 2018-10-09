package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String line;
        char c;
        Pattern p = Pattern.compile("[a-z|A-Z]");//ищем все буквы Англ алфавита
        Matcher m;
        try {
           //  ;
            int sum=0;
            //char[] buffer = new char

            while ((line = bufferedReader.readLine()) != null) {

                for (int i = 0; i <line.length() ; i++) {
                    m=p.matcher(Character.toString(line.charAt(i)));
                    if (m.matches()){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.err.println("Bad");
        }
        bufferedReader.close();
    }
}
