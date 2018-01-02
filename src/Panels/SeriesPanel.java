/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author TB
 */
public class SeriesPanel extends JPanel {
    //Creating all the "locked" labels
    private JLabel Title = new JLabel("Title:");
    private JLabel Duration = new JLabel("Duration:");
    
    //Creating all the "Variable" labels
    public static JLabel SLabel = new JLabel();
    
    public SeriesPanel() {
        setLayout(new GridLayout(0, 2));
        add(Title);
        add(SLabel);
        add(Duration);
    }    
}
