/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Eleve;
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
public class DAO_Eleve extends DAO<Eleve>{

    public DAO_Eleve(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Eleve obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO eleve (nom,prenom) VALUES(?,?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Eleve obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM eleve WHERE eleve.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return true;
    }

    @Override
    public boolean update(Eleve obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE eleve SET nom=?, prenom=? WHERE eleve.id=?"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR);
            statement.setObject(3,obj.getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public Eleve find(int id) {
        Eleve e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM eleve WHERE eleve.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Eleve(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
    @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM eleve");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
    
}
