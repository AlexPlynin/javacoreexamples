package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;



public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream fileOutputStream1 = new FileOutputStream(new BufferedReader((new InputStreamReader(System.in))).readLine());
             FileOutputStream fileOutputStream2 = new FileOutputStream(new BufferedReader((new InputStreamReader(System.in))).readLine())) {

            if (inputStream.available() > 0) {

                System.out.println(inputStream.available());
                byte[] buffer = new byte[inputStream.available()];
                int count =inputStream.read(buffer);
                // System.out.println(Arrays.toString(buffer));


                if (count % 2 == 0) {
                    System.out.println("if");
                    fileOutputStream1.write(buffer,0,count/2);
                    fileOutputStream2.write(buffer,count/2,count/2);
//                    fileOutputStream1.write(buffer,0,buffer.length/2);
//                    fileOutputStream2.write(buffer,(buffer.length/2)+1,buffer.length);//не понимаю почему не робит
                } else {

                    int count2 = count/2+1;

                    fileOutputStream1.write(buffer,0,count2);
                    fileOutputStream2.write(buffer,count-count2+1,count-count2);

                   // fileOutputStream1.write(buffer1.toArray(new Byte[0]));


//                    fileOutputStream1.write(Arrays.copyOfRange(buffer,0,buffer.length/2));
//                    fileOutputStream2.write(Arrays.copyOfRange(buffer,buffer.length/2-1,buffer.length));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
