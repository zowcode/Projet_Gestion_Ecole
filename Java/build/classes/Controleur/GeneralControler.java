package Controleur;

import Modele.CurrentUser;
import Vue.Vue_Connexion;
import javax.swing.JFrame;

/**
 *
 * @author arnaud
 */
public class GeneralControler {
    private CurrentUser user ;
    private JFrame fenetre;

    public GeneralControler(CurrentUser user,JFrame fenetre) {
        this.user = user;
        this.fenetre = fenetre;
    }
    
    public static void main(String[] args) { 
        
    }
    
}
