package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.out.println((int)3.51);

        //System.out.println((int) (3.7814 % 3 * 100));
        //System.out.println((int)-1245.356);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        BufferedReader brIn = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        //FileOutputStream fout = new FileOutputStream(fileNmae2);
        BufferedWriter brOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));
        String line;
        double number;

        while ((line = brIn.readLine()) != null) {
            // System.out.println(line);
            String[] parseLines = line.split(" ");
            for (int i = 0; i < parseLines.length; i++) {
                number = Double.parseDouble(parseLines[i]);
                //System.out.println(number);
                int resNumber;
                int res;
                if (number > 0) {
                    res = (int) ((number - (int) number) * 100);
                    //int resNumber;
                    if (res <= 49) {
                        resNumber = (int) number;
                    } else {
                        resNumber = (int) number + 1;

                    }


                } else {
                    //res=Math.abs(res);
                    res = (int) ((Math.abs(number)-  (int) Math.abs(number)) * 100);
                    if (Math.abs(res) <= 50) {
                        resNumber = (int) number;

                    } else {
                        resNumber = (int) number - 1;
                    }

                }


            brOut.write(Integer.toString(resNumber)+" ");


            }

        }

        brOut.close();
        brIn.close();
       // System.out.println(line);


//            String s = "fhfhhf fhhfhfhf hfhfhf";
//            String[] parseLine = s.split(" ");
//            System.out.println(parseLine);
//            for (String s1 : parseLine
//                    ) {
//                System.out.println(s1);
//
//            }
        // String line;


//            byte[] buffer = new byte[fis1.available()];
//            fis1.read(buffer);
//            for (byte x:buffer
//                 ) {
//                System.out.print((char)x);
//
//            }
//            char[] buffer1 = (char) buffer;

        //Character.toC
//          Str=
//            String line = new String(buffer, "UTF-8");
//            char[] buffer1 = line.toCharArray();
//            //System.out.println(buffer1[2]);
//            StringBuffer sb = new StringBuffer();
//
//            for (int i = 0; i < buffer1.length; ) {
//                while (buffer1[i] != ' ') {
//                    sb.append(buffer1[i]);
//                    i++;
//
//                }
//                System.out.println(sb);
//                sb.delete(0,sb.length());
//                i++;
//
//

    }
}
