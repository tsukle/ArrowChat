package com.tsukle.twitchchatbot.serializing;

import com.google.gson.Gson;
import com.tsukle.twitchchatbot.config.ProfileConfig;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Serialize
{
    public static void saveConfig(ProfileConfig profileConfig)
    {
        try(Writer writer = new FileWriter("C:/ProgramData/TsukleChatMachine/config/config.json"))
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
