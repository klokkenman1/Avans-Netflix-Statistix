package Panels;

import Helpers.SQLHelper;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class AccountPanel extends JPanel {

    public AccountPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        List<Map<String, Object>> result=  SQLHelper.executeQuery("SELECT Account.*\n" +
                "FROM Account JOIN Profiel ON Account.Abonneenummer = Profiel.Abonneenummer \n" +
                "GROUP BY Account.Abonneenummer, Account.Naam, Account.Straat, Account.Huisnummer, Account.Plaats, Account.Postcode\n" +
                "HAVING COUNT(Account.Abonneenummer) = 1;");
        add(new JLabel("Hier staat alle accounts met 1 profiel"));
        for (Map<String, Object> row : result)
            add(new JLabel(row.get("Naam").toString()));
        System.out.println(result);
        // op deze pagina worden alle accounts weergegeven met maar 1 profiel
    }

}
