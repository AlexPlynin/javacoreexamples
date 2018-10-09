package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len)
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.


Требования:
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter.
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    private FileWriter fileWriter;

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

        fileWriter.write(cbuf, off, len);


    }

    public FileConsoleWriter(String fileName, FileWriter fileWriter) throws IOException {
        super(fileName);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(String fileName, boolean append, FileWriter fileWriter) throws IOException {
        super(fileName, append);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, FileWriter fileWriter) throws IOException {
        super(file);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, boolean append, FileWriter fileWriter) throws IOException {
        super(file, append);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(FileDescriptor fd, FileWriter fileWriter) {
        super(fd);
        this.fileWriter = fileWriter;
    }

    public static void main(String[] args) {

    }

}
