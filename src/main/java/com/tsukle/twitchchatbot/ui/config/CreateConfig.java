package com.tsukle.twitchchatbot.ui.config;

import com.tsukle.twitchchatbot.config.ProfileConfig;
import com.tsukle.twitchchatbot.serializing.Serialize;
import com.tsukle.twitchchatbot.handlers.CoreHandler;
import com.tsukle.twitchchatbot.ui.ColorPalette.ColorPalette;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateConfig extends JFrame
{
    private JPanel mPanelMain;
    private JPanel mPanelBotInfo;
    private JLabel mLabelUsernameTitle;
    private JTextField mTextFieldUsername;
    private JLabel mLabelPrivateKeyTitle;
    private JTextField mTextFieldPrivateKey;
    private JLabel mLabelChannelsTitle;
    private JTextField mTextFieldChannels;
    private JLabel mLabelCurrentChannels;
    private JLabel mLabelCurrentChannelsTitle;
    private JButton mButtonAddChannel;
    private JButton mButtonCreateConfig;
    private JButton mButtonDirectory;
    private JLabel mLabelDirectory;

    private List<String> listOfChannels;
    private String programDirectory;

    public CreateConfig()
    {
        // Default window setup.
        setTitle("ArrowChat - Config");
        setSize(500, 500);
        setLocationRelativeTo(CoreHandler.getCoreWindow());
        setResizable(false);
        mLabelCurrentChannelsTitle.setForeground(new Color(ColorPalette.textTitleAccent.getRGB()));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Make sure to keep this.
        setVisible(true);
        add(mPanelMain);
        revalidate();
        repaint();

        //Instanciate lists.
        listOfChannels = new ArrayList<>();
        programDirectory = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

        //Labels
        mLabelDirectory.setText("Current Directory: " + programDirectory);

        // Set listeners.
        addListeners();
    }

    /**
     * Add listeners to specified components.
     */
    private void addListeners()
    {
        mButtonAddChannel.addActionListener(e -> {
            // If no channel was specified.
            if(mTextFieldChannels.getText().equals(""))
            {
                showDialog("Warning", "Please enter a channel name.", true);
            }

            // If a channel was specified.
            else
            {
                listOfChannels.add(mTextFieldChannels.getText());
                String currentChannelsText = "";
                for (String channel : listOfChannels)
                {
                    if(currentChannelsText.equals(""))
                    {
                        currentChannelsText = channel;
                    }
                    else
                    {
                        currentChannelsText += ", " + channel;
                    }
                }
                mLabelCurrentChannels.setText(currentChannelsText);
                mTextFieldChannels.setText("");
            }
        });

        mButtonDirectory.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
            fileChooser.setDialogTitle("Choose a directory to save your file: ");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                if (fileChooser.getSelectedFile().isDirectory()) {
                    mLabelDirectory.setText("Current Directory: " + fileChooser.getSelectedFile().getName());
                }
            }

        });

        mButtonCreateConfig.addActionListener(e -> {
            if(mTextFieldUsername.getText().equals(""))
            {
                showDialog("Warning", "Please enter a username.", true);
            }
            else if(mTextFieldPrivateKey.getText().equals(""))
            {
                showDialog("Warning", "Please enter a privatekey.", true);
            }
            else if(listOfChannels.size() == 0)
            {
                showDialog("Warning", "Please add at least one channel to the channel list.", false);
            }
            else
            {
                ProfileConfig profileConfig = new ProfileConfig();

                profileConfig.setBotUsername(mTextFieldUsername.getText());
                profileConfig.setBotPrivateKey(mTextFieldPrivateKey.getText());
                profileConfig.setBotChannels(listOfChannels);
                profileConfig.setBotDirectory(programDirectory);

                CoreHandler.setConfig(profileConfig);
                Serialize.saveConfig(CoreHandler.getConfig());

                CoreHandler.getCoreWindow().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
    }

    private void showDialog(String title, String label, boolean isLabel)
    {
        JDialog jDialog = new JDialog(this, title, true);
        jDialog.setSize(250, 150);
        jDialog.setLocationRelativeTo(this);
        jDialog.setResizable(false);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLayout(new GridBagLayout());
        if(isLabel == true)
        {
            JLabel jLabel = new JLabel(label);
            jDialog.add(jLabel);
        }
        else
        {
            JTextArea jTextArea = new JTextArea(label);
            jTextArea.setLineWrap(true);
            jTextArea.setWrapStyleWord(true);
            jTextArea.setEditable(false);
            jTextArea.setBackground(new Color(0, 0, 0, 0));
            jTextArea.setSize(jDialog.getWidth() - 20, jDialog.getHeight() - 20);
            jDialog.add(jTextArea);
        }
        jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog.setVisible(true);
    }
}
