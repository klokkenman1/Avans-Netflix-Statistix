import Helpers.SQLHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountSeriesPanelTest {

    @Test
    void testAccountSeriesPanelCanDisplayAccounts(){
        Assertions.assertTrue(SQLHelper.read("Account").size() > 0,"Make sure there are accounts in the database");
    }

    @Test
    void testAccountSeriesPanelCanDisplaySeries(){
        Assertions.assertTrue(SQLHelper.read("Serie").size() > 0,"Make sure there are series in the database");
    }
}