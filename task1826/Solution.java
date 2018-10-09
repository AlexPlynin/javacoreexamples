package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

public class Solution {





    public static void main(String[] args) throws UnsupportedEncodingException {






       String keys="Lalalalalala3451$$$";
//       String slovo = "PEePEPEEP";
//        byte[] res = encode(slovo,keys);
//        String resu = new String(res,"UTF-8");
//
//        System.out.println(resu);
//        System.out.println(decode(resu.getBytes(),keys));



        if (args[0].equals("-e")){
            encriptFile(args[1],args[2],keys);
        }
        else if (args[0].equals("-d")){
            decriptFile(args[1],args[2],keys);
        }

    }

    public static void encriptFile(String fileIn, String fileOut, String key) {
        try (FileInputStream fis = new FileInputStream(fileIn);
             FileOutputStream fout = new FileOutputStream(fileOut)) {

           byte[] buffer = new byte[fis.available()];
           fis.read(buffer);
            byte[] keyB = key.getBytes();
            byte[] result = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                result[i] = (byte) (buffer[i] ^ keyB[i % keyB.length]);
          }
            //byte[] res = encode(slovo,keys);
            fout.write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void decriptFile(String fileIn, String fileOut, String key) {
        //encriptFile(fileIn, fileOut, key);
        try (FileInputStream fis = new FileInputStream(fileIn);
             FileOutputStream fout = new FileOutputStream(fileOut)) {

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            byte[] keyB = key.getBytes();
            byte[] result = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                result[i] = (byte) (buffer[i] ^ keyB[i % keyB.length]);
            }
            fout.write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    public static byte[] encode(String pText, String pKey) {
//        byte[] txt = pText.getBytes();
//        byte[] key = pKey.getBytes();
//        byte[] res = new byte[pText.length()];
//
//        for (int i = 0; i < txt.length; i++) {
//            res[i] = (byte) (txt[i] ^ key[i % key.length]);
//        }
//
//        return res;
//    }
//
//    public static String decode(byte[] pText, String pKey) {
//        byte[] res = new byte[pText.length];
//        byte[] key = pKey.getBytes();
//
//        for (int i = 0; i < pText.length; i++) {
//            res[i] = (byte) (pText[i] ^ key[i % key.length]);
//        }
//
//        return new String(res);
//    }

}
