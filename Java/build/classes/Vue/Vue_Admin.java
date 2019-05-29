/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.CurrentUser;
import Modele.DataManager;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author arnau
 */
public class Vue_Admin extends Vue_Generale implements TreeSelectionListener{


    public Vue_Admin(DataManager db,CurrentUser user) {
        super(db,user,"Admin");
        String[] racine = {"Editer Eleve","Editer Enseignant"};
        tree = new JTree(racine);
        BandeauVertical.add(tree, BorderLayout.NORTH);
        tree.addTreeSelectionListener(this);
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent event) {
       Object obj = tree.getLastSelectedPathComponent();
       if(obj.equals("Editer Eleve"))
       {
           
       }
       
       if(obj.equals("Editer Enseignant"))
       {
           
       }
    }
    
}
