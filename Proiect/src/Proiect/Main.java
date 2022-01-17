package Proiect;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        FirstPage primapagina = new FirstPage();
        Connection conn= ConnectionDB.CreateConnection();
        try {
            Statement st = conn.createStatement();
           /* String query = "  CREATE TABLE [User]("
                    + " [Nume] VARCHAR (30),"
                    + " [Varsta] int,"
                    + " [Inaltime] numeric(30,20),"
                    + " [Greutate] numeric(30,20),"
                    + " [Greutate Dorita] numeric(30,20))";*/
           // st.execute(query);
            //String Query=" INSERT INTO [User] ([Nume],[Varsta],[Inaltime],[Greutate],[Greutate Dorita]) VALUES('Ionut',19,180,80,75) ";
            //st.execute(Query);
                    //String InsertQuery="INSERT INTO "+c.Name+" ([open], [high], [low], [close], [volume], [hlc3], [openTime], [closeTime]) "
            //                    + "VALUES ";
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
