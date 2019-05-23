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
public class DAO_Classe extends DAO<Classe>{
    
    
    public DAO_Classe(Connection conn) {
        super(conn);
    }
     
    @Override
    public boolean create(Classe obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO classe (nom,id_niveau,id_annee) VALUES(?,?,?)"
                    ); 
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getNiveau().getId(),Types.INTEGER);
            statement.setObject(3,obj.getAnnee().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Classe obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM classe WHERE classe.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Classe obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE classe SET nom=?,id_niveau=?,id_annee=? WHERE classe.id=?"
                    ); 
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getNiveau().getId(),Types.INTEGER);
            statement.setObject(3,obj.getAnnee().getId(),Types.INTEGER); 
            statement.setObject(4,obj.getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return true;
    }

    @Override
    public Classe find(int id) {
        Classe e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM classe WHERE classe.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Classe(rs.getInt("id"),rs.getString("nom"));
                DAO_Niveau nivDAO = new DAO_Niveau(this.connect);
                DAO_Annee anDAO = new DAO_Annee(this.connect);
                e.setNiveau(nivDAO.find(rs.getInt("id_niveau")));
                e.setAnnee(anDAO.find(rs.getInt("id_annee")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM classe");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
