package com.tsukle.twitchchatbot.handlers;


import com.tsukle.twitchchatbot.config.ProfileConfig;

import javax.swing.*;
import java.awt.*;

public class CoreHandler
{

    private static ProfileConfig profileConfig = new ProfileConfig();

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
     * Static so it can be called without instantiating the class.
     * Returns the programs Core Window.
     * @return - Core Window Frame.
     */
    public static Frame getCoreWindow()
    {
        Frame returnValue = null;

        Frame[] frames = JFrame.getFrames();
        for (Frame frame : frames)
        {
            if(frame.getTitle().equals("ArrowChat"))
            {
                returnValue = frame;
            }
        }

        return returnValue;
    }
}
