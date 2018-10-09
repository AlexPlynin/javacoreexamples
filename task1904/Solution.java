package com.javarush.task.task19.task1904;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



/* 
И еще один адаптер

*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        String filename = "C:\\Users\\hooty\\Desktop\\Jrush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\file1";
        PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(new FileInputStream(filename)));

        System.out.println(psa.read());
        psa.close();

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String info = fileScanner.nextLine();
            String[] infoMass = info.split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = simpleDateFormat.parse(infoMass[3]+" "+infoMass[4]+" "+infoMass[5]);
            //Date date = simpleDateFormat.parse(infoMass[3]+" "+infoMass[4]+" "+infoMass[5],new ParsePosition(0));




            return new Person(infoMass[1],infoMass[2],infoMass[0],date);
        }

        @Override
        public void close() throws IOException {
        fileScanner.close();
        }
    }
}
