import javafx.util.Pair;

import javax.swing.SwingUtilities;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static SQLHelper helper;

    public static void main(String[] args) {
        helper = new SQLHelper("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Test;integratedSecurity=true;");

        HashMap where = new HashMap();
        where.put("Voornaam","Kelvin");
        where.put("Achternaam","Snepvangers");

        helper.create("Persoon", "Collin", "Snevangers");
        System.out.println(helper.read("Persoon",where));

        helper.update("Persoon", new Pair<>("Achternaam","Snepvanger"), where);
        System.out.println(helper.read("Persoon",where));

        helper.delete("Persoon", where);
        System.out.println(helper.read("Persoon",where));

        //UserInterface ui = new UserInterface();
        //SwingUtilities.invokeLater(ui);
    }
}
