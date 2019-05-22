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
public class DAO_Discipline extends DAO<Discipline>{
    
    public DAO_Discipline(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Discipline obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO discipline (nom) VALUES(?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR);  
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Discipline.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Discipline obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM discipline WHERE discipline.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Discipline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Discipline obj) {
         return false;
    }

    @Override
    public Discipline find(int id) {
        return null;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM discipline");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Discipline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
