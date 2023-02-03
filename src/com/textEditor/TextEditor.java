package com.textEditor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor {

    public static void save(String text, String path) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(path + ".txt"));
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
