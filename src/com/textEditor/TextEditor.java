package com.textEditor;

import java.io.*;

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

    public static String open(String path) {
        BufferedReader reader;
        StringBuilder sb = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(path));
            while (reader.ready()) {
                sb.append(reader.readLine() + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
