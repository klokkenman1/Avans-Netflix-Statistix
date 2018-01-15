import Helpers.SQLHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SeriesPanelTest {

    @Test
    void testSeriesPanelCanDisplaySeries(){
        Assertions.assertTrue(SQLHelper.read("Serie").size() > 0,"Make sure there are series in the database");
    }

}