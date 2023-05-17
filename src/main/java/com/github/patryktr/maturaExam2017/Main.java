package com.github.patryktr.maturaExam2017;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class Main {
    public static String DANE = "C:\\Users\\patry\\OneDrive\\Pulpit\\matury\\informatyka-2017-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\dane.txt";
    public static String DANE2 = "C:\\Users\\patry\\OneDrive\\Pulpit\\matury\\informatyka-2017-maj-matura-rozszerzona-zalaczniki\\Dane_PR\\przyklad2.txt";

    public static void main(String[] args) {

    }

    public static void task1() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE));
            Integer currentMaxPixel = null;
            Integer currentMinPixel = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pixels = line.split(" ");
                for (int i = 0; i < pixels.length; i++) {
                    Integer pixel = Integer.valueOf(pixels[i]);
                    if (currentMaxPixel == null) {
                        currentMaxPixel = pixel;
                        currentMinPixel = pixel;
                    }
                    if (isGreatest(pixel, currentMaxPixel)) {
                        currentMaxPixel = pixel;
                    }
                    if (isSmaller(pixel, currentMinPixel)) {
                        currentMinPixel = pixel;
                    }
                }

            }
            System.out.println(currentMaxPixel);
            System.out.println(currentMinPixel);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean isGreatest(Integer pixel, Integer currentMaxPixel) {
        return pixel > currentMaxPixel;
    }

    public static boolean isSmaller(Integer pixel, Integer currentMinPixel) {
        return pixel < currentMinPixel;
    }

    public static void task2() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE));
            int licznik = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                if (czyNieMaPoziomejaosi(split)) {
                    licznik++;
                }
            }
            System.out.println(licznik);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean czyNieMaPoziomejaosi(String[] linia) {
        for (int i = 0; i < linia.length / 2; i++) {
            String pixel = linia[i];
            String pixel2 = linia[linia.length - 1 - i];
            if (!(pixel.equals(pixel2))) {
                return true;
            }
        }
        return false;
    }


    public static void task3() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DANE));
            int lineNumber = 1;
            int licznik = 1;
            HashMap<Integer, HashMap<Integer, Integer>> fileMap = new HashMap<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pixelsInLine = line.split(" ");
                HashMap<Integer, Integer> pixelRowMap = new HashMap<>();
                for (int i = 0; i < pixelsInLine.length; i++) {
                    pixelRowMap.put(i + 1, Integer.valueOf(pixelsInLine[i] + ""));
                }
                fileMap.put(lineNumber, pixelRowMap);
                lineNumber++;
            }
            Integer contrastingPixelCount = 0;
            for (int rowNumber = 1; rowNumber <= fileMap.size(); rowNumber++) {
                HashMap<Integer, Integer> columnsMap = fileMap.get(rowNumber);

                for (int columnNumber = 1; columnNumber <= columnsMap.size(); columnNumber++) {
                    licznik++;


                    Integer pixel = columnsMap.get(columnNumber);
                    Integer leftPixel = getLeftPixel(rowNumber, columnNumber, fileMap);
                    if (isContrasting(pixel, leftPixel)) {
                        contrastingPixelCount++;
                        continue;

                    }
                    Integer rightPixel = getRightPixel(rowNumber, columnNumber, fileMap);
                    if (isContrasting(pixel, rightPixel)) {
                        contrastingPixelCount++;
                        continue;
                    }
                    Integer abovePixel = getAbovePixel(rowNumber, columnNumber, fileMap);
                    if (isContrasting(pixel, abovePixel)) {
                        contrastingPixelCount++;
                        continue;
                    }
                    Integer belowPixel = getBelowPixel(rowNumber, columnNumber, fileMap);
                    if (isContrasting(pixel, belowPixel)) {
                        contrastingPixelCount++;

                    }
                }


            }
            System.out.println(contrastingPixelCount);
            System.out.println(licznik);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task4() {
        Scanner scanner = null;
        HashMap<Integer, Integer> kolumny = new HashMap<>();
        int maxPassa = 0;
        boolean isFirst = true;
        List<String> lastList = new ArrayList<>();
        try {
            scanner = new Scanner(new File(DANE));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> currentList = Arrays.asList(line.split(" "));
                if (isFirst) {
                    for (int i = 0; i < currentList.size() - 1; i++) {
                        if (kolumny.get(i) == null) {
                            kolumny.put(i, 1);
                        }
                    }
                    lastList = currentList;

                    isFirst = false;


                } else {
                    for (int i = 0; i < currentList.size() - 1; i++) {
                        if (currentList.get(i).equals(lastList.get(i))) {
                            Integer integer = kolumny.get(i);
                            kolumny.put(i, integer + 1);
                            if (integer + 1 > maxPassa) {
                                maxPassa = integer + 1;
                            }
                        } else {
                            kolumny.put(i, 1);
                        }
                    }
                    lastList = currentList;

                }


            }
            System.out.println(maxPassa);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean isContrasting(Integer pixel1, Integer pixel2) {
        if (pixel1 == null || pixel2 == null) {
            return false;
        }
        return pixel1 - pixel2 > 128 || pixel2 - pixel1 > 128;
    }


    public static Integer getLeftPixel(Integer rowNumber,
                                       Integer columnNumber,
                                       HashMap<Integer, HashMap<Integer, Integer>> fileMap) {
        Integer leftPixelRow = rowNumber;
        Integer leftPixelColumn = columnNumber - 1;

        return getPixel(leftPixelRow, leftPixelColumn, fileMap);

    }

    public static Integer getRightPixel(Integer rowNumber,
                                        Integer columnNumber,
                                        HashMap<Integer, HashMap<Integer, Integer>> fileMap) {
        Integer rightPixelRow = rowNumber;
        Integer rightPixelColumn = columnNumber + 1;

        return getPixel(rightPixelRow, rightPixelColumn, fileMap);

    }

    public static Integer getBelowPixel(Integer rowNumber,
                                        Integer columnNumber,
                                        HashMap<Integer, HashMap<Integer, Integer>> fileMap) {
        Integer belowPixelRow = rowNumber + 1;
        Integer belowPixelColumn = columnNumber;

        return getPixel(belowPixelRow, belowPixelColumn, fileMap);

    }

    public static Integer getAbovePixel(Integer rowNumber,
                                        Integer columnNumber,
                                        HashMap<Integer, HashMap<Integer, Integer>> fileMap) {
        Integer abovePixelRow = rowNumber - 1;
        Integer abovePixelColumn = columnNumber;

        return getPixel(abovePixelRow, abovePixelColumn, fileMap);

    }

    public static Integer getPixel(Integer rowNumber,
                                   Integer columnNumber,
                                   HashMap<Integer, HashMap<Integer, Integer>> fileMap) {

        HashMap<Integer, Integer> columnMap = fileMap.get(rowNumber);
        if (columnMap != null) {
            return columnMap.get(columnNumber);

        }

        return null;
    }


}
