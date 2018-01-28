package com.tsukle.twitchchatbot.ui.genericcomponents;

import com.tsukle.twitchchatbot.connection.IRCConnection;
import com.tsukle.twitchchatbot.connection.InfoList;
import com.tsukle.twitchchatbot.ui.ColorPalette.ColorPalette;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConnectionPanel extends JPanel{
    private JPanel mPanelMain;

    private JPanel mPanelContents;
    private JPanel mPanelTitle;
    private JLabel mLabelTitle;
    private JPanel mPanelChat;
    private JScrollPane mScrollPaneChat;
    private JTextArea mTextAreaChat;
    private JTextPane mTextPaneChat;

    /**
     * Constructor.
     */
    public ConnectionPanel(String channelName)
    {
        setBackground(new Color(60, 60, 60));
        mPanelMain.setBackground(new Color(60, 60, 60));
        mPanelContents.setBackground(new Color(60, 60, 60));
        mPanelTitle.setBackground(new Color(60, 60, 60));

        // Title Setup.
        mLabelTitle.setOpaque(false);
        mLabelTitle.setBackground(new Color(60, 60, 60));
        mLabelTitle.setForeground(new Color(ColorPalette.textTitleAccent.getRGB()));

        // Scroll Pane Setup.
        mScrollPaneChat.getVerticalScrollBar().setUnitIncrement(16);
        mScrollPaneChat.setAutoscrolls(true);
        mScrollPaneChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mScrollPaneChat.setBackground(new Color(60, 60, 60));

        // Chat Text Area Setup.
        mTextAreaChat.setAutoscrolls(true);
        mTextAreaChat.setLineWrap(true);
        mTextAreaChat.setWrapStyleWord(true);
        mTextAreaChat.setEditable(false);
        mTextAreaChat.setForeground(new Color(210, 210, 210));
        mTextAreaChat.setBackground(new Color(70, 70, 70));

        setupChat(channelName);
    }

    /**
     * Create an IRC Connection and display it in the chat window.
     * @param channelName - Channel that the connection is for.
     */
    private void setupChat(String channelName)
    {
        /**
         * Create an IRC Connection in a new thread and run an event listener to add to the chat.
         * The return string type is what the ChatListener sends when it is fired.
         */
        new IRCConnection(channelName, (String message, List<String> userInfo, boolean serverMessage) -> {
            if(serverMessage == false)
            {
                newMessage(message, userInfo);
            }
        }).start();

        mLabelTitle.setText("Connected to channel: " + channelName);
    }

    /**
     * Adds the message to the text area.
     * @param message - The message.
     * @param userInfo - The user information.
     */
    private void newMessage(String message, List<String> userInfo)
    {
        mTextAreaChat.append(" [" + infoGet(InfoList.USERNAME, userInfo).toLowerCase() + "]  -  " + message + "\n");
        mTextAreaChat.setCaretPosition(mTextAreaChat.getDocument().getLength());
    }

    /**
     * Return info based on an enum.
     * @param type - Enum
     * @param userInfo - Info list.
     * @return - Return the info.
     */
    private String infoGet(InfoList type, List<String> userInfo)
    {
        String returnValue = "";
        switch(type)
        {
            case USERNAME:
                returnValue = userInfo.get(0);
                break;
            case COLOR:
                returnValue = userInfo.get(1);
                break;
            case DISPLAY_NAME:
                returnValue = userInfo.get(2);
                break;
            case EMOTES:
                returnValue = userInfo.get(3);
                break;
            case ID:
                returnValue = userInfo.get(4);
                break;
            case MOD:
                returnValue = userInfo.get(5);
                break;
            case ROOM_ID:
                returnValue = userInfo.get(6);
                break;
            case SUBSCRIBER:
                returnValue = userInfo.get(7);
                break;
            case TMI_SENT_TS:
                returnValue = userInfo.get(8);
                break;
            case TURBO:
                returnValue = userInfo.get(9);
                break;
            case USER_ID:
                returnValue = userInfo.get(10);
                break;
            case USER_TYPE:
                returnValue = userInfo.get(11);
                break;
        }
        return returnValue;
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
