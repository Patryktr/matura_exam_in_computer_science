package com.github.patryktr.maturaExam2015;

import com.github.patryktr.ResultWriter;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static String DANE = "C:\\Users\\patry\\Downloads\\informatyka-2015-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\liczby.txt";
    public static String ANSWER_PATH = "C:\\Users\\patry\\Downloads\\informatyka-2015-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\answer.txt";
    public static String DANE2 = "C:\\Users\\patry\\Downloads\\informatyka-2015-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\liczby2.txt";

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }


    public static void task1() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE));
            int licznik = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int licznikZer = 0;
                for (int i = 0; i < line.length(); i++) {
                    String cyfra = line.charAt(i) + "";
                    if (cyfra.equals("0")) {
                        licznikZer++;

                    }
                }
                if (licznikZer > (line.length() / 2)) {
                    licznik++;

                }

            }
            ResultWriter.write("4.1", String.valueOf(licznik), ANSWER_PATH);
            System.out.println(licznik);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task2() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE));
            int podzielnePrzez2 = 0;
            int podzielnePrzez8 = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String ostatniaCyfra = line.charAt(line.length() - 1) + "";
                String trzyOstatnieCyfry = line.charAt(line.length() - 1) + "" + line.charAt(line.length() - 2) + line.charAt(line.length() - 3);
                if (ostatniaCyfra.equals("0")) {
                    podzielnePrzez2++;

                }
                if (trzyOstatnieCyfry.equals("000")) {
                    podzielnePrzez8++;
                }
            }
            System.out.println(podzielnePrzez8);
            System.out.println(podzielnePrzez2);
            String answer="liczb podzielnych przez 2 jest "+ podzielnePrzez2+" liczb podzielnych przez 8 jest "+podzielnePrzez8;
            ResultWriter.write("4.2", answer, ANSWER_PATH);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void task3() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE));

            String currentMaxLine = null;
            String currentMinLine = null;
            int currentMinLineNo = 0;
            int currentMaxLineNo = 0;
            int currentLineNo = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (currentLineNo == 1) {
                    currentMinLine = line;
                    currentMaxLine = line;
                    currentMinLineNo = currentLineNo;
                    currentMaxLineNo = currentLineNo;
                    currentLineNo++;
                    continue;
                }


                if (isGreater(line, currentMaxLine)) {
                    currentMaxLine = line;
                    currentMaxLineNo = currentLineNo;

                }
                if (isSmaller(line, currentMinLine)) {
                    currentMinLine = line;
                    currentMinLineNo = currentLineNo;

                }


                currentLineNo++;

            }
            System.out.println(currentMaxLineNo);
            System.out.println(currentMinLineNo);
            String answer = "index najmniejszej liczby to "+currentMinLineNo+" index najwiekszej liczby to "+currentMaxLineNo;
            ResultWriter.write("4.3", answer, ANSWER_PATH);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean isGreater(String line, String maxLine) {
        int lineLength = line.length();
        int maxLineLength = maxLine.length();
        if (lineLength > maxLineLength) {
            return true;
        }
        if (lineLength == maxLineLength) {
            for (int i = 0; i < lineLength; i++) {
                if (line.charAt(i) > maxLine.charAt(i)) {
                    return true;
                }
                if (line.charAt(i) < maxLine.charAt(i)) {
                    return false;
                }
            }
        }

        return false;
    }

    public static boolean isSmaller(String line, String minLine) {
        int lineLength = line.length();
        int minLineLength = minLine.length();
        if (lineLength < minLineLength) {
            return true;
        }
        if (lineLength == minLineLength) {
            for (int i = 0; i < lineLength; i++) {
                if (line.charAt(i) < minLine.charAt(i)) {
                    return true;
                }
                if (line.charAt(i) > minLine.charAt(i)) {
                    return false;
                }
            }
        }

        return false;
    }

}
