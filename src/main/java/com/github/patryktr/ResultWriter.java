package com.github.patryktr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
    public static void write(String taskNo, String answer, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            fileWriter.write("task number: " + taskNo + " answer: " + answer + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
