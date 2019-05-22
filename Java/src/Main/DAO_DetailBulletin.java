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
public class DAO_DetailBulletin extends DAO<DetailBulletin>{
    
    public DAO_DetailBulletin(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(DetailBulletin obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO detailbulletin (id_bulletin,id_enseignant) VALUES(?,?)"
                    ); 
            statement.setObject(1,obj.getBulletin().getId(),Types.INTEGER); 
            statement.setObject(2,obj.getEnseignant().getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DetailBulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(DetailBulletin obj) {
                try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM detailbulletin WHERE detailbulletin.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DetailBulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(DetailBulletin obj) {
         return false;
    }

    @Override
    public DetailBulletin find(int id) {
        return null;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM detailbulletin");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DetailBulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
