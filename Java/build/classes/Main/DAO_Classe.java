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
public class DAO_Classe extends DAO<Classe>{
    
    
    public DAO_Classe(Connection conn) {
        super(conn);
    }
     
    @Override
    public boolean create(Classe obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO classe (nom,id_niveau,id_annee) VALUES(?,?,?)"
                    ); 
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getNiveau().getId(),Types.INTEGER);
            statement.setObject(3,obj.getAnnee().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Classe obj) {
        return false;
    }

    @Override
    public boolean update(Classe obj) {
         return false;
    }

    @Override
    public Classe find(int id) {
        return null;
    }
}
