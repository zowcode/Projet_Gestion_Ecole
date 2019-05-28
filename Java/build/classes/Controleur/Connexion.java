package Controleur;

import DAO_Package.DAOFactory;
import Modele.CurrentUser;
import Vue.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arnaud
 */
public class Connexion {
        protected static final Connection conn; 
        
   
    static{
        Connection tmp = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            tmp = DriverManager.getConnection("jdbc:mysql://localhost/connexion","root","root");
         }catch (ClassNotFoundException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
         }catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
         }
        conn = tmp;
    }

    public Connexion() {
    }
    
    
    
    public static void Create_Frame(String email,String password) throws SQLException {
        
        CurrentUser u = Connect(email,password);
        System.out.println(u.getType());
        switch(u.getType())
        {
            case 0:
                Vue_Eleve el = new Vue_Eleve(u);
                //fermer la fenetre actuelle
                break;
            case 1:
                Vue_Enseignant en = new Vue_Enseignant(u);
                break;
            case 2:
                Vue_Admin ad = new Vue_Admin(u);
                break;
            default :
                
                break;
                
        }
    }
    
    public static CurrentUser Connect(String email,String password) throws SQLException
    {
        String email_modif = "\'"+email+"\'";
        PreparedStatement statement = Connexion.conn.prepareStatement(
                   "SELECT * FROM user WHERE user.email = "+email_modif
                    );
        ResultSet rs = statement.executeQuery();
            if(rs.first())
            {
                System.out.println("rs");
                if(rs.getString("email").equals(email) && rs.getString("password").equals(password))
                {
                    return new CurrentUser(email,rs.getInt("type"),rs.getString("nom"),rs.getString("prenom"));
                }
            }
        return null;
    }
}
