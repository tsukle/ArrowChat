package com.tsukle.twitchchatbot.ui.config;

import com.tsukle.twitchchatbot.util.CoreHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreateConfig extends JFrame
{
    private JPanel mPanelMain;
    private JPanel mPanelBotInfo;
    private JLabel mLabelUsernameTitle;
    private JTextField mTextFieldUsername;
    private JLabel mLabelPrivateKeyTitle;
    private JTextField mTextFieldPrivateKey;
    private JLabel mLabelChannelsTitle;
    private JTextField mTextFieldChannels;
    private JLabel mLabelCurrentChannels;
    private JLabel mLabelCurrentChannelsTitle;
    private JButton mButtonAddChannel;

    private List<String> listOfChannels;

    public CreateConfig()
    {
        // Default window setup.
        setTitle("ArrowChat - Config");
        setSize(500, 500);
        setLocationRelativeTo(CoreHandler.getCoreWindow());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Make sure to keep this.
        setVisible(true);
        add(mPanelMain);
        revalidate();
        repaint();

        //Instanciate lists.
        listOfChannels = new ArrayList<>();

        // Set listeners.
        addListeners();
    }

    /**
     * Add listeners to specified components.
     */
    private void addListeners()
    {
        mButtonAddChannel.addActionListener(e -> {
            // If no channel was specified.
            if(mTextFieldChannels.getText().equals(""))
            {
                JDialog jDialog = new JDialog(this, "No channel name provided.", true);
                jDialog.setSize(250, 150);
                jDialog.setLocationRelativeTo(this);
                jDialog.setResizable(false);
                jDialog.setAlwaysOnTop(true);
                jDialog.setLayout(new GridBagLayout());
                JLabel jLabel = new JLabel("Please enter a channel name.");
                jDialog.add(jLabel);
                jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                jDialog.setVisible(true);
            }

            // If a channel was specified.
            else
            {
                listOfChannels.add(mTextFieldChannels.getText());
                String currentChannelsText = "";
                for (String channel : listOfChannels)
                {
                    if(currentChannelsText.equals(""))
                    {
                        currentChannelsText = channel;
                    }
                    else
                    {
                        currentChannelsText += ", " + channel;
                    }
                }
                mLabelCurrentChannels.setText(currentChannelsText);
                mTextFieldChannels.setText("");
            }
        });
    }
}
