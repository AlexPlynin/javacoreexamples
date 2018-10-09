package com.javarush.task.task18.task1827;

/* 
Прайсы
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            if (args[0].equals("-c")) {

//            String s = "19847983";
//            System.out.println(s.substring(0,8));

                System.out.println("Введите имя файла");
                String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
                FileInputStream fis = new FileInputStream(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                String line;
                ArrayList<Integer> list = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                String subString;
                while ((line = br.readLine()) != null) {

                    System.out.println(line);
                    if ((subString = line.substring(0, 8)).contains(" ")) {
                        subString = subString.substring(0, subString.indexOf(" "));
                    }
                    //else subString = line.substring(0, 7);
                    //System.out.println(subString);
                    list.add(Integer.parseInt(subString));


                }
                Integer[] mass = list.toArray(new Integer[0]);
                int max = mass[0];
                for (int i = 0; i < mass.length; i++) {
                    if (mass[i] > max) max = mass[i];
                }
                max = max + 1;
//            System.out.println(max);
//            System.out.println(list);


                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(toOptimalDim(String.valueOf(max), 8)).append(toOptimalDim(args[1], 30)).
                        append(toOptimalDim(args[2], 8)).append(toOptimalDim(args[3], 4));
                //FileOutputStream fout = new FileOutputStream(fileName);

                FileWriter fw = new FileWriter(fileName, true);
                fw.write("\n" + stringBuilder.toString());
                fw.flush();
                fw.close();
                fis.close();
                // fout.close();

            } else {
                ;
            }
        } catch (Exception e) {
            System.out.println("Все сохранено ");

        }
    }
    public static String toOptimalDim(String origString, int numOfDim) {
        if (origString.length() == numOfDim) return origString;
        StringBuilder sb = new StringBuilder();
        sb.append(origString);
        for (int i = origString.length()-1; i < numOfDim-1 ; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
