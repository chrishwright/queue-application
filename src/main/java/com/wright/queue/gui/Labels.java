package com.wright.queue.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * 
 * @author christopherwright
 *
 */
public class Labels {
    
    private static List<JLabel> jLabels = new ArrayList<>();
    private static final int NUM_LABELS = 5;
    
    private Labels() {}
    
    static {
        List<JLabel> labelsTemp = new ArrayList<>();
        
        for (int i = 0; i < NUM_LABELS; i++) {
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            
            JLabel tempLabel = new JLabel();
            tempLabel.setBorder(border);
            tempLabel.setPreferredSize(new Dimension(50,50));
            tempLabel.setHorizontalAlignment(JLabel.CENTER);
            
            labelsTemp.add(tempLabel);
        }
        
        jLabels = labelsTemp;
    }
    
    protected static List<JLabel> getLabels() {
        return jLabels;
    }
    
}
