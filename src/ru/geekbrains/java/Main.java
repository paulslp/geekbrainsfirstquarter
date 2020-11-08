package ru.geekbrains.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Введите размер поля");
        int size = sc.nextInt();
        System.out.println("Введите размер победного ряда");
        int dotsCountForWin = sc.nextInt();
        initMap(size);
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, dotsCountForWin)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O, dotsCountForWin)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap(int size) {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkWin(char symb, int dotsCountForWin) {
        String winningString = createFillingString(symb, dotsCountForWin);
        return checkLines(winningString) || checkColumns(winningString) ||
                checkDiagonals(winningString, dotsCountForWin);
    }

    private static boolean checkDiagonals(String winningString, int dotsCountForWin) {
        return checkLeftBottomDiagonal(winningString, dotsCountForWin) ||
                checkLeftTopDiagonal(winningString, dotsCountForWin) ||
                checkRightBottomDiagonal(winningString, dotsCountForWin) ||
                checkRightTopDiagonal(winningString, dotsCountForWin);
    }

    private static boolean checkLeftBottomDiagonal(String winningString, int dotsCountForWin) {
        for (int columnsCount = 1; columnsCount <= map.length - dotsCountForWin; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = columnsCount; column < map.length; column++) {
                int line = column - columnsCount;
                diagonalChars[line] = map[line][column];
            }
            if (String.valueOf(diagonalChars).contains(winningString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkLeftTopDiagonal(String winningString, int dotsCountForWin) {
        for (int columnsCount = dotsCountForWin - 1; columnsCount < map.length; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = 0; column <= columnsCount; column++) {
                int line = map.length - 1 - columnsCount + column;
                diagonalChars[line] = map[line][column];
            }
            if (String.valueOf(diagonalChars).contains(winningString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRightBottomDiagonal(String winningString, int dotsCountForWin) {
        for (int columnsCount = 1; columnsCount <= map.length - dotsCountForWin; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = columnsCount; column < map.length; column++) {
                int line = map.length - column + columnsCount - 1;
                diagonalChars[line] = map[line][column];
            }
            if (String.valueOf(diagonalChars).contains(winningString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRightTopDiagonal(String winningString, int dotsCountForWin) {
        for (int columnsCount = dotsCountForWin - 1; columnsCount < map.length; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = 0; column <= columnsCount; column++) {
                int line = columnsCount - column;
                diagonalChars[line] = map[line][column];
            }
            if (String.valueOf(diagonalChars).contains(winningString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(String winningString) {
        char[] verticalChars = new char[map.length];
        for (int column = 0; column < map.length; column++) {
            for (int line = 0; line < map.length; line++) {
                verticalChars[line] = map[line][column];
            }
            if (String.valueOf(verticalChars).contains(winningString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkLines(String winningString) {
        for (int line = 0; line < map.length; line++) {
            if (String.valueOf(map[line]).contains(winningString)) {
                return true;
            }
        }
        return false;
    }

    private static String createFillingString(char symb, int dotsCountForWin) {
        char[] winningCharCombination = new char[dotsCountForWin];
        Arrays.fill(winningCharCombination, symb);
        return String.valueOf(winningCharCombination);
    }

    public static boolean isMapFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(map.length);
            y = rand.nextInt(map.length);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map.length) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

}