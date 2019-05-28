/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.CurrentUser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author arnau
 */
public class Vue_Eleve extends Vue_Generale{


    public Vue_Eleve(CurrentUser user) {
        super(user,"Eleve");
    }
    
}
