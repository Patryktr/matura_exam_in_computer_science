package com.github.patryktr.maturaExam2019;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String DANE_PATH = "C:\\Users\\patry\\OneDrive\\Pulpit\\matury\\informatyka-2019-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\liczby.txt";

    public static void main(String[] args) {
        task3();


    }

    public static void task1() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE_PATH));
            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Integer digit = Integer.valueOf(line);
                if (digit == 1) {
                    counter++;
                    continue;
                }
                while (digit % 3 == 0) {
                    digit = digit / 3;
                    if (digit == 1) {
                        counter++;
                    }
                }
            }
            System.out.println(counter);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer factorial(Integer digit) {
        int factorialDigit = 1;
        for (int i = 0; digit > 0; i++) {
            factorialDigit = digit * factorialDigit;
            digit = digit - 1;

        }
        return factorialDigit;
    }

    public static void task2() {
        Scanner scanner = null;
        List<Integer> result = new ArrayList<>();
        try {
            scanner = new Scanner(new File(DANE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int sumOfFactorialDigit = 0;
                for (int i = 0; i < line.length(); i++) {
                    Integer digit = Integer.valueOf(line.charAt(i) + "");
                    sumOfFactorialDigit = sumOfFactorialDigit + factorial(digit);
                }
                if (sumOfFactorialDigit == Integer.valueOf(line)) {
                    result.add(Integer.valueOf(line));

                }
            }
            System.out.println(result);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task3() {
        Scanner scanner = null;
        int firstMaxSeriesDigit = 0;
        int firstCurrentSeriesDigit = 0;
        int maxSeriesVal = 0;
        int currentSeriesVal = 0;
        int previousDigit = 0;
        int currentNwd = 0;
        int maxSeriesNwd = 0;


        try {
            scanner = new Scanner(new File(DANE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Integer digit = Integer.valueOf(line);
                if (firstMaxSeriesDigit == 0) {
                    firstMaxSeriesDigit = digit;
                    firstCurrentSeriesDigit = digit;
                    currentSeriesVal = 1;
                    previousDigit = digit;
                    currentNwd = digit;
                    continue;
                }

                int calculatedNwd = nwd(currentNwd, digit);
                if (calculatedNwd > 1) {
                    currentNwd = calculatedNwd;
                    currentSeriesVal++;

                } else {
                    currentNwd = nwd(digit, previousDigit);
                    firstCurrentSeriesDigit = previousDigit;

                    currentSeriesVal = currentNwd > 1 ? 2 : 1;
                }
                if (currentSeriesVal > maxSeriesVal) {
                    firstMaxSeriesDigit = firstCurrentSeriesDigit;
                    maxSeriesVal = currentSeriesVal;
                    maxSeriesNwd = currentNwd;

                }
                previousDigit = digit;


            }
            System.out.println(maxSeriesVal + " " + firstMaxSeriesDigit + " " + maxSeriesNwd);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int nwd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


}
