package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* 
Serializable Solution
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.


Требования:
1. Поле pattern должно быть отмечено модификатором transient.
2. Поле currentDate должно быть отмечено модификатором transient.
3. Поле temperature должно быть отмечено модификатором transient.
4. Поле string НЕ должно быть отмечено модификатором transient.
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        // FileInputStream fis = new FileInputStream("file1");
        try (FileOutputStream fout = new FileOutputStream("file1");
             FileInputStream fis = new FileInputStream("file1")
        ) {

            // ObjectInputStream ois = new ObjectInputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            Solution savedObject = new Solution(5);

            oos.writeObject(savedObject);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(fis);

            Solution loadedObject = (Solution) ois.readObject();
//
            System.out.println(loadedObject);
            // System.out.println(loadedObject.string);
            // System.out.println(savedObject);

            System.out.println(savedObject.equals(loadedObject) && savedObject.hashCode() == loadedObject.hashCode());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(new Solution(4));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return temperature == solution.temperature &&
                Objects.equals(pattern, solution.pattern) &&
                Objects.equals(currentDate, solution.currentDate) &&
                Objects.equals(string, solution.string);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pattern, currentDate, temperature, string);
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);// по факту информационным носителем объекста остается данная строка
    }

    @Override
    public String toString() {
        return this.string;
    }
}
