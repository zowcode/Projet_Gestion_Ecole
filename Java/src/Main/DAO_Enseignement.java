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
 * @author arnaud
 */
public class DAO_Enseignement extends DAO<Enseignement>{
    
    public DAO_Enseignement(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Enseignement obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO enseignement (id,id_classe,id_enseignant,id_discipline) VALUES(?,?,?,?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.setObject(2,obj.getClasse().getId(),Types.INTEGER); 
            statement.setObject(3,obj.getEnseignant().getId(),Types.INTEGER);
            statement.setObject(4,obj.getDiscipline().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignement.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Enseignement obj) {
        return false;
    }

    @Override
    public boolean update(Enseignement obj) {
         return false;
    }

    @Override
    public Enseignement find(int id) {
        return null;
    }
}
