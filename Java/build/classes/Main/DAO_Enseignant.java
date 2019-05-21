/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arnau
 */
public class DAO_Enseignant extends DAO<Enseignant>   
{

    public DAO_Enseignant(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Enseignant obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO enseignant (nom,prenom) VALUES(?,?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Enseignant obj) {
        return false;
    }

    @Override
    public boolean update(Enseignant obj) {
        return false;
    }

    @Override
    public Enseignant find(int id) {
        return null;
    }
    
}
