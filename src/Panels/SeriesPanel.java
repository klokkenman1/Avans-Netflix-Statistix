package Panels;

import Helpers.SQLHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class SeriesPanel extends JPanel implements ActionListener {

    private List<Map<String, Object>> series;

    public SeriesPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JComboBox seriesSelector = new JComboBox();
        seriesSelector.setSize(new Dimension(175,25));

        series = SQLHelper.read("Serie");
        System.out.println(series.size());
        seriesSelector.addItem("");
        for (Map<String, Object> row : series)
            seriesSelector.addItem(row.get("Naam"));

        seriesSelector.addActionListener(this);

        add(seriesSelector);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        if (cb.getSelectedIndex() != 0){
            Map<String, Object> selectedSeries = series.get(cb.getSelectedIndex() - 1);
            List<Map<String, Object>> selectedEps = SQLHelper.executeQuery("SELECT Programma.ProgrammaID, Programma.Titel, AVG(Bekeken.Percentage) AS AvgPerc\n" +
                    "FROM Bekeken\n" +
                    "JOIN Aflevering ON Bekeken.Gezien = Aflevering.AfleveringID\n" +
                    "JOIN Programma ON Aflevering.AfleveringID = Programma.ProgrammaID\n" +
                    "WHERE Aflevering.Serie = " + selectedSeries.get("SerieID") + "\n" +
                    "GROUP BY Programma.ProgrammaID, Programma.Titel;");

            for (Map<String, Object> row : selectedEps)
                add(new JLabel("Volgnummer: " + row.get("ProgrammaID") + " Titel: " + row.get("Titel") + " Gemiddeld bekeken % van tijdsduur: " + row.get("AvgPerc") + "%"));
        }
    }
}
