package Panels;

import javax.swing.*;
import java.awt.*;

//A panel with our projectgroup information
public class InfoPanel extends JPanel {
    public InfoPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 25));
        JLabel title = new JLabel("Netflix Statistix");
        JLabel info = new JLabel("Informatica 2017/2018 Klas:F Kelvin Snepvangers, Wilco Trimborn, Levi Snijders");
        add(title, BorderLayout.WEST);
        add(info, BorderLayout.EAST);
    }
}
