import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLHelper {
    private Connection connection;

    public SQLHelper(String connectionString){
        try {
            // Import the driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Set the connectionstring.
            this.connection = DriverManager.getConnection(connectionString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(String table, Object... values){
        PreparedStatement stmt = null;
        try {
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
        }
    }

    public final List<Map<String, Object>> read(String table, Map<String, Object> cells){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> result = null;
        try {
            // Stel een SQL query samen.
            StringBuilder SQL = new StringBuilder("SELECT * FROM " + table + " WHERE");
            for (int i  = 0; i < cells.size(); i++)
            {
                SQL.append(" ").append(cells.keySet().toArray()[i]).append(" = ? AND");
            }
            SQL.delete(SQL.length()-3,SQL.length());

            stmt = connection.prepareStatement(SQL.toString());

            for (int i = 0; i < cells.size(); i++)
            {
                stmt.setString(i + 1, cells.values().toArray()[i].toString());
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
        }
        return result;
    }

    public void update(String table, Pair<String, Object> changedCell, Map<String, Object> cells){
        PreparedStatement stmt = null;
        try {
            // Stel een SQL query samen.
            StringBuilder SQL = new StringBuilder("UPDATE " + table + " SET " + changedCell.getKey() + " = ? WHERE ");
            for (int i = 0; i < cells.size(); i++) {
                SQL.append(cells.keySet().toArray()[i] + " = ?");
                if (i != cells.size() - 1) {
                    SQL.append(" AND ");
                }
            }
            stmt = connection.prepareStatement(SQL.toString());

            stmt.setString(1, changedCell.getValue().toString());

            for (int i = 0; i < cells.size(); i++)
            {
                stmt.setString(i + 2, cells.values().toArray()[i].toString());
            }

            stmt.executeUpdate();

        }catch (Exception e){e.printStackTrace();}
    }

    public void delete(String table, Map<String,Object> cells){
        PreparedStatement stmt = null;

        try {
            StringBuilder SQL = new StringBuilder("DELETE FROM " + table + " WHERE ");
            for (int i = 0; i < cells.size(); i++)
            {
                if (i != cells.size() - 1)
                {
                    SQL.append(cells.keySet().toArray()[i]).append(" = ? AND ");
                }
                else
                {
                    SQL.append(cells.keySet().toArray()[i]).append(" = ?");
                }
            }

            stmt = connection.prepareStatement(SQL.toString());


            for (int i = 0; i < cells.size(); i++)
            {
                stmt.setString(i + 1, cells.values().toArray()[i].toString());
            }

            stmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception ignored) {}
        }
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

    public void closeConnection()
    {
        try{
            connection.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
