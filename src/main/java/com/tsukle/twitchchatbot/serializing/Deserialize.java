package com.tsukle.twitchchatbot.serializing;

import com.google.gson.Gson;
import com.tsukle.twitchchatbot.config.ProfileConfig;
import com.tsukle.twitchchatbot.handlers.CoreHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Deserialize
{
    /**
     * Sets the core config given the config json file.
     * @param configFile - Config file.
     */
    public static void loadConfig(File configFile)
    {
        try
        {
            Gson gson = new Gson();
            ProfileConfig profileConfig = gson.fromJson(new FileReader(configFile.getPath()), ProfileConfig.class);
            CoreHandler.setConfig(profileConfig);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
