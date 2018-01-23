package com.tsukle.twitchchatbot.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileConfig
{
    @Expose
    @SerializedName("BOT_USERNAME")
    private String BOT_USERNAME;

    @Expose
    @SerializedName("BOT_PRIVATE_KEY")
    private String BOT_PRIVATE_KEY;

    @Expose
    @SerializedName("BOT_CHANNELS")
    private List<String> BOT_CHANNELS;

    @Expose
    @SerializedName("BOT_DIRECTORY")
    private String BOT_DIRECTORY;


    /**
     * Returns the bots username.
     * @return - String value of the bots username.
     */
    public String getBotUsername()
    {
        return BOT_USERNAME;
    }

    /**
     * Set the bots username.
     * @param botUsername - String value of the bots new username.
     */
    public void setBotUsername(String botUsername)
    {
        if(botUsername == null){ }
        else
        {
            this.BOT_USERNAME = botUsername;
        }
    }

    /**
     * Get the bots private key.
     * @return - String value of the bots private key.
     */
    public String getBotPrivateKey()
    {
        return BOT_PRIVATE_KEY;
    }

    /**
     * Set the bots private key.
     * @param botPrivateKey - String value of the bots new private key.
     */
    public void setBotPrivateKey(String botPrivateKey)
    {
        this.BOT_PRIVATE_KEY = botPrivateKey;
    }

    /**
     * Get the bots list of channels.
     * @return - List of string values containing the bots current channels.
     */
    public List<String> getBotChannels()
    {
        return BOT_CHANNELS;
    }

    /**
     * Set the bots list of channels.
     * @param botChannels - List of string values to be the new list of current channels for the bot.
     */
    public void setBotChannels(List<String> botChannels)
    {
        this.BOT_CHANNELS = botChannels;
    }

    /**
     * Get the bots save directory.
     * @return - String value of the bots directory.
     */
    public String getBotDirectory() {
        return BOT_DIRECTORY;
    }

    /**
     * Set the bots save directory.
     * @param dir - The string value of the directory to set as the bots save directory.
     */
    public void setBotDirectory(String dir) {
        BOT_DIRECTORY = dir;
    }
}
