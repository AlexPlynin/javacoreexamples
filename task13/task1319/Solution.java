package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static String fileName;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя файла для записи");
        //String fileName;
        try {
            fileName = bufferedReader.readLine();// напишите тут ваш код
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //FileWriter fileWriter = new FileWriter(fileName);
       // BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {


            while (true){

                System.out.println("Введите строку для записи в файл ");
                String s = bufferedReader.readLine();
                //if (s.equals("exit")) break;
                bufferedWriter.write(s+"\n");
                if (s.equals("exit")) break;
            }


        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("LOl");
        }
//        finally {
//            try {
//
//                if(fileWriter!=null)fileWriter.close();
//                if(bufferedWriter!=null) bufferedWriter.close();
//            }
//            catch (IOException ex){
//                ex.printStackTrace();
//            }
//        }


    }
}
