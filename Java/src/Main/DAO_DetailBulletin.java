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
public class DAO_DetailBulletin extends DAO<DetailBulletin>{
    
    public DAO_DetailBulletin(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(DetailBulletin obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO detailbulletin (id,id_bulletin,id_enseignant) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.setObject(2,obj.getBulletin().getId(),Types.INTEGER); 
            statement.setObject(3,obj.getEnseignant().getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DetailBulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(DetailBulletin obj) {
        return false;
    }

    @Override
    public boolean update(DetailBulletin obj) {
         return false;
    }

    @Override
    public DetailBulletin find(int id) {
        return null;
    }
}
