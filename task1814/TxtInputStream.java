package com.javarush.task.task18.task1814;

import com.sun.prism.Texture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    static String fileName;
    //static String name="la";
    //static  FileInputStream component;


    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        //int a=4;
        super(fileName);
        if (fileName.contains(".txt")) {
            if (fileName.indexOf(".txt") < fileName.length() - 4) {
                super.close();
                throw new UnsupportedFileNameException();

            }
        } else {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        //
        // "C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1814\\loal.html","C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1814\\loal.html");
        TxtInputStream txtInputStream = new TxtInputStream("C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1814\\kjkjj.txt");
    }
}

