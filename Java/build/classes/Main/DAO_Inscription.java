/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arnau
 */
public class DAO_Inscription extends DAO<Inscription>{
    
    public DAO_Inscription(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Inscription obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO inscription (id_eleve,id_classe) VALUES(?,?)"
                    );
            statement.setObject(1,obj.getEleve().getId(),Types.INTEGER); 
            statement.setObject(2,obj.getClasse().getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Inscription obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM inscription WHERE inscription.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Inscription obj) {
         return false;
    }

    @Override
    public Inscription find(int id) {
        return null;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM inscription");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
