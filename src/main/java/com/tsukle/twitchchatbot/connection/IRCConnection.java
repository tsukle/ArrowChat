package com.tsukle.twitchchatbot.connection;

import com.tsukle.twitchchatbot.handlers.CoreHandler;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class IRCConnection extends Thread
{
    private List<ChatListener> listeners = new ArrayList<ChatListener>();
    private BufferedWriter mainWriter;
    private BufferedReader mainReader;
    private String channelToJoin;
    private List<String> twitchServerMessages;


    /**
     * Constructor.
     * @param channelName - The channel that the user wants to connect to.
     */
    public IRCConnection(String channelName, ChatListener chatListener)
    {
        // Twitch server messages.
        twitchServerMessages = new ArrayList<>();
        twitchServerMessages.add("tmi.twitch.tv JOIN #");
        twitchServerMessages.add(":tmi.twitch.tv");
        twitchServerMessages.add(":jtv MODE");
        twitchServerMessages.add(":End of /NAMES list");
        twitchServerMessages.add("#" + channelName + " :" + CoreHandler.getConfig().getBotUsername());

        // Setup.
        channelToJoin = channelName;
        listeners.add(chatListener);
    }

    /**
     * Connect to the twitch IRC using a channel name.
     */
    public void run()
    {
        String server = "irc.chat.twitch.tv";
        int port = 6667;
        String nick = CoreHandler.getConfig().getBotUsername();
        String auth = CoreHandler.getConfig().getBotPrivateKey();

        try
        {
            Socket connection = new Socket(server, port);
            mainWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            mainReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Login.
            mainWriter.write("CAP REQ :twitch.tv/membership\r\n");
            mainWriter.write("CAP REQ :twitch.tv/commands\r\n");
            mainWriter.write("CAP REQ :twitch.tv/tags\r\n");
            mainWriter.write("PASS " + auth + "\r\n");
            mainWriter.write("NICK " + nick + "\r\n");
            mainWriter.write("JOIN #" + channelToJoin + "\r\n");
            mainWriter.flush();

            String line;
            while((line = mainReader.readLine()) != null)
            {
                // Check for a ping message and respond to it.
                if(line.toLowerCase().startsWith("PING "))
                {
                    mainWriter.write("PONG" + "\r\n");
                    mainWriter.flush();
                }
                // Check for server messages.
                for (String twitchServerMessage : twitchServerMessages)
                {
                    if(line.contains(twitchServerMessage))
                    {
                        line = "Server Message.";
                    }
                }

                // Execute a listener call.
                for (ChatListener listener : listeners)
                {
                    listener.chatUpdated(line);
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Add a listener to the list.
     * @param toAdd - Listener to add.
     */
    public void addListener(ChatListener toAdd)
    {
        listeners.add(toAdd);
    }
}
