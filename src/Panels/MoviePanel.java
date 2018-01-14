package Panels;

import Helpers.SQLHelper;

import javax.swing.*;
import java.util.List;
import java.util.Map;

// Op deze pagina zie je de film met de langste tijdsduur met een leeftijdsindicatie onder de 16
public class MoviePanel extends JPanel{
    public MoviePanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        List<Map<String, Object>> result=  SQLHelper.executeQuery(
                "SELECT TOP 1 Programma.Titel,Tijdsduur\n" +
                        "FROM Programma JOIN Film ON Film.FilmID = Programma.ProgrammaID\n" +
                        "WHERE Leeftijdsindicatie < 16\n" +
                        "ORDER BY Tijdsduur DESC;");
        add(new JLabel("Hier staat de langste film voor onder de 16"));
        for (Map<String, Object> row : result)
            add(new JLabel(row.get("Titel").toString()+"  " + row.get("Tijdsduur") ));
    }
}
