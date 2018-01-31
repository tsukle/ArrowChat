package com.tsukle.twitchchatbot.ui.lookandfeel.lookandfeels;

import com.tsukle.twitchchatbot.ui.lookandfeel.BaseLookAndFeel;
import com.tsukle.twitchchatbot.ui.lookandfeel.containers.BaseContainer;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class DarkLookAndFeel extends BaseLookAndFeel
{
    public DarkLookAndFeel(BaseContainer container)
    {
        super(container);
    }

    @Override
    public ColorUIResource setControl()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setInfo()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setText()
    {
        return new ColorUIResource(new Color(46, 216, 178));
    }

    @Override
    public ColorUIResource setNimbusAlertYellow()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusBase()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusDisabledText()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusFocus()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusGreen()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusInfoBlue()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusLightBackground()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusOrange()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusRed()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusSelectedText()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusSelectionBackground()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusBlueGrey()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusBorder()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }

    @Override
    public ColorUIResource setNimbusSelection()
    {
        return new ColorUIResource(new Color(40, 40, 40));
    }
}
