package com.tsukle.twitchchatbot.ui.genericcomponents;

import com.tsukle.twitchchatbot.connection.ChatListener;
import com.tsukle.twitchchatbot.connection.IRCConnection;
import com.tsukle.twitchchatbot.ui.ColorPalette.ColorPalette;

import javax.swing.*;
import java.awt.*;

public class ConnectionPanel extends JPanel{
    private JPanel mPanelMain;

    private JPanel mPanelContents;
    private JPanel mPanelTitle;
    private JLabel mLabelTitle;
    private JPanel mPanelChat;
    private JScrollPane mScrollPaneChat;
    private JTextArea mTextAreaChat;

    /**
     * Constructor.
     */
    public ConnectionPanel(String channelName)
    {
        // Title Setup.
        mLabelTitle.setForeground(new Color(ColorPalette.textTitleAccent.getRGB()));

        // Scroll Pane Setup.
        mScrollPaneChat.getVerticalScrollBar().setUnitIncrement(16);

        // Chat Text Area Setup.
        mTextAreaChat.setAutoscrolls(true);
        mTextAreaChat.setEditable(false);
        mTextAreaChat.setText("Not connected to chat.");

        setupChat(channelName);
    }

    /**
     * Create an IRC Connection and display it in the chat window.
     * @param channelName
     */
    public void setupChat(String channelName)
    {
        // Add a listener to this for the chat shit...
        new IRCConnection(channelName, new ChatListener()
        {
            @Override
            public void chatUpdated(String message)
            {
                newMessage(message);
            }
        }).start();
    }

    private void newMessage(String message)
    {
        mTextAreaChat.append("\n" + message + "\n");
    }

    /**
     * Used to get the panel when you want to add this to the main window.
     * @return - The main panel.
     */
    public JPanel getPanel()
    {
        return mPanelMain;
    }
}
