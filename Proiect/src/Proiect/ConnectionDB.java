package Proiect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    ConnectionDB() {
        CreateConnection();
    }

    public static Connection CreateConnection() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://bd2021.database.windows.net;databaseName=ioannahoidb;";

        String user = "ioannahoiuser";
        String password = "LPFavbMP7C##B6D";
        try {
            Connection conn = DriverManager.getConnection(url,
                    user, password);
            return conn;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
