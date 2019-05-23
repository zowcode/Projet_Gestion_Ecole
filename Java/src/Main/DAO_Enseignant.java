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
public class DAO_Enseignant extends DAO<Enseignant>   
{

    public DAO_Enseignant(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Enseignant obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO enseignant (nom,prenom) VALUES(?,?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Enseignant obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM enseignant WHERE enseignant.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Enseignant obj) {
       try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE enseignant SET nom=?, prenom=? WHERE enseignant.id=?"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR);
            statement.setObject(3,obj.getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return true;
    }

    @Override
    public Enseignant find(int id) {
        Enseignant e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM enseignant WHERE enseignant.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Enseignant(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM enseignant");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
