/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.lang.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sebas
 */
public class DAOFactory {
    
    protected static final Connection conn;   
   
    static{
        Connection tmp = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            tmp = DriverManager.getConnection("jdbc:mysql://localhost/ecole","root","root");
         }catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
         }catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
        conn = tmp;
    }
    
 
  /**
  * Retourne un objet Professeur interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Enseignant(){
    return new DAO_Enseignant(conn);
  }

  /**
  * Retourne un objet Annee interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Annee(){
    return new DAO_Annee(conn);
  }
  
  /**
  * Retourne un objet Buleltin interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Bulletin(){
    return new DAO_Bulletin(conn);
  }
  
  /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Classe(){
    return new DAO_Classe(conn);
  }
  
  /**
  * Retourne un objet DetailBulletin interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_DetailBulletin(){
    return new DAO_DetailBulletin(conn);
  }
  
  /**
  * Retourne un objet Discipline interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Discipline(){
    return new DAO_Discipline(conn);
  }
  
  /**
  * Retourne un objet Eleve interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Eleve(){
    return new DAO_Eleve(conn);
  }
  
  /**
  * Retourne un objet Enseignement interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Enseignement(){
    return new DAO_Enseignement(conn);
  }
  
  /**
  * Retourne un objet Evaluation interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Evaluation(){
    return new DAO_Evaluation(conn);
  }
  
  /**
  * Retourne un objet Inscription interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Inscription(){
    return new DAO_Inscription(conn);
  }
  
  /**
  * Retourne un objet Niveau interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Niveau(){
    return new DAO_Niveau(conn);
  }
  
  /**
  * Retourne un objet Trimestre interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Trimestre(){
    return new DAO_Trimestre(conn);
  }
  
    
}
