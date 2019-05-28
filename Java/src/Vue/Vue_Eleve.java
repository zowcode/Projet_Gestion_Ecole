/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.CurrentUser;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author arnau
 */
public class Vue_Eleve extends JFrame{
    private final CurrentUser user;

    public Vue_Eleve(CurrentUser user) {
        super("Espace Eleve");
        this.user = user;
        int height = 600;
        int width = 800;
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
    
}
