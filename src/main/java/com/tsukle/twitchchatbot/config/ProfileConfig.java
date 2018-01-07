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
        // Null checking the private key so that it can never be null.
        if(botPrivateKey == null) { }
        else
        {
            this.BOT_PRIVATE_KEY = botPrivateKey;
        }
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
        // Run a null check on the bot channels so that it can never be a null value.
        if(botChannels == null) { }
        else
        {
            this.BOT_CHANNELS = botChannels;
        }
    }
}
