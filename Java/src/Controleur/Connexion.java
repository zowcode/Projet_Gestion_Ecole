package Controleur;

import DAO_Package.DAOFactory;
import Modele.CurrentUser;
import Vue.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public static void main(String[] args) throws SQLException {
        String email = null,password=null;
        //récupération email et password
        CurrentUser u = Connect(email,password);
        switch(u.getType())
        {
            case 0:
                EleveControler el = new EleveControler(u,new Vue_Eleve(u));
                //fermer la fenetre actuelle
                break;
            case 1:
                EnseignantControler en = new EnseignantControler(u,new Vue_Enseignant(u));
                break;
            case 2:
                AdminControler ad = new AdminControler(u,new Vue_Admin(u));
                break;
            default :
                //mauvais email/mdp à gérer
                break;
                
        }
    }
    
    public static CurrentUser Connect(String email,String password) throws SQLException
    {
        PreparedStatement statement = Connexion.conn.prepareStatement(
                    "SELECT * FROM user WHERE user.email="+email
                    );
            ResultSet rs = statement.executeQuery();
            if(rs.first())
            {
                if(rs.getString("email").equals(email) && rs.getString("password").equals(password))
                {
                    return new CurrentUser(email,rs.getInt("type"),rs.getString("nom"),rs.getString("prenom"));
                }
            }
        return null;
    }
}
