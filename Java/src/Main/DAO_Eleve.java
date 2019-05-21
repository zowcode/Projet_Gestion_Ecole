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
public class DAO_Eleve extends DAO<Eleve>{

    public DAO_Eleve(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Eleve obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO eleve (id,nom,prenom) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.setObject(2,obj.getNom(),Types.VARCHAR); 
            statement.setObject(3,obj.getPrenom(),Types.VARCHAR); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Eleve obj) {
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
         return false;
    }

    @Override
    public Eleve find(int id) {
        return null;
    }
    
}
