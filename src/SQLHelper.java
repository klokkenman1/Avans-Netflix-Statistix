import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLHelper {
    private String connectionString;

    public SQLHelper(String connectionString){
        try {
            // 'Importeer' de driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            this.connectionString = connectionString;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Create(String table, Object... values){
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            // Stel een SQL query samen.
            StringBuilder SQL = new StringBuilder("INSERT INTO " + table + " VALUES (");
            for (int i = 0; i < values.length; i++)
            {
                if (i != values.length - 1)
                {
                    SQL.append("?, ");
                }
                else
                {
                    SQL.append("?)");
                }
            }
            stmt = connection.prepareStatement(SQL.toString());
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
            if (stmt != null) try { stmt.close(); } catch(Exception ignored) {}
            if (connection != null) try { connection.close(); } catch(Exception ignored) {}
        }
    }

    public List<Map<String, Object>>  Read(String table, Pair<String,Object>... cells){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> result = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            // Stel een SQL query samen.
            StringBuilder SQL = new StringBuilder("SELECT * FROM " + table + " WHERE");
            for (Pair cell : cells)
            {
                SQL.append(" ").append(cell.getKey()).append(" = ? AND");
            }
            SQL.delete(SQL.length()-3,SQL.length());

            stmt = connection.prepareStatement(SQL.toString());

            for (int i = 0; i < cells.length; i++)
            {
                stmt.setString(i + 1, cells[i].getValue().toString());
            }

            rs = stmt.executeQuery();
            result = resultSetToList(rs);
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception ignored) {}
            if (stmt != null) try { stmt.close(); } catch(Exception ignored) {}
            if (connection != null) try { connection.close(); } catch(Exception ignored) {}
        }
        return result;
    }

    private List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
}
