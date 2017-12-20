import javafx.util.Pair;

import javax.swing.SwingUtilities;
import java.sql.ResultSet;

public class Main {

    private static SQLHelper helper;

    public static void main(String[] args) {
        helper = new SQLHelper("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Test;integratedSecurity=true;");
        helper.Create("Persoon","Kelvin", "Snepvangers");
        System.out.println(helper.Read("Persoon",new Pair("Achternaam","Snepvangers")));

        //UserInterface ui = new UserInterface();
        //SwingUtilities.invokeLater(ui);
    }
}
