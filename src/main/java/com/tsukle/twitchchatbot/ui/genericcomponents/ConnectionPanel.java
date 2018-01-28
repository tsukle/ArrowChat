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
        mScrollPaneChat.setAutoscrolls(true);
        mScrollPaneChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Chat Text Area Setup.
        mTextAreaChat.setAutoscrolls(true);
        mTextAreaChat.setLineWrap(true);
        mTextAreaChat.setWrapStyleWord(true);
        mTextAreaChat.setEditable(false);

        setupChat(channelName);
    }

    /**
     * Create an IRC Connection and display it in the chat window.
     * @param channelName
     */
    public void setupChat(String channelName)
    {
        /**
         * Create an IRC Connection in a new thread and run an event listener to add to the chat.
         * The return string type is what the ChatListener sends when it is fired.
         */
        new IRCConnection(channelName, (String message) -> {
            if(!message.equals("Server Message."))
            {
                newMessage(message);
            }
        }).start();
    }

    private void newMessage(String message)
    {
        mTextAreaChat.append("\n" + message + "\n");
        mTextAreaChat.setCaretPosition(mTextAreaChat.getDocument().getLength());
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
