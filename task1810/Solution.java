package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        while (true){
            FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            //System.out.println(fis.available());
            if (fis.available()<1000){
                fis.close();
                throw new DownloadException();
                //break;
            }

        }
    }

    public static class DownloadException extends Exception {

    }
}
