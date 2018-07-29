package com.freesoft.wssintegration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void writeToFile(String input) {
        File file = new File("C:\\DevTools\\trading-workspace\\websocket-client\\file.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
