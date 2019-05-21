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
public class DAO_Trimestre extends DAO<Trimestre>{
    
    public DAO_Trimestre(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Trimestre obj) {
                try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO trimestre (id,numero,debut,fin,id_annee) VALUES(?,?,?,?,?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.setObject(2,obj.getNumero(),Types.INTEGER);
            statement.setObject(3,obj.getDebut(), Types.INTEGER); 
            statement.setObject(4,obj.getFin(),Types.INTEGER); 
            statement.setObject(5,obj.getAnnee().getId(), Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
        
    }

    @Override
    public boolean delete(Trimestre obj) {
        return false;
    }

    @Override
    public boolean update(Trimestre obj) {
         return false;
    }

    @Override
    public Trimestre find(int id) {
        return null;
    }
}
