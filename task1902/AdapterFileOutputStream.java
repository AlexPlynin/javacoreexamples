package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
    fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
    AmigoStringWriter amigoStringWriter = new AdapterFileOutputStream(new FileOutputStream("C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1902\\file1"));
    amigoStringWriter.writeString("Adapter Example");
    amigoStringWriter.flush();
    amigoStringWriter.close();
    }


}

