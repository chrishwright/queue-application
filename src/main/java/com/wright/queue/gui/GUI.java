package com.wright.queue.gui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

public class GUI {
    
    private static final Logger MS_LOG = Logger.getLogger(GUI.class.getName());
    
    private JFrame mainFrame;
    private JButton button1;
    private JButton button2;
    
    public void init() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeGUI();
            }
        });
    }
    
    private void initializeGUI() {
        MS_LOG.info("Initializing GUI...");
        
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            MS_LOG.error(e.getMessage());
        }
        
        mainFrame = new JFrame("Undo Application");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initializeButtons();
        addComponentsToFrame(mainFrame.getContentPane());
        
        mainFrame.setVisible(true);
    }
    
    private void addComponentsToFrame(Container pane) {
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(5, 5, 5, 5);
        c.ipady = 200;
        c.ipadx = 50;
        c.gridheight = 2;
        
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button1, c);
        
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button2, c);
    }
    
    private void initializeButtons() {
        button1 = new JButton("Create");
        button2 = new JButton("Process");
        
        mainFrame.add(button1);
        mainFrame.add(button2);
        
        button1.addActionListener(e -> {
            MS_LOG.info("Button1 clicked...");
        });
        
        button2.addActionListener(e -> {
            MS_LOG.info("Button2 clicked...");
        });
    }

}
