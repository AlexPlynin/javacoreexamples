package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);

        BufferedReader br = new BufferedReader(fileReader);
        String line;
        // HashMap<String,Double> map = new HashMap<>();
        TreeMap<String, Double> map = new TreeMap<>();
        while ((line = br.readLine()) != null) {

            String[] mass = line.split(" ");
            if (map.containsKey(mass[0])) {

                map.replace(mass[0], map.get(mass[0]) + Double.parseDouble(mass[1]));
                continue;
            }
            map.put(mass[0], Double.parseDouble(mass[1]));


        }


        for (Map.Entry<String,Double> pair:map.entrySet() ) {

            System.out.println(pair.getKey()+" "+pair.getValue());

        }
        fileReader.close();

        // System.out.println(map);


    }
}
