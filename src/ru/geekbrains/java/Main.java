package ru.geekbrains.java;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*
         * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
         * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
         * С помощью цикла и условия заменить 0 на 1, 1 на 0;
         * */
        short[] arrayForEx1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(invertValuesInArray(arrayForEx1)));

        /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        int[] arrayForEx2 = new int[8];
        for (int i = 0; i < arrayForEx2.length; i++) {
            arrayForEx2[i] = i * 3;
        }
        printIntArray(arrayForEx2);

        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        int[] arrayForEx3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayForEx3.length; i++) {
            if (arrayForEx3[i] < 6) {
                arrayForEx3[i] = arrayForEx3[i] * 2;
            }
        }
        printIntArray(arrayForEx3);

        /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        int[][] arrayForEx4 = new int[4][4];
        for (int i = 0; i < arrayForEx4.length; i++) {
            for (int j = 0; j < arrayForEx4[i].length; j++) {
                if (i == j) {
                    arrayForEx4[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arrayForEx4.length; i++) {
            System.out.println(Arrays.toString(arrayForEx4[i]));
        }
        /*
        5. ** Задать одномерный массив и найти в нем минимальный и
        максимальный элементы (без помощи интернета);
         */
        int[] arrayForEx5 = {19, -5, 3, 2, 11, 4, 5, 25, 4, 8, 9, 1};
        int max = arrayForEx5[0];
        int min = arrayForEx5[0];
        for (int i = 1; i < arrayForEx5.length; i++) {
            if (arrayForEx5[i] > max) {
                max = arrayForEx5[i];
            }
            if (arrayForEx5[i] < min) {
                min = arrayForEx5[i];
            }
        }
        System.out.println("Min = " + min + ", Max = " + max);
        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
        эти символы в массив не входят.

        В этом задании используется массив {0, 1, 3, 2, 11, 4, 5,|| 1, 8, 8, 9, 0}*/
        int[] arrayForEx6 = {0, 1, 3, 2, 11, 4, 5, 1, 8, 8, 9, 0};
        System.out.println(checkBalance(arrayForEx6));

        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n
        (может быть положительным, или отрицательным), при этом метод должен сместить
        все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться
        вспомогательными массивами.
         */
        int[] arrayForEx71 = {0, 1, 3, 2, 7, 4, 5, 1, 8, 8, 9, 0};
        System.out.println("Array before: " + Arrays.toString(arrayForEx71));
        System.out.println("Array after offset 4:  " + Arrays.toString(offSetByNPositions(arrayForEx71, 4)));
        int[] arrayForEx72 = {0, 1, 3, 2, 7, 4, 5, 1, 8, 8, 9, 0};
        System.out.println("Array after offset -4: " + Arrays.toString(offSetByNPositions(arrayForEx72, -4)));
    }

    private static short[] invertValuesInArray(short[] shorts) {
        for (int i = 0; i < shorts.length; i++) {
            if (shorts[i] == 0) {
                shorts[i] = 1;
            } else if (shorts[i] == 1) {
                shorts[i] = 0;
            }
        }
        return shorts;
    }

    private static void printIntArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }


    private static boolean checkBalance(int[] array) {
        int i = 0;
        while (i < array.length) {
            if (compareLeftAndRightPartSumArray(array, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean compareLeftAndRightPartSumArray(int[] array, int borderIndex) {
        int sumRight = 0, sumLeft = 0;
        for (int i = 0; i < array.length; i++) {
            if (i <= borderIndex) {
                sumLeft = sumLeft + array[i];
            } else {
                sumRight = sumRight + array[i];
            }
        }
        return sumRight == sumLeft;
    }

    private static int[] offSetByNPositions(int[] array, int n) {
        if (n == 0) {
            return array;
        }
        if (n > 0) {
            for (int i = array.length - 1; i > 0; i--) {
                if ((i - n) > 0) {
                    array[i] = array[i - n];
                } else {
                    array[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if ((i - n) < array.length) {
                    array[i] = array[i - n];
                } else {
                    array[i] = 0;
                }
            }
        }
        return array;
    }
}
