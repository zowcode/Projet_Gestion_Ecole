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
public class Vue_Enseignant extends Vue_Generale implements TreeSelectionListener{

    public Vue_Enseignant(DataManager db,CurrentUser user) {
        super(db,user,"Enseignant");
        String[] racine = {"Mes cours","Mes classe","Ajouter Bulletins"};
        tree = new JTree(racine);
        BandeauVertical.add(tree, BorderLayout.NORTH);
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent event) {
       Object obj = tree.getLastSelectedPathComponent();
       if(obj.equals("Mes cours"))
       {
           
       }
       
       if(obj.equals("Mes classes"))
       {
           
       }
       
       if(obj.equals("Ajouter Bulletin"))
       {
           
       }
    }
    
}
