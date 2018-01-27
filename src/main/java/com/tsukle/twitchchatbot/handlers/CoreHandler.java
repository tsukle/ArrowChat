package com.tsukle.twitchchatbot.handlers;


import com.tsukle.twitchchatbot.config.ProfileConfig;
import com.tsukle.twitchchatbot.ui.main.MainWindow;

import javax.swing.*;
import java.awt.*;

public class CoreHandler
{
    /**
     * Variables.
     */
    private static MainWindow coreWindow;
    private static ProfileConfig profileConfig;

    /**
     * Get the programs config.
     * @return - Config file to return.
     */
    public static ProfileConfig getConfig()
    {
        return profileConfig;
    }

    /**
     * Set the programs config.
     * @param config - Config file to set as the main one.
     */
    public static void setConfig(ProfileConfig config)
    {
        profileConfig = config;
    }

    /**
     * Get the programs core window.
     * @return - The core window.
     */
    public static MainWindow getCoreWindow() {
        return coreWindow;
    }

    /**
     * Set the programs core window
     * @param window - The window to set as the core window.
     */
    public static void setCoreWindow(MainWindow window) {
        coreWindow = window;
    }

    /**
     * Get the program directory.
     * @return - Returns the program directory.
     */
    public static String getProgramDirectory() {
        return "C:/ProgramData/ArrowChat";
    }
}
