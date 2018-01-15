package Panels;

import Helpers.SQLHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class CRUDFormPanel extends JPanel{

    private String tableName;
    private List<List<Map<String, Object>>> foreignTables = new ArrayList<>();
    private List<JComboBox<Object>> foreignSelectors = new ArrayList<>();
    private List<JTextField> inputs = new ArrayList<>();

    //TODO add validation to all fields
    public CRUDFormPanel(String tableName) {
        this.tableName = tableName;
        setLayout(new GridLayout(0,2));

        JButton createButton = new JButton("Create");
        JButton exitButton = new JButton("Exit");


        if (Objects.equals(tableName, "Account")){
            add(new JLabel("Naam:"));
            inputs.add(new JTextField());
            add(inputs.get(0));
            add(new JLabel("Straat:"));
            inputs.add(new JTextField());
            add(inputs.get(1));
            add(new JLabel("Postcode (6 chars):"));
            inputs.add(new JTextField());
            add(inputs.get(2));
            add(new JLabel("Huisnummer:"));
            inputs.add(new JTextField());
            add(inputs.get(3));
            add(new JLabel("Plaats:"));
            inputs.add(new JTextField());
            add(inputs.get(4));
        }
        else if (Objects.equals(tableName, "Profiel")){
            add(new JLabel("Account:"));
            foreignTables.add(SQLHelper.read("Account"));
            foreignSelectors.add(new JComboBox<>());
            for (Map<String, Object> row : foreignTables.get(0))
                foreignSelectors.get(0).addItem(row.get("Naam"));
            add(foreignSelectors.get(0));

            add(new JLabel("Naam:"));
            inputs.add(new JTextField());
            add(inputs.get(0));

            add(new JLabel("Geboortedatum (yyyy-mm-dd):"));
            inputs.add(new JTextField());
            add(inputs.get(1));
        }
        else if (Objects.equals(tableName, "Bekeken")){
            add(new JLabel("Profiel:"));
            foreignTables.add(SQLHelper.read("Profiel"));
            foreignSelectors.add(new JComboBox<>());
            for (Map<String, Object> row : foreignTables.get(0))
                foreignSelectors.get(0).addItem(row.get("Naam"));
            add(foreignSelectors.get(0));

            add(new JLabel("Programma:"));
            foreignTables.add(SQLHelper.read("Programma"));
            foreignSelectors.add(new JComboBox<>());
            for (Map<String, Object> row : foreignTables.get(1))
                foreignSelectors.get(1).addItem(row.get("Titel"));
            add(foreignSelectors.get(1));

            add(new JLabel("Percentage:"));
            inputs.add(new JTextField(10));
            add(inputs.get(0));
        }

        createButton.addActionListener(new CreateHandler());
        add(createButton);
        exitButton.addActionListener(new ExitHandler());
        add(exitButton);
    }

    public CRUDFormPanel(String tableName, Map<String,Object> curentRow) {
        this.tableName = tableName;
        setLayout(new GridLayout(0,2));

        JButton actionButton = new JButton("Update");
        JButton exitButton = new JButton("Exit");

        if (Objects.equals(tableName, "Account")){
            add(new JLabel("Naam:"));
            inputs.add(new JTextField(curentRow.get("Naam").toString()));
            add(inputs.get(0));
            add(new JLabel("Straat:"));
            inputs.add(new JTextField(curentRow.get("Straat").toString()));
            add(inputs.get(1));
            add(new JLabel("Postcode (6 chars):"));
            inputs.add(new JTextField(curentRow.get("Postcode").toString()));
            add(inputs.get(2));
            add(new JLabel("Huisnummer:"));
            inputs.add(new JTextField(curentRow.get("Huisnummer").toString()));
            add(inputs.get(3));
            add(new JLabel("Plaats:"));
            inputs.add(new JTextField(curentRow.get("Plaats").toString()));
            add(inputs.get(4));
        }
        else if (Objects.equals(tableName, "Profiel")){
            add(new JLabel("Account:"));
            foreignTables.add(SQLHelper.read("Account"));
            foreignSelectors.add(new JComboBox<>());
            for (Map<String, Object> row : foreignTables.get(0)){
                foreignSelectors.get(0).addItem(row.get("Naam"));
                if (row.get("Abonneenummer").equals(curentRow.get("Abonneenummer")))
                    foreignSelectors.get(0).setSelectedIndex(foreignSelectors.get(0).getItemCount() - 1);
            }
            add(foreignSelectors.get(0));

            add(new JLabel("Naam:"));
            inputs.add(new JTextField(curentRow.get("Naam").toString()));
            add(inputs.get(0));

            add(new JLabel("Geboortedatum (yyyy-mm-dd):"));
            inputs.add(new JTextField(curentRow.get("Geboortedatum").toString()));
            add(inputs.get(1));
        }
        else if (Objects.equals(tableName, "Bekeken")){
            add(new JLabel("Profiel:"));
            foreignTables.add(SQLHelper.read("Profiel"));
            foreignSelectors.add(new JComboBox<>());
            for (Map<String, Object> row : foreignTables.get(0)){
                foreignSelectors.get(0).addItem(row.get("Naam"));
                if (row.get("Abonneenummer").equals(curentRow.get("Abonneenummer")) && row.get("Naam").equals(curentRow.get("Naam")))
                    foreignSelectors.get(0).setSelectedIndex(foreignSelectors.get(0).getItemCount() - 1);
            }
            add(foreignSelectors.get(0));


            add(new JLabel("Programma:"));
            foreignTables.add(SQLHelper.read("Programma"));
            foreignSelectors.add(new JComboBox<>());
            for (Map<String, Object> row : foreignTables.get(1)){
                foreignSelectors.get(1).addItem(row.get("Titel"));
                if (row.get("ProgrammaID") ==  curentRow.get("Gezien"))
                    foreignSelectors.get(1).setSelectedIndex(foreignSelectors.get(1).getItemCount() - 1);
            }
            add(foreignSelectors.get(1));

            add(new JLabel("Percentage:"));
            inputs.add(new JTextField(curentRow.get("Percentage").toString()));
            add(inputs.get(0));
        }


        actionButton.addActionListener(new UpdateHandler(curentRow));
        add(actionButton);
        exitButton.addActionListener(new ExitHandler());
        add(exitButton);
    }

    private class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ((CRUDPanel)getParent().getParent()).refreshData();
        }
    }

    private class CreateHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] values = null;
            int offset = 0;

            if (Objects.equals(tableName, "Account"))
                values = new Object[inputs.size()];
            else if (Objects.equals(tableName, "Profiel")){
                values = new Object[inputs.size() + 1];
                values[0] = foreignTables.get(0).get(foreignSelectors.get(0).getSelectedIndex()).get("Abonneenummer");
                offset = 1;
            }
            else if (Objects.equals(tableName, "Bekeken")){
                values = new Object[inputs.size() + 3];
                values[0] = foreignTables.get(0).get(foreignSelectors.get(0).getSelectedIndex()).get("Abonneenummer");
                values[1] = foreignTables.get(0).get(foreignSelectors.get(0).getSelectedIndex()).get("Naam");
                values[2] = foreignTables.get(1).get(foreignSelectors.get(1).getSelectedIndex()).get("ProgrammaID");
                offset = 3;
            }

            for (int i = 0;i < inputs.size(); i++) {
                assert values != null;
                values[i + offset] = inputs.get(i).getText();
            }

            SQLHelper.create(tableName, values);
            ((CRUDPanel)getParent().getParent()).refreshData();
        }
    }

    private class UpdateHandler implements ActionListener {
        private Map<String, Object> row;
        public UpdateHandler(Map<String, Object> row) {
            this.row = row;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Map<String, Object> changed = new HashMap<>(row);
            if (Objects.equals(tableName, "Account")){
                changed.put("Naam", inputs.get(0).getText());
                changed.put("Straat", inputs.get(1).getText());
                changed.put("Postcode", inputs.get(2).getText());
                changed.put("Huisnummer", inputs.get(3).getText());
                changed.put("Plaats", inputs.get(4).getText());
            }
            else if (Objects.equals(tableName, "Profiel")){
                changed.put("Abonneenummer", foreignTables.get(0).get(foreignSelectors.get(0).getSelectedIndex()).get("Abonneenummer"));
                changed.put("Naam", inputs.get(0).getText());
                changed.put("Geboortedatum", inputs.get(1).getText());
            }
            else if (Objects.equals(tableName, "Bekeken")){
                changed.put("Abonneenummer", foreignTables.get(0).get(foreignSelectors.get(0).getSelectedIndex()).get("Abonneenummer"));
                changed.put("Naam", foreignTables.get(0).get(foreignSelectors.get(0).getSelectedIndex()).get("Naam"));
                changed.put("Gezien", foreignTables.get(1).get(foreignSelectors.get(1).getSelectedIndex()).get("ProgrammaID"));
                changed.put("Percentage", inputs.get(0).getText());
            }


            SQLHelper.update(tableName, changed, row);
            ((CRUDPanel)getParent().getParent()).refreshData();

        }
    }
}
