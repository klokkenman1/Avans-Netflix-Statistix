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
        JComboBox seriesSelector = new JComboBox();
        seriesSelector.setPreferredSize(new Dimension(175,25));

        series = SQLHelper.read("Serie");
        System.out.println(series.size());
        for (Map<String, Object> row : series)
            seriesSelector.addItem(row.get("Naam"));

        seriesSelector.addActionListener(this);

        add(seriesSelector);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        Map<String, Object> selectedSeries = series.get(cb.getSelectedIndex());
    }
}
