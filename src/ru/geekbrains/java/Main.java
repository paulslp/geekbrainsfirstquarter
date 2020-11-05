package ru.geekbrains.java;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        guessNumber(random, scanner);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        System.out.println("Введите слово: ");
        System.out.println("Вы " + (guessWordAttempt(scanner, words[random.nextInt(words.length)]) ? "выиграли" : "проиграли"));
    }

    private static boolean guessWordAttempt(Scanner scanner, String hiddenWord) {
        do {
            String answerWord = scanner.nextLine();
            if (answerWord.equals(hiddenWord)) {
                return true;
            } else {
                System.out.println("Загаданное слово:" + matchAnswerWithHiddenWord(answerWord, hiddenWord));
            }
        } while (true);

    }

    private static String matchAnswerWithHiddenWord(String answerWord, String hiddenWord) {
        String result = "###############";
        int minWordLength = Math.min(hiddenWord.length(), answerWord.length());
        for (int i = 0; i < minWordLength; i++) {
            if (answerWord.charAt(i) == hiddenWord.charAt(i)) {
                char[] charResult = result.toCharArray();
                charResult[i] = hiddenWord.charAt(i);
                result = String.valueOf(charResult);
            }
        }
        return result;
    }

    private static void guessNumber(Random random, Scanner scanner) {
        do {
            System.out.println("Введите число от 0 до 9: ");
            System.out.println("Вы " + (guessNumberAttempt(scanner, random.nextInt(10)) ? "выиграли" : "проиграли"));
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет (1 – повторить, 0 – нет)");
        } while (scanner.hasNextInt() && scanner.nextInt() == 1);
    }

    private static boolean guessNumberAttempt(Scanner scanner, int hiddenNumber) {
        int answerNumber;
        int numberOfAttempts = 0;
        do {
            numberOfAttempts++;
            if (!scanner.hasNextInt()) {
                System.out.println("Значение " + scanner.next() + " не является числом.");
                return false;
            }
            answerNumber = scanner.nextInt();
            if (hiddenNumber > answerNumber) {
                System.out.println("Загаданное число больше");
            } else if (hiddenNumber < answerNumber) {
                System.out.println("Загаданное число меньше");
            } else {
                return true;
            }
        } while (numberOfAttempts < 3);
        return false;
    }
}
