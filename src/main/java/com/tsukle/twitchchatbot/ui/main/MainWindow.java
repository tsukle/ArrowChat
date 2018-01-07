package com.tsukle.twitchchatbot.ui.main;

import com.tsukle.twitchchatbot.util.ConfigLoader;
import javafx.stage.Screen;

import javax.swing.*;
import java.io.File;

public class MainWindow extends JFrame {
    private JPanel mPanelMain;

    private String appTitle;
    private double appID;

    /**
     * Constructor renders the window and sets out all of the information in the program.
     * @param appTitle - String value for the title of the app.
     * @param appID - Double value for the app id.
     */
    public MainWindow(String appTitle, double appID)
    {
        // Default window setup.
        setTitle("ArrowChat");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Don't remove this. (Learnt the hard way when pc crashed with hundreds of open processes.)
        setVisible(true);

        //Load app data into the values.
        this.appTitle = appTitle;
        this.appID = appID;

        // Check for user config.
        loadUserConfig();
    }

    /**
     * Runs a config check and creates one if none exist.
     */
    private void loadUserConfig()
    {
        // Load the user config.
        // If none is present then create one.
        File configFile = ConfigLoader.doesConfigExist();
        if(configFile == null)
        {
            ConfigLoader.createConfig();
        }
        else
        {
            //Use the config to populate the forms and components.
            // Extra component work.
            addComponents(configFile);
            addListeners(configFile);
        }
    }

    /**
     * Will add components after checking for user setup and config later on.
     */
    public void addComponents(File configFile)
    {

    }

    /**
     * Adds listeners to all of the main items in the window.
     */
    public void addListeners(File configFile)
    {

    }

}
