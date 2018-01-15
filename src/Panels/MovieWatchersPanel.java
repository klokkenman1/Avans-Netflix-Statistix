package Panels;

import Helpers.SQLHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

//Op deze panel kan er een film worden gekozen en er word dan weergegeven hoe vaak deze 100% is bekeken
public class MovieWatchersPanel extends JPanel implements ActionListener{

    private List<Map<String, Object>> movies;
    private JPanel resultPanel;

    public MovieWatchersPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JComboBox<Object> moviesSelector = new JComboBox<>();
        moviesSelector.setMaximumSize(new Dimension(175, 25));
        movies = SQLHelper.executeQuery("SELECT *\n" +
                "FROM Film\n" +
                "JOIN Programma on Film.FilmID = Programma.ProgrammaID");

        moviesSelector.addItem("");
        for (Map<String, Object> row : movies)
            moviesSelector.addItem(row.get("Titel"));

        add(new JLabel("Selecteer een film en er word weergegeven hoe vaak deze tot 100% is bekeken"));
        add(new JLabel("Selecteer een Film:"));

        moviesSelector.addActionListener(this);
        moviesSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(moviesSelector);
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        add(resultPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        if (cb.getSelectedIndex() != 0) {
            Map<String, Object> selectedMovies = movies.get(cb.getSelectedIndex() - 1);
            List<Map<String, Object>> selectedEps = SQLHelper.executeQuery("SELECT COUNT(*) AS CountWatched\n" +
                    "FROM Film\n" +
                    "JOIN Bekeken ON Bekeken.Gezien = Film.FilmID\n" +
                    "WHERE Film.FilmID = " + selectedMovies.get("FilmID") + " AND Bekeken.Percentage = 100");

            resultPanel.removeAll();
            for (Map<String, Object> row : selectedEps)
                resultPanel.add(new JLabel("Aantal keer 100% bekeken: " + row.get("CountWatched")));
            resultPanel.updateUI();
        }
    }
}
