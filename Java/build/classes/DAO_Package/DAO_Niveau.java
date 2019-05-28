/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Package;

import Modele.Niveau;
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
public class DAO_Niveau extends DAO<Niveau>{
    
    public DAO_Niveau(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Niveau obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO niveau (nom) VALUES(?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Niveau.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Niveau obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM niveau WHERE niveau.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Niveau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Niveau obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE niveau SET nom=? WHERE niveau.id=?"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getNom(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Niveau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public Niveau find(int id) {
        Niveau e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM niveau WHERE niveau.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Niveau(rs.getInt("id"),rs.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Niveau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM niveau");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Niveau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
