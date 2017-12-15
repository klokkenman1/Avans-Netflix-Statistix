import javax.swing.SwingUtilities;

public class Main {

    public static SQLHelper helper;

    public static void main(String[] args) {
        helper = new SQLHelper("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Test;integratedSecurity=true;");
        helper.Create("Persoon","Fay", "Snepvangers");
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}
