package com.tsukle.twitchchatbot.serializing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tsukle.twitchchatbot.config.ProfileConfig;
import com.tsukle.twitchchatbot.handlers.CoreHandler;

import java.io.File;
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
        File file = new File(CoreHandler.getProgramDirectory() + "/config");

        if(!file.exists())
        {
            file.mkdirs();
        }

        try(Writer writer = new FileWriter(CoreHandler.getProgramDirectory() + "/config/config.json"))
        {
            Gson gson = new GsonBuilder().create();
            gson.toJson(profileConfig, writer);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
