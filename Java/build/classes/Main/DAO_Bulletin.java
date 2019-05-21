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
public class DAO_Bulletin extends DAO<Bulletin> {
    
    public DAO_Bulletin(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Bulletin obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO bulletin (appreciation,id_inscription,id_trimestre) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getAppreciation(),Types.VARCHAR); 
            statement.setObject(2,obj.getInscription().getId(),Types.INTEGER);
            statement.setObject(3,obj.getTrimestre().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Bulletin obj) {
        return false;
    }

    @Override
    public boolean update(Bulletin obj) {
         return false;
    }

    @Override
    public Bulletin find(int id) {
        return null;
    }
}
