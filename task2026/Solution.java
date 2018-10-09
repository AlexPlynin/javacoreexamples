package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании


Требования:
1. В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
2. Метод getRectangleCount должен быть публичным.
3. Метод getRectangleCount должен быть статическим.
4. Метод getRectangleCount должен возвращать количество прямоугольников (в соответствии с заданием) найденное в полученном массиве.
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
//        //byte a = 01010;
//        int b = 00011;
//        System.out.println(~b);
//        System.out.println(Boolean.getBoolean("0"));
//        //if ( a&(~b))

        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {


        int number = getFirstLineNumberCount(a);
        //System.out.println(number);
        int k = 0;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                if (a[i][j] == 0) {
                    if (i != a[0].length - 1) {//суть в том что имдем по строке до предпоследней строки
                        //смотрим первую гипотезу , при жи = 0 под данной цифрой возможна 1 следовательно образование нового прямоугодбника
                        //проверяем на наличие данной разницы 1110
                        //                                    0001<---------
                        if (a[i + 1][j] == 1) {
                            k=j;
                            while ((a[i + 1][k] == 1)&&(a[i][k] == 0)){//добавляем условие на повторение едениц
                                //00
                                //11 считаем за 1
                                if (k == a[0].length - 1) {
                                    //count++;
                                    break;//условие на последний элемент
                                }
                                k++;
                            }
                            j=k;
                            number++;
                        }
                    }
                }
//               else if (i == a[0].length - 1) {
//
//                    //if (a[i][j] == 1) number++;
//
//
//                }
                //обработка последней строки матрицы


            }

        }


        return number;
    }

    public static int getFirstLineNumberCount(byte[][] a) {
        //находим гипотезу о количестве прямоугольников в первой строке матрицы(проще можно сделать через регулярку)
        int count = 0;
        int j = 0;
        for (int i = 0; i < a[0].length; i++) {
            //System.out.println(a[0][i]);
            j = i;
            if (a[0][j] == 1) {
                while (a[0][j] == 1) {
                    if (j == a[0].length - 1) {
                        //count++;
                        break;//условие на последний элемент
                    }
                    j++;
                }
                count++;
                i = j;
                //i++;

            }
            //else i++;


        }


        return count;
    }
}
