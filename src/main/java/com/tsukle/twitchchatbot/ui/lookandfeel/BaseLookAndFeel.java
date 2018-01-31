package com.tsukle.twitchchatbot.ui.lookandfeel;

import com.tsukle.twitchchatbot.ui.lookandfeel.containers.BaseContainer;

import javax.swing.plaf.ColorUIResource;

public abstract class BaseLookAndFeel
{
    private BaseContainer mColorContainer;

    public BaseLookAndFeel(BaseContainer container)
    {
        mColorContainer = container;
    }

    public abstract ColorUIResource setControl();

    public abstract ColorUIResource setInfo();
    public abstract ColorUIResource setText();
    public abstract ColorUIResource setNimbusAlertYellow();

    public abstract ColorUIResource setNimbusBase();
    public abstract ColorUIResource setNimbusDisabledText();
    public abstract ColorUIResource setNimbusFocus();
    public abstract ColorUIResource setNimbusGreen();
    public abstract ColorUIResource setNimbusInfoBlue();
    public abstract ColorUIResource setNimbusLightBackground();
    public abstract ColorUIResource setNimbusOrange();
    public abstract ColorUIResource setNimbusRed();
    public abstract ColorUIResource setNimbusSelectedText();
    public abstract ColorUIResource setNimbusSelectionBackground();
    public abstract ColorUIResource setNimbusBlueGrey();
    public abstract ColorUIResource setNimbusBorder();
    public abstract ColorUIResource setNimbusSelection();


    // This may be used in the future but I am not too sure what else I need yet.

    /*public abstract ColorUIResource setActiveCaption();
    public abstract ColorUIResource setBackground();
    public abstract ColorUIResource setControlDarkShadow();
    public abstract ColorUIResource setControlHighlight();
    public abstract ColorUIResource setControlLightHighlight();
    public abstract ColorUIResource setControlShadow();
    public abstract ColorUIResource setControlText();
    public abstract ColorUIResource setDesktop();
    public abstract ColorUIResource setInactiveCaption();
    public abstract ColorUIResource setInfoText();
    public abstract ColorUIResource setMenu();
    public abstract ColorUIResource setMenuText();
    public abstract ColorUIResource setScrollbar();*/

    /**
     * Returns the colour container that is attached to this look and feel.
     * @return - The colour container that is attached to this look and feel.
     */
    public BaseContainer getColorContainer()
    {
        return mColorContainer;
    }
}
