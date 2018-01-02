package Panels;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountMoviePanel extends JPanel {

    //Creating all the "locked" labels
    String sql = "select profielnaam from profile";
    private JLabel Account = new JLabel("Account Name:");
    private JLabel Account2 = new JLabel(sql);
    private JLabel Test = new JLabel("RandomInfo:");

    //Creating all the "Variable" labels
    public static JLabel ALabel = new JLabel();

    public void Account2() throws ClassNotFoundException {

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "root", "");
            String sql = "select profielnaam from profiel";
            System.out.println("Connected to Database");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String profielnaam = result.getString(1);
                System.out.println(profielnaam);
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public AccountMoviePanel() {
        add(Account);

        add(Account2);

        add(ALabel);

        add(Test);

    }
}
