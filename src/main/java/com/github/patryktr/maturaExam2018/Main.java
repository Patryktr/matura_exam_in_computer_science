package com.github.patryktr.maturaExam2018;

import java.io.File;
import java.util.*;

public class Main {
    public static final String DANE_PATH = "C:\\Users\\patry\\OneDrive\\Pulpit\\matury\\informatyka-2018-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\sygnaly.txt";
    public static final String DANE_PATH2 = "C:\\Users\\patry\\OneDrive\\Pulpit\\matury\\informatyka-2018-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\przyklad2.txt";

    public static void main(String[] args) {

    }

    public static void task1() {
        Scanner scanner = null;
        int lineNO = 1;

        String word = "";
        try {
            scanner = new Scanner(new File(DANE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNO % 40 == 0) {
                    word = word + line.charAt(9) + "";
                }
                lineNO++;

            }
            System.out.println(word);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task2() {
        Scanner scanner = null;
        int maxValue = 0;
        String maxWord = "";
        try {
            scanner = new Scanner(new File(DANE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                HashSet<String> withoutDuplicates = new HashSet<>(Arrays.asList(line.split("")));
                if (withoutDuplicates.size() > maxValue) {
                    maxValue = withoutDuplicates.size();
                    maxWord = line;
                }

            }

            System.out.println(maxWord + "   " + maxValue);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task3() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task3v2() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE_PATH));
            HashMap<String, Integer> alphabet = new HashMap<>();
            alphabet.put("A", 1);
            alphabet.put("B", 2);
            alphabet.put("C", 3);
            alphabet.put("D", 4);
            alphabet.put("E", 5);
            alphabet.put("F", 6);
            alphabet.put("G", 7);
            alphabet.put("H", 8);
            alphabet.put("I", 9);
            alphabet.put("J", 10);
            alphabet.put("K", 11);
            alphabet.put("L", 12);
            alphabet.put("M", 13);
            alphabet.put("N", 14);
            alphabet.put("O", 15);
            alphabet.put("P", 16);
            alphabet.put("R", 17);
            alphabet.put("S", 18);
            alphabet.put("T", 19);
            alphabet.put("Q", 20);
            alphabet.put("U", 21);
            alphabet.put("V", 22);
            alphabet.put("W", 23);
            alphabet.put("X", 24);
            alphabet.put("Y", 25);
            alphabet.put("Z", 26);
            List<String>result=new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int maxDigit=0;
                int minDigit=26;
                for (int i = 0; i < line.length(); i++) {
                    String letter = line.charAt(i) + "";
                    Integer digit = alphabet.get(letter);
                    if (digit>maxDigit){
                        maxDigit=digit;
                    }
                    if (digit<minDigit){
                        minDigit=digit;
                    }
                }
                if (maxDigit-minDigit<=10){
                    result.add(line);
                }

            }
            System.out.println(result);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
