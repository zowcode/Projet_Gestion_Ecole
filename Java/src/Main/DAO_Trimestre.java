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
public class DAO_Trimestre extends DAO<Trimestre>{
    
    public DAO_Trimestre(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Trimestre obj) {
                try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO trimestre (numero,debut,fin,id_annee) VALUES(?,?,?,?)"
                    );
            statement.setObject(1,obj.getNumero(),Types.INTEGER);
            statement.setObject(2,obj.getDebut(), Types.INTEGER); 
            statement.setObject(3,obj.getFin(),Types.INTEGER); 
            statement.setObject(4,obj.getAnnee().getId(), Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
        
    }

    @Override
    public boolean delete(Trimestre obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM trimestre WHERE trimestre.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Trimestre obj) {
         return false;
    }

    @Override
    public Trimestre find(int id) {
        Trimestre e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM trimestre WHERE trimestre.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Trimestre(rs.getInt("id"),rs.getInt("numero"),rs.getInt("debut"),rs.getInt("fin"));
                DAO_Annee anDAO = new DAO_Annee(this.connect);
                e.setAnnee(anDAO.find(rs.getInt("id_annee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM trimestre");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
