package Panels;

import Helpers.SQLHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

//Op deze panel kan er een account worden gekozen er word dan weergegeven welke films er door dit account zijn bekeken
public class AccountMoviePanel extends JPanel implements ActionListener {

    private List<Map<String, Object>> accounts;
    private JPanel resultPanel;

    public AccountMoviePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JComboBox<Object> seriesSelector = new JComboBox<>();
        seriesSelector.setMaximumSize(new Dimension(175,25));

        accounts = SQLHelper.read("Account");
        seriesSelector.addItem("");
        for (Map<String, Object> row : accounts)
            seriesSelector.addItem(row.get("Naam"));

        add(new JLabel("Hier word voor een geselecteerde account aangegeven welke films er bekeken zijn"));
        add(new JLabel("Selecteer een account:"));
        seriesSelector.addActionListener(this);
        seriesSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(seriesSelector);
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        add(resultPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        if (cb.getSelectedIndex() != 0){
            Map<String, Object> selectedAccount = accounts.get(cb.getSelectedIndex() - 1);
            List<Map<String, Object>> result = SQLHelper.executeQuery("SELECT Programma.Titel\n" +
                    "FROM Bekeken\n" +
                    "JOIN Film ON Bekeken.Gezien = Film.FilmID\n" +
                    "JOIN Programma ON Film.FilmID = Programma.ProgrammaID\n" +
                    "WHERE Bekeken.Abonneenummer = " + selectedAccount.get("Abonneenummer") + ";");

            resultPanel.removeAll();
            for (Map<String, Object> row : result)
                resultPanel.add(new JLabel("Titel: " + row.get("Titel")));
            resultPanel.updateUI();
        }
    }
}
