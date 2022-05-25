package com.denisu.fpgame.fileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileIO {

    public static void WriteHighscore(String s) {
        try {
            File f = new File("highscores.txt");
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
                FileWriter fw = new FileWriter(f);
                fw.write(s + " " + getDate() + "\n");
                fw.close();
            } else {
                FileWriter fw = new FileWriter(f);
                fw.write(s + " " + getDate() + "\n");
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

}
