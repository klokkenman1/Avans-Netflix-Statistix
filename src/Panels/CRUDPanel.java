package Panels;

import Helpers.SQLHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class CRUDPanel extends JPanel {

    private String tableName;
    private List<Map<String, Object>> table;
    private JComboBox<Object> deleteSelector;
    private JPanel resultPanel;

    CRUDPanel(String tableName){
        this.tableName = tableName;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        deleteSelector = new JComboBox<>();
        deleteSelector.setMaximumSize(new Dimension(175,25));
        deleteSelector.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener());

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new UpdateListener());

        JButton createButton = new JButton("Create");
        createButton.addActionListener(new CreateListener());

        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));

        refreshData();

        add(new JLabel("Hier worden alle " + tableName + "'s weergegeven"));
        add(new JLabel("Selecteer een " + tableName + " en druk op delete om het te verwijderen of op update om het te veranderen of maak een nieuwe aan met create"));
        add(deleteSelector);
        add(deleteButton);
        add(updateButton);
        add(createButton);
        add(resultPanel);
    }

    class CreateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            resultPanel.removeAll();
            CRUDFormPanel form = new CRUDFormPanel(tableName);
            resultPanel.add(form);
            resultPanel.updateUI();
        }
    }

    class UpdateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (deleteSelector.getSelectedIndex() != 0) {
                resultPanel.removeAll();
                CRUDFormPanel form = new CRUDFormPanel(tableName, table.get(deleteSelector.getSelectedIndex() - 1));
                resultPanel.add(form);
                resultPanel.updateUI();
            }
        }
    }

    class DeleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (deleteSelector.getSelectedIndex() != 0){
                Map<String, Object> selectedAccount = table.get(deleteSelector.getSelectedIndex() - 1);
                SQLHelper.delete(tableName, selectedAccount);
                refreshData();
            }
        }
    }

    void refreshData(){
        deleteSelector.removeAllItems();
        resultPanel.removeAll();

        deleteSelector.addItem("");
        table = SQLHelper.read(tableName);
        for (Map<String, Object> row : table) {
            resultPanel.add(new JLabel(row.toString()));
            if (Objects.equals(tableName, "Account"))
                deleteSelector.addItem(row.get("Naam"));
            else if (Objects.equals(tableName, "Profiel"))
                deleteSelector.addItem( row.get("Abonneenummer") + " " + row.get("Naam"));
            else if (Objects.equals(tableName, "Bekeken"))
                deleteSelector.addItem(row.get("Abonneenummer") + " " + row.get("Naam") + " " + row.get("Gezien"));
        }

        resultPanel.updateUI();
        deleteSelector.updateUI();
    }
}
