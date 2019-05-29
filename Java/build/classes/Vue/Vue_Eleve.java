/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO_Package.DAO;
import DAO_Package.DAOFactory;
import Modele.Annee;
import Modele.CurrentUser;
import Modele.DataManager;
import Modele.Eleve;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author arnau
 */
public class Vue_Eleve extends Vue_Generale implements TreeSelectionListener{
    private Eleve eleve;

    public Vue_Eleve(DataManager db,CurrentUser user) {
        super(db,user,"Eleve");
        String[] racine = {"Mes bulletins","Mes cours","Ma classe"};
        tree = new JTree(racine);
        BandeauVertical.add(tree, BorderLayout.NORTH);
        tree.addTreeSelectionListener(this);
        eleve = db.getEleves().get(user.getId());
    }

    @Override
    public void valueChanged(TreeSelectionEvent event) {
       Object obj = tree.getLastSelectedPathComponent();
       if(obj.toString().equals("Mes bulletins"))
       {
           
       }
       
       if(obj.toString().equals("Mes cours"))
       {
           
       }
       
       if(obj.toString().equals("Ma classe"))
       {   
           Classe_Panel classe_panel = new Classe_Panel(eleve.getClasse());
           MainContent.add(classe_panel,BorderLayout.CENTER);
           this.revalidate();
       }
    }
    
}
