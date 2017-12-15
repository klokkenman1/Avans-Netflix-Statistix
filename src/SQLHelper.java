import java.sql.*;

import static java.lang.System.in;

public class SQLHelper {
    private static Connection connection;

    public SQLHelper(String connectionString){
        try {
            // 'Importeer' de driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            connection = DriverManager.getConnection(connectionString);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Create(String table, Object... values){
        PreparedStatement stmt = null;
        try {
            // Stel een SQL query samen.
            String SQL = "INSERT INTO " + table + " VALUES (";
            for (int i = 0; i < values.length; i++)
            {
                if (i != values.length - 1)
                {
                    SQL += "?, ";
                }
                else
                {
                    SQL += "?)";
                }
            }
            stmt = connection.prepareStatement(SQL);;
            for (int i = 0; i < values.length; i++)
            {
                stmt.setString(i + 1, values[i].toString());
            }

            // Voer de query uit op de database.
            stmt.executeUpdate();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }

    public ResultSet Read(String table){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Stel een SQL query samen.
            String SQL = "SELECT * FROM " + table;
            stmt = connection.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
        return rs;
    }
}
