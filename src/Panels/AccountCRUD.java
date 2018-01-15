package Panels;

import Helpers.SQLHelper;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AccountCRUD extends JFrame{

    JTextField naamInput;
    JTextField straatInput;
    JTextField postcodeInput;
    JTextField huisnummerInput;
    JTextField plaatsInput;

    public AccountCRUD() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JTextField naamInput = new JTextField(10);
        JTextField straatInput = new JTextField(10);
        JTextField postcodeInput = new JTextField(10);
        JTextField huisnummerInput = new JTextField(10);
        JTextField plaatsInput = new JTextField(10);

        JButton adder = new JButton("Add");
        JButton editer = new JButton("Edit");
        JButton deleter = new JButton("Delete");

        adder.addActionListener(new adderHandler());
        editer.addActionListener(new editerHandler());
        deleter.addActionListener(new deleterHandler());

        add(naamInput);
        add(straatInput);
        add(postcodeInput);
        add(huisnummerInput);
        add(plaatsInput);

        add(adder);
        add(editer);
        add(deleter);
    }

    private class adderHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = naamInput.getText() + " " + straatInput.getText() + " " + postcodeInput.getText() + " " + huisnummerInput.getText() + " " + plaatsInput.getText();

            SQLHelper.create(inputText);
        }
    }

    private class editerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String inputText = input.getText();

            Pair<String, Object> stringObjectPair = null;
            Map<String, Object> stringObjectMap = null;
            SQLHelper.update(inputText, stringObjectPair, stringObjectMap);
        }
    }

    private class deleterHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String inputText = input.getText();

            Map<String, Object> stringObjectMap = null;
            SQLHelper.delete(inputText, stringObjectMap);
        }
    }
}
