package Main;

import java.sql.*;

/**
 *
 * @author arnaud
 */
public class Connexion {
    
    
    
        public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;

        //crÃ©ation d'une connexion JDBC Ã  la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // crÃ©ation d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }
}
