package com.tsukle.twitchchatbot.util;


import javax.swing.*;
import java.awt.*;

public class CoreHandler
{
    /**
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
