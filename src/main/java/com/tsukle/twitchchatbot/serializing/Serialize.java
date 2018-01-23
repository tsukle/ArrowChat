package com.tsukle.twitchchatbot.serializing;

import com.google.gson.Gson;
import com.tsukle.twitchchatbot.config.ProfileConfig;
import com.tsukle.twitchchatbot.handlers.CoreHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Serialize
{
    /**
     * Save the user config to a config.json file in the program data.
     * @param profileConfig - The profile config to serialize and save.
     */
    public static void saveConfig(ProfileConfig profileConfig)
    {
        try(Writer writer = new FileWriter(CoreHandler.getConfig().getBotDirectory() + "/config/config.json"))
        {
           Gson gson = new Gson();
           gson.toJson(profileConfig, writer);
        }
        catch(IOException e)
        {
           e.printStackTrace();
        }
    }
}
