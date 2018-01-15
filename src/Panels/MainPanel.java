package Panels;

import Helpers.SQLHelper;
import javafx.util.Pair;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

//The main panel of our program
public class MainPanel extends JPanel {
    
    public MainPanel() {
        //Setting the layout of the panel to a BorderLayout
        setLayout(new BorderLayout());
        //Setting the preferred size for our window
        setPreferredSize(new Dimension(1280, 720));

        //Create tabs for different data views
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("CRUD Account", new CRUDPanel("Account"));
        tabs.addTab("CRUD Profile", new CRUDPanel("Profiel"));
        tabs.addTab("CRUD Watched", new CRUDPanel("Bekeken"));
        tabs.addTab("Series information", new SeriesPanel());
        tabs.addTab("Profile series information", new AccountSeriesPanel());
        tabs.addTab("Account movie information", new AccountMoviePanel());
        tabs.addTab("Movie information", new MoviePanel());
        tabs.addTab("Account information", new AccountPanel());
        tabs.addTab("Movie watchers information", new MovieWatchersPanel());
        //Allows the user to scroll if the panel is to small for the screen
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


        add(tabs);
        add(new Panels.InfoPanel(), BorderLayout.SOUTH);
    }
}
