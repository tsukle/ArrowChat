package com.tsukle.twitchchatbot.ui.genericcomponents;

import com.tsukle.twitchchatbot.handlers.CoreHandler;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;

public class DirectoryChoiceDialog extends JFrame {
    private JPanel mPanelMain;
    private JPanel mPanelContents;
    private JLabel mLabelTitle;
    private JPanel mPanelTitle;
    private JPanel mPanelChooseFile;
    private JButton mButtonChooseFile;
    private JLabel mLabelDirectory;
    private JButton mButtonDone;

    public DirectoryChoiceDialog() {
        // Default window setup.
        setTitle("ArrowChat - Choose File");
        setSize(500, 500);
        setLocationRelativeTo(CoreHandler.getCoreWindow());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Make sure to keep this.
        setVisible(true);
        add(mPanelMain);
        revalidate();
        repaint();

        addListeners();
    }

    private void addListeners()
    {
        mButtonChooseFile.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
            fileChooser.setDialogTitle("Choose a directory to save your file: ");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                if (fileChooser.getSelectedFile().isDirectory()) {
                    mLabelDirectory.setText("Current Directory: " + fileChooser.getSelectedFile());
                }
            }

        });
    }
}
