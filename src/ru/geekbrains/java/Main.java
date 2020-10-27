package ru.geekbrains.java;

public class Main {

    public static void main(String[] args) {
        // целочисленные типы данных
        //объявление переменной
        byte b;
        //инициализация переменной
        b = 3;
        short s;
        s = 4;
        //определение переменной
        int i = 4;
        long l = 44;
        // типы данных с плавающей точкой
        float f = 23.4f;
        double d = 32.44;
        //символьный тип данных
        char c = 'c';
        //логический тип данных
        boolean bool = true;

        System.out.println(executeEx3(2, 4, 5, 6));
        System.out.println(executeEx4(8, 0));
        System.out.println(executeEx4(8, 10));
        System.out.println(executeEx4(18, 14));
        executeEx5(5);
        executeEx5(-4);
        System.out.println(executeEx6(5));
        System.out.println(executeEx6(-4));
        executeEx7("Том");
        System.out.println(executeEx8(2019));
    }

    private static double executeEx3(int a, int b, int c, double d) {
        return a * (b + (c / d));
    }

    private static boolean executeEx4(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    private static void executeEx5(int a) {
        System.out.println("Number " + a + " is " + ((a < 0) ? "negative" : "positive"));
    }

    private static boolean executeEx6(int a) {
        return a < 0;
    }

    private static void executeEx7(String s) {
        System.out.println("Привет, " + s);
    }

    private static boolean executeEx8(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
