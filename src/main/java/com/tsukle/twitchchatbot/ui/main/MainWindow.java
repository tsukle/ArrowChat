package com.tsukle.twitchchatbot.ui.main;

import com.tsukle.twitchchatbot.handlers.ConfigHandler;
import com.tsukle.twitchchatbot.handlers.CoreHandler;
import com.tsukle.twitchchatbot.serializing.Deserialize;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.io.File;

public class MainWindow extends JFrame {
    private JPanel mPanelMain;
    private JPanel mPanelBotInfo;
    private JLabel mLabelBotUsername;
    private JComboBox mComboBoxChannels;
    private JPanel mPanelBotSetup;
    private JButton mButtonJoin;
    private JPanel mPanelContent;

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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(mPanelMain);
        revalidate();
        repaint();

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
        File configFile = ConfigHandler.doesConfigExist();
        if(configFile == null)
        {
            setVisible(false);
            ConfigHandler.createConfig();
        }
        else
        {
            Deserialize.loadConfig(configFile);

            // Setup rest of the form based on config.
            setupComponents();
        }
        addListeners();
    }

    /**
     * Will add components after checking for user setup and config later on.
     */
    public void setupComponents()
    {
        mLabelBotUsername.setText("Bot - " + CoreHandler.getConfig().getBotUsername());
        refillComboBox();
    }

    private void refillComboBox()
    {
        mComboBoxChannels.removeAllItems();

        for (String channel : CoreHandler.getConfig().getBotChannels())
        {
            mComboBoxChannels.addItem(channel);
        }
    }

    /**
     * Adds listeners to all of the main items in the window.
     */
    private void addListeners()
    {
        mButtonJoin.addActionListener(e -> {
            // Create an IRC connection to the chat.
        });

        mComboBoxChannels.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                refillComboBox();
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                refillComboBox();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                refillComboBox();
            }
        });
    }

}
