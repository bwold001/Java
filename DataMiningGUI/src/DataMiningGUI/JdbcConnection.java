package DataMiningGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnection {

    public static void main(String[] args) throws SQLException {
        Connection conn = GetConnection();
        if (conn != null) {
            System.out.println("Connected to the database!!!");
        }
        ResultSet SelectFromTable = SelectFromTable(conn);
    }

    protected static Connection GetConnection() {
        try {
            // connect method #1 - embedded driver
            String dbURL1 = "jdbc:derby://localhost:1527/data mining;create=true;user=username;password=password";
            Connection conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                // System.out.println("Connected to database #1");
                return conn1;
            }

            // connect method #2 - network client driver
            String dbURL2 = "jdbc:derby://localhost:1527/data mining;";
            String user = "USERNAME";
            String password = "password";
            Connection conn2 = DriverManager.getConnection(dbURL2, user, password);
            if (conn2 != null) {
                //System.out.println("Connected to database #2");
                return conn2;
            }

            // connect method #3 - network client driver
            String dbURL3 = "jdbc:derby://localhost/data mining";
            Properties properties = new Properties();
            properties.put("create", "true");
            properties.put("user", "username");
            properties.put("password", "password");

            Connection conn3 = DriverManager.getConnection(dbURL3, properties);
            if (conn3 != null) {
                // System.out.println("Connected to database #3");
                return conn3;
            }

        } catch (SQLException ex) {
        }
        return null;
    }

    protected static ResultSet SelectFromTable(Connection conn1) throws SQLException {
        Statement m_Statement = conn1.createStatement();

        String query = "SELECT * FROM PATIENT WHERE ptname LIKE '%jane%' ";

        ResultSet m_ResultSet = m_Statement.executeQuery(query);

        while (m_ResultSet.next()) {
            System.out.println(m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
                    + m_ResultSet.getString(3));

        }
        return m_ResultSet;
    }
}
