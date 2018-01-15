package Panels;

import Helpers.SQLHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class CRUDPanel extends JPanel implements ActionListener {

    private String tableName;
    private List<Map<String, Object>> table;
    private JComboBox deleteSelector;
    private JPanel resultPanel;

    public CRUDPanel(String tableName){
        this.tableName = tableName;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        deleteSelector = new JComboBox();
        deleteSelector.setMaximumSize(new Dimension(175,25));
        deleteSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        deleteSelector.addItem("");

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));

        table = SQLHelper.read(tableName);
        for (Map<String, Object> row : table) {
            resultPanel.add(new JLabel(row.toString()));
            deleteSelector.addItem(row.get("Naam"));
        }

        add(new JLabel("Hier worden alle " + tableName + "'s weergegeven"));
        add(new JLabel("Selecteer een " + tableName + " en druk op delete om het te verwijderen"));
        add(deleteSelector);
        add(deleteButton);
        add(resultPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (deleteSelector.getSelectedIndex() != 0){
            Map<String, Object> selectedAccount = table.get(deleteSelector.getSelectedIndex() - 1);
            SQLHelper.delete(tableName, selectedAccount);

            deleteSelector.removeAll();
            resultPanel.removeAll();

            deleteSelector.addItem("");
            table = SQLHelper.read(tableName);
            for (Map<String, Object> row : table) {
                resultPanel.add(new JLabel(row.toString()));
                deleteSelector.addItem(row);
            }

            resultPanel.updateUI();
            deleteSelector.updateUI();

        }
    }
}
