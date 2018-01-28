package com.tsukle.twitchchatbot.connection;

import java.util.List;

public interface ChatListener
{
    void chatUpdated(String message, List<String> userInfo, boolean serverMessage);
}
