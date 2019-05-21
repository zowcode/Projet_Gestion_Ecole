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
public class DAO_Evaluation extends DAO<Evaluation>{
    
    public DAO_Evaluation(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Evaluation obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO evaluation (note,appreciation,id_detail_bulletin) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getNote(),Types.INTEGER); 
            statement.setObject(2,obj.getAppreciation(),Types.VARCHAR);
            statement.setObject(3,obj.getDetail_bulletin().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Evaluation obj) {
        return false;
    }

    @Override
    public boolean update(Evaluation obj) {
         return false;
    }

    @Override
    public Evaluation find(int id) {
        return null;
    }
}
