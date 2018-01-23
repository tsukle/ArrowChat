package com.tsukle.twitchchatbot.main;

import com.tsukle.twitchchatbot.handlers.CoreHandler;
import com.tsukle.twitchchatbot.ui.main.MainWindow;

import javax.swing.*;
import java.util.Scanner;

public class Entry extends JFrame {

    private String appTitle;
    private double appID;

    public Entry(String appTitle, double appID)
    {
        this.appTitle = appTitle;
        this.appID = appID;
    }

    /**
     * Loads the main window of the program after checking for config settings.
     */
    public void start()
    {
        MainWindow mainWindow = new MainWindow(appTitle, appID);
        CoreHandler.setCoreWindow(mainWindow);
    }
}
