package Controleur;

import Modele.CurrentUser;
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
    
    
}
