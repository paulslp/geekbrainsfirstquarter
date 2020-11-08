package ru.geekbrains.java;

import java.util.Arrays;

public class Diagonal {
    public static char[][] map =   {{'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'J'},
            {'K', 'L', 'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S', 'T'},
            {'U', 'V', 'W', 'X', 'Y'}};

    public static void main(String[] args) {
        int dotsCountForWin = 4;
        System.out.println("checkRightTopDiagonal");
        checkRightTopDiagonal(dotsCountForWin);
        System.out.println("checkRightBottomDiagonal");
        checkRightBottomDiagonal(dotsCountForWin);

        System.out.println();
        System.out.println("checkLeftTopDiagonal");
        checkLeftTopDiagonal(dotsCountForWin);
        System.out.println("checkLeftBottomDiagonal");
        checkLeftBottomDiagonal(dotsCountForWin);
    }

    private static boolean checkLeftBottomDiagonal( int dotsCountForWin) {
        for (int columnsCount = 1; columnsCount <= map.length - dotsCountForWin; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = columnsCount; column < map.length; column++) {
                int line = column - columnsCount;
                diagonalChars[line] = map[line][column];
                System.out.print(map[line][column] + " ");
            }
            System.out.println("diagonalChars: " + Arrays.toString(diagonalChars));
        }
        return false;
    }

    private static void checkLeftTopDiagonal(int dotsCountForWin) {
        for (int columnsCount = dotsCountForWin - 1; columnsCount < map.length; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = 0; column <= columnsCount; column++) {
                int line = map.length - 1 - columnsCount + column;
                diagonalChars[line] = map[line][column];
                System.out.print(map[line][column] + " ");
            }
            System.out.println("diagonalChars: " + Arrays.toString(diagonalChars));
            System.out.println();
        }
    }

    private static void checkRightBottomDiagonal(int dotsCountForWin) {
        for (int columnsCount = 1; columnsCount <= map.length - dotsCountForWin; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = columnsCount; column <map.length; column++) {
                int line = map.length - column + columnsCount - 1;
                diagonalChars[line] = map[line][column];
                System.out.print(map[line][column] + " ");
            }
            System.out.println("diagonalChars: " + Arrays.toString(diagonalChars));
            System.out.println();
        }
    }

    private static void checkRightTopDiagonal(int dotsCountForWin) {
        for (int columnsCount = dotsCountForWin - 1; columnsCount < map.length; columnsCount++) {
            char[] diagonalChars = new char[map.length];
            for (int column = 0; column <= columnsCount; column++) {
                int line = columnsCount - column;
                diagonalChars[line] = map[line][column];
                System.out.print(map[line][column] + " ");
            }
            System.out.println("diagonalChars: " + Arrays.toString(diagonalChars));
            System.out.println();
        }
    }
}
