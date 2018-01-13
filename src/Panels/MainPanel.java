package Panels;

import Helpers.SQLHelper;
import javafx.util.Pair;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;


public class MainPanel extends JPanel {
    
    public MainPanel() {
        //Setting the layout of the panel to a BorderLayout
        setLayout(new BorderLayout());
        //Setting the preferred size for our window
        setPreferredSize(new Dimension(1280, 720));

        //Create tabs for different data views
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Series information", new SeriesPanel());
        tabs.addTab("Profile Series information", new AccountSeriesPanel());
        tabs.addTab("Account Movie information", new AccountPanel());
        tabs.addTab("Movie information", new MoviePanel());
        //Allows the user to scroll if the panel is to small for the screen
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


        add(tabs);
        add(new Panels.InfoPanel(), BorderLayout.SOUTH);

// Sample code to work with the database
//        HashMap where = new HashMap();
//        where.put("Voornaam","Kelvin");
//        where.put("Achternaam","Snepvangers");
//
//        SQLHelper.create("Persoon", "Kelvin", "Snepvangers");
//        System.out.println(SQLHelper.read("Persoon",where));
//
//        SQLHelper.update("Persoon", new Pair<>("Achternaam","Snepvanger"), where);
//        System.out.println(SQLHelper.read("Persoon",where));
//
//        SQLHelper.delete("Persoon", where);
//        System.out.println(SQLHelper.read("Persoon",where));
    }
}
