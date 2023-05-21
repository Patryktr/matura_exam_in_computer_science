package com.github.patryktr.maturaExam2020;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static final String DANE_PATH = "C:\\Users\\patry\\OneDrive\\Pulpit\\matury\\informatyka-2020-czerwiec-matura-rozszerzona-zalaczniki\\Dane_PR2\\pary.txt";

    public static void main(String[] args) {
        task1();
        System.out.println("-------");
        System.out.println("-------");
        task2();
        System.out.println("-------");
        System.out.println("-------");
        task3();
    }

    public static void task1() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE_PATH));

            int result1 = 0;
            int result2 = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int digit = getNumber(line);
                if (digit % 2 != 0) {
                    continue;
                }
                if (digit < 4) {
                    continue;
                }
                for (int i = 0; i < digit; i++) {
                    int tempVariable1 = digit - i;
                    int tempVariable2 = i;
                    if (isPrimeNumber(tempVariable1) && isPrimeNumber(tempVariable2)) {
                        result1 = tempVariable1;
                        result2 = tempVariable2;
                        break;

                    }
                }
                System.out.println(digit + " " + result1 + " " + result2);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int getNumber(String line) {
        String[] split = line.split(" ");
        return Integer.valueOf(split[0] + "");
    }

    public static String getWord(String line) {
        String[] split = line.split(" ");
        return split[1];
    }


    public static boolean isPrimeNumber(int digit) {
        int i = digit;
        if (digit < 2) {
            return false;
        } else {
            while (i > 0) {
                i = i - 1;
                if (digit % i == 0) {
                    if (i == 1) {

                        return true;
                    } else {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static void task2() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE_PATH));


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String word = getWord(line);
                String maxSeries = "";
                String previousLetter = "";
                String currentSeries = "";
                for (int i = 0; i < word.length(); i++) {
                    if (i == 0) {
                        previousLetter = word.charAt(i) + "";
                        maxSeries = word.charAt(i) + "";
                        currentSeries = word.charAt(i) + "";
                        continue;
                    }
                    String currentLetter = word.charAt(i) + "";
                    if (currentLetter.equals(previousLetter)) {
                        currentSeries = currentSeries + currentLetter;

                    } else {
                        if (currentSeries.length() > maxSeries.length()) {
                            maxSeries = currentSeries;
                        }
                        currentSeries = currentLetter;
                    }
                    previousLetter = currentLetter;
                    if (currentSeries.length() > maxSeries.length()) {
                        maxSeries = currentSeries;

                    }

                }
                System.out.println(maxSeries + "" + maxSeries.length());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task3() {
        Scanner scanner = null;
        try {
            Integer currentDigit = null;
            Integer minDigit = null;
            String currentWord = "";
            String minWord = "";
            scanner = new Scanner(new File(DANE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String word = getWord(line);
                Integer number = getNumber(line);
                if (currentDigit == null) {
                    currentDigit = number;
                    minDigit = number;
                    minWord = word;
                    currentWord = word;
                    continue;
                }
                currentWord = word;
                currentDigit = number;
                if (isSmaller(currentDigit, minDigit, currentWord, minWord)) {
                    minWord = currentWord;
                    minDigit = currentDigit;
                }
            }

            System.out.println(minDigit + " " + minWord);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isSmaller(Integer currentDigit, Integer minDigit, String currentWord, String minWord) {
        if (currentDigit < minDigit) {
            return true;
        } else if (currentDigit > minDigit) {
            return false;

        } else {
            if (currentWord.length() < minWord.length()) {
                return true;
            } else if (currentWord.length() > minWord.length()) {
                return false;

            } else {
                for (int i = 0; i < currentWord.length(); i++) {
                    if (currentWord.charAt(i) < minWord.charAt(i)) {
                        return true;
                    }
                }
            }
        }
        return false;


    }
}
