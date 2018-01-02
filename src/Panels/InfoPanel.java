package Panels;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public InfoPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 25));
        JLabel title = new JLabel("Netflix Statistix");
        JLabel info = new JLabel("Informatica 2017/2018 Klas:F Kelvin Snepvangers, Wilco Trimborn");
        add(title, BorderLayout.WEST);
        add(info, BorderLayout.EAST);
    }
}
