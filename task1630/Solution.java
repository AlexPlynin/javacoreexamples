package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //add your code here - добавьте код тут
    static {
        try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader2.readLine();
            secondFileName = reader2.readLine();
        } catch (IOException e) {

        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();//
        //f.join();//ждем без join метод ран не успеет отработать и главный поток уже вызовет f.getFileContent
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String fileName;
        private String fileContent="";

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public void run() {
            try (FileInputStream in = new FileInputStream(fileName); BufferedReader br2 = new BufferedReader(new InputStreamReader(in))) {
                String line;
                //int x;
                while ((line = br2.readLine()) != null)
                    fileContent=fileContent+line+" ";

            }
            catch (Exception e){
                e.printStackTrace();
            }


        }

        @Override
        public String getFileContent() {
            return fileContent;
        }
    }

    //add your code here - добавьте код тут
}
