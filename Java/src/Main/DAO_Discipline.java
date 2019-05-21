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
public class DAO_Discipline extends DAO<Discipline>{
    
    public DAO_Discipline(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Discipline obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO discipline (id,nom) VALUES(?,?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.setObject(2,obj.getNom(),Types.VARCHAR);  
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Discipline.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Discipline obj) {
        return false;
    }

    @Override
    public boolean update(Discipline obj) {
         return false;
    }

    @Override
    public Discipline find(int id) {
        return null;
    }
}
