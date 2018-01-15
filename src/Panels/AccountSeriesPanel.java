package Panels;

import Helpers.SQLHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Map;
import javax.swing.*;

//In dit panel word voor een geselecteerde account en serie per aflevering het gemiddeld bekeken % van de tijdsduur weergegeven
public class AccountSeriesPanel extends JPanel {

    private List<Map<String, Object>> accounts;
    private List<Map<String, Object>> series;
    private JPanel resultPanel;
    Map<String, Object> selectedAccount;
    Map<String, Object> selectedSerie;

    public AccountSeriesPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        JComboBox accountSelector = new JComboBox();
        accountSelector.setMaximumSize(new Dimension(175,25));
        accountSelector.addActionListener(new AccountListener());
        accountSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        accounts = SQLHelper.read("Account");
        accountSelector.addItem("");
        for (Map<String, Object> row : accounts)
            accountSelector.addItem(row.get("Naam"));

        JComboBox serieSelector = new JComboBox();
        serieSelector.setMaximumSize(new Dimension(175,25));
        serieSelector.addActionListener(new SerieListener());
        serieSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        series = SQLHelper.read("Serie");
        serieSelector.addItem("");
        for (Map<String, Object> row : series)
            serieSelector.addItem(row.get("Naam"));


        add(new JLabel("Hier word voor een geselecteerde account en serie per aflevering het gemiddeld bekeken % van de tijdsduur weergegeven (Als een aflevering nooit is bekeken staat deze niet in de lijst)"));
        add(new JLabel("Selecteer een Account en Serie:"));

        add(accountSelector);
        add(serieSelector);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        add(resultPanel);
    }

    class AccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            if (cb.getSelectedIndex() != 0){
                selectedAccount = accounts.get(cb.getSelectedIndex() - 1);
                if (selectedSerie != null)
                    fillResult();
            }
        }
    }

    class SerieListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            if (cb.getSelectedIndex() != 0){
                selectedSerie = series.get(cb.getSelectedIndex() - 1);
                if (selectedAccount != null)
                    fillResult();
            }
        }
    }

    private void fillResult(){
        List<Map<String, Object>> avgWatched = SQLHelper.executeQuery("SELECT Programma.ProgrammaID, Programma.Titel, AVG(Bekeken.Percentage) AS AvgPerc\n" +
                "FROM Bekeken\n" +
                "JOIN Aflevering ON Bekeken.Gezien = Aflevering.AfleveringID\n" +
                "JOIN Programma ON Aflevering.AfleveringID = Programma.ProgrammaID\n" +
                "WHERE Aflevering.Serie = " + selectedSerie.get("SerieID") + " AND Bekeken.Abonneenummer = " + selectedAccount.get("Abonneenummer") + "\n" +
                "GROUP BY Programma.ProgrammaID, Programma.Titel;");
        resultPanel.removeAll();
        for (Map<String, Object> row : avgWatched)
            resultPanel.add(new JLabel("Volgnummer: " + row.get("ProgrammaID") + " Titel: " + row.get("Titel") + " Gemiddeld bekeken % van tijdsduur: " + row.get("AvgPerc") + "%"));
        resultPanel.updateUI();
    }

}
