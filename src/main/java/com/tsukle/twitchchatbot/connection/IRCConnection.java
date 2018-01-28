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
        twitchServerMessages.add(CoreHandler.getConfig().getBotUsername() + " = #" + channelName + " :");
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
            String message = "";
            List<String> userInfo = new ArrayList<>();

            while((line = mainReader.readLine()) != null)
            {
                // Check for a ping message and respond to it.
                if(line.toLowerCase().startsWith("PING "))
                {
                    mainWriter.write("PONG" + "\r\n");
                    mainWriter.flush();
                    line = "";
                }
                else
                {
                    // Check for server messages.
                    for (String twitchServerMessage : twitchServerMessages)
                    {
                        if(line.contains(twitchServerMessage))
                        {
                            line = "";
                        }
                    }

                    if(!line.equals(""))
                    {
                        message = getMessage(line);
                        userInfo = getUserInfo(line);

                        // Execute a listener call.
                        for (ChatListener listener : listeners)
                        {
                            listener.chatUpdated(message, userInfo, false);
                        }
                    }

                    // Execute a listener call.
                    for (ChatListener listener : listeners)
                    {
                        listener.chatUpdated(message, userInfo, true);
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private List<String> getUserInfo(String ircLine)
    {
        List<String> returnValue = new ArrayList<>();

        //Grab the username and add at as the first item in the list.
        String username = ircLine.split(" ")[1].split("!")[0].split(":")[1];
        returnValue.add(username);

        // Pull out extra info.
        String[] infoLineSplit = ircLine.split(" ")[0].split(";");

        // If the user is the broadcaster there is an extra index that we need to miss out. (INDEX: 7)
        if(infoLineSplit.length == 13)
        {
            String color = returnSplit(1, infoLineSplit);
            String displayName = returnSplit(2, infoLineSplit);
            String emotes = returnSplit(3, infoLineSplit);
            String messageID = returnSplit(4, infoLineSplit);
            String mod = returnSplit(5, infoLineSplit);
            String roomID = returnSplit(6, infoLineSplit);
            String subscriber = returnSplit(8, infoLineSplit);
            String tmiSentTS = returnSplit(9, infoLineSplit);
            String turbo = returnSplit(10, infoLineSplit);
            String userID = returnSplit(11, infoLineSplit);
            String userType = returnSplit(12, infoLineSplit);

            returnValue.add(color);
            returnValue.add(displayName);
            returnValue.add(emotes);
            returnValue.add(messageID);
            returnValue.add(mod);
            returnValue.add(roomID);
            returnValue.add(subscriber);
            returnValue.add(tmiSentTS);
            returnValue.add(turbo);
            returnValue.add(userID);
            returnValue.add(userType);
        }
        else
        {
            String color = returnSplit(1, infoLineSplit);
            String displayName = returnSplit(2, infoLineSplit);
            String emotes = returnSplit(3, infoLineSplit);
            String messageID = returnSplit(4, infoLineSplit);
            String mod = returnSplit(5, infoLineSplit);
            String roomID = returnSplit(6, infoLineSplit);
            String subscriber = returnSplit(7, infoLineSplit);
            String tmiSentTS = returnSplit(8, infoLineSplit);
            String turbo = returnSplit(9, infoLineSplit);
            String userID = returnSplit(10, infoLineSplit);
            String userType = returnSplit(11, infoLineSplit);

            returnValue.add(color);
            returnValue.add(displayName);
            returnValue.add(emotes);
            returnValue.add(messageID);
            returnValue.add(mod);
            returnValue.add(roomID);
            returnValue.add(subscriber);
            returnValue.add(tmiSentTS);
            returnValue.add(turbo);
            returnValue.add(userID);
            returnValue.add(userType);
        }

        return returnValue;
    }

    /**
     * Returns the split value of the given index.
     * @param index - The index to split.
     * @param infoLineSplit - The info array.
     * @return
     */
    private String returnSplit(int index, String[] infoLineSplit)
    {
        String returnValue = "";

        try
        {
            String[] split = infoLineSplit[index].split("=");

            if(split.length > 1)
            {
                returnValue = split[1];
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("MESSAGE HAD AN OUT OF BOUNDS EXCEPTION.");
        }

        return returnValue;
    }

    /**
     * Cleans up the irc chat to get the username and the message out of it.
     * @param ircLine - The IRC line to cleanup.
     * @return - Returns a list with the username and the message in it.
     */
    private String getMessage(String ircLine)
    {
        String split = "";
        try
        {
            split = ircLine.split("PRIVMSG #" + channelToJoin + " ")[1].split(":")[1];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            split = "YIKES";
        }
        return split;
    }
}
