package Panels;

import Helpers.SQLHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class MovieWatchersPanel extends JPanel implements ActionListener{


    private List<Map<String, Object>> movies;
    private JPanel resultPanel;

    public MovieWatchersPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JComboBox moviesSelector = new JComboBox();
        moviesSelector.setMaximumSize(new Dimension(175, 25));
        movies = SQLHelper.read("film");
        System.out.println(movies.size());
        moviesSelector.addItem("");

        for (Map<String, Object> row : movies)
            moviesSelector.addItem(row.get("Naam"));
        add(new JLabel("Hier word voor een geselecteerde film weergegeven hoe vaak deze tot 100% is bekeken (Als een film nooit tot 100% is bekeken staat deze niet in de lijst)"));
        add(new JLabel("Selecteer een Film:"));
        moviesSelector.addActionListener(this::actionPerformed);
        moviesSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(moviesSelector);
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        add(resultPanel);

    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        if (cb.getSelectedIndex() != 0) {
            Map<String, Object> selectedMovies = movies.get(cb.getSelectedIndex() - 1);
            List<Map<String, Object>> selectedEps = SQLHelper.executeQuery("SELECT Programma.Titel, Bekeken.Percentage, COUNT(Bekeken.Gezien) AS KerenBekeken\n" +
                    "FROM Programma\n" +
                    "JOIN Bekeken ON Bekeken.Gezien = Programma.ProgrammaID\n" +
                    "WHERE Bekeken.Percentage = + selectedMovies.get(\"ProgrammaID\") + " +
                    "GROUP BY Programma.Titel, Bekeken.Percentage;\n");

            resultPanel.removeAll();
            for (Map<String, Object> row : selectedEps)
                resultPanel.add(new JLabel("Volgnummer: " + row.get("ProgrammaID") + " Titel: " + row.get("Titel") + " Keren bekeken: " + row.get("KerenBekeken")));
            resultPanel.updateUI();
        }
    }
}
