package com.tsukle.twitchchatbot.handlers;

import com.tsukle.twitchchatbot.ui.config.CreateConfig;

import java.io.File;

public class ConfigHandler
{
    /**
     * Static so that it can be called without instantiating ConfigLoader.
     * Returns a new config file that is created using the CreateConfig panel.
     * @return - Returns a config file.
     */
    public static void createConfig()
    {
        CreateConfig createConfigPanel = new CreateConfig();
    }

    /**
     * Static so that it can be called without instantiating ConfigLoader.
     * Returns a config file if it exists or null if none exist.
     * @return - Null or a Config file.
     */
    public static File doesConfigExist()
    {
        File returnValue = null;

        File userProgramData = new File("C:/ProgramData/TsukleChatMachine/config");

        // Check if the directory exists.
        if(userProgramData.exists() && userProgramData.isDirectory())
        {
            File[] userConfig = userProgramData.listFiles();

            // Make sure it isn't an empty folder.
            if(userConfig.length != 0)
            {
                // Run through all files and make sure that the config.json file is returned.
                for (int i = 0; i < userConfig.length; i++)
                {
                    //Check if it is a valid file and check if the name is correct too.
                    if(userConfig[i].isFile() && userConfig[i].getName().equals("config.json"))
                    {
                        returnValue = userConfig[i];
                    }
                }
            }
        }

        return returnValue;
    }
}
