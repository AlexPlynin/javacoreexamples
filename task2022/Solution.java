package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;//поток не сериализуется
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();



        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);

        //this()
        //stream = new FileOutputStream()
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\file2");
        Solution solution = new Solution("file1");

        solution.writeObject("SomeString");
        ObjectOutputStream oos = new ObjectOutputStream(solution.stream);
        //solution.writeObject(oos);
        oos.writeObject(solution);

        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution restoreO = (Solution) ois.readObject();
        restoreO.writeObject("SomeString");


    }
}
