package com.tsukle.twitchchatbot.main;

import javax.swing.*;

public class Main {

    private static String bTitle = "ArrowChat";
    private static double bAppId = 1.0;

    public static void main(String[] args)
    {
        // Swing invoke later the Entry to start the main window.
        SwingUtilities.invokeLater(() -> {
            Entry entry = new Entry(bTitle, bAppId);
            entry.start();
        });
    }
}
