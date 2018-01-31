package com.tsukle.twitchchatbot.ui.lookandfeel;

import javax.swing.*;

public class LookAndFeelHandler
{
    public LookAndFeelHandler()
    {
        // Empty Constructor.
    }

    public static void setTheme(BaseLookAndFeel lookAndFeel)
    {
        // Set the basic colours of the theme to be installed later on.

        UIManager.put("control", lookAndFeel.setControl());
        UIManager.put("info", lookAndFeel.setInfo());
        UIManager.put("nimbusAlertYellow", lookAndFeel.setNimbusAlertYellow());
        UIManager.put("nimbusBase", lookAndFeel.setNimbusBase());
        UIManager.put("nimbusDisabledText", lookAndFeel.setNimbusDisabledText());
        UIManager.put("nimbusFocus", lookAndFeel.setNimbusFocus());
        UIManager.put("nimbusGreen", lookAndFeel.setNimbusGreen());
        UIManager.put("nimbusInfoBlue", lookAndFeel.setNimbusInfoBlue());
        UIManager.put("nimbusLightBackground", lookAndFeel.setNimbusLightBackground());
        UIManager.put("nimbusOrange", lookAndFeel.setNimbusOrange());
        UIManager.put("nimbusRed", lookAndFeel.setNimbusRed());
        UIManager.put("nimbusSelectedText", lookAndFeel.setNimbusSelectedText());
        UIManager.put("nimbusSelectionBackground", lookAndFeel.setNimbusSelectionBackground());
        UIManager.put("text", lookAndFeel.setText());

        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
        {
            if("Nimbus".equals(info.getName()))
            {
                try
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }

       /* UIManager.put("activeCaption", lookAndFeel.);
        UIManager.put("background", lookAndFeel.);
        UIManager.put("controlDkShadow", lookAndFeel.);
        UIManager.put("controlHighlight", lookAndFeel.);
        UIManager.put("controlLHighlight", lookAndFeel.);
        UIManager.put("controlShadow", lookAndFeel.);
        UIManager.put("controlText", lookAndFeel.);
        UIManager.put("desktop", lookAndFeel.);
        UIManager.put("inactiveCaption", lookAndFeel.);
        UIManager.put("infoText", lookAndFeel.);
        UIManager.put("menu", lookAndFeel.);
        UIManager.put("menuText", lookAndFeel.);
        UIManager.put("nimbusBlueGrey", lookAndFeel.);
        UIManager.put("nimbusBorder", lookAndFeel.);
        UIManager.put("nimbusSelection", lookAndFeel.);
        UIManager.put("scrollbar", lookAndFeel.);
        UIManager.put("textBackground", lookAndFeel.);
        UIManager.put("textForeground", lookAndFeel.);
        UIManager.put("textHighlight", lookAndFeel.);
        UIManager.put("textHighlightText", lookAndFeel.);
        UIManager.put("textInactiveText", lookAndFeel.);*/

    }
}
