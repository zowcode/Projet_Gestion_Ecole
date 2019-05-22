/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arnau
 */
public class DAO_Annee extends DAO<Annee>{
      
    public DAO_Annee(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Annee obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO anneescolaire (id) VALUES(?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Annee obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM anneescolaire WHERE anneescolaire.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Annee obj) {
         return false;
    }

    @Override
    public Annee find(int id) {
        return null;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM anneescolaire");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
