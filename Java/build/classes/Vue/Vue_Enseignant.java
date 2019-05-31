/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Bulletin;
import Modele.Classe;
import Modele.CurrentUser;
import Modele.DataManager;
import Modele.Enseignant;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author arnau
 */
public class Vue_Enseignant extends Vue_Generale implements TreeSelectionListener{

    private Enseignant enseignant;
    
    public Vue_Enseignant(DataManager db,CurrentUser user) {
        super(db,user,"Enseignant");
        enseignant = db.getEnseignants().get(user.getId());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(enseignant.getPrenom()+" "+enseignant.getNom());
        DefaultMutableTreeNode crs = new DefaultMutableTreeNode("Mes Cours");
        DefaultMutableTreeNode cls = new DefaultMutableTreeNode("Mes Classes");
        DefaultMutableTreeNode eval = new DefaultMutableTreeNode("Ajouter une evaluation");
        int i=0;
        for(Classe c : enseignant.getClasses())
        {
            
            String s = i+". "+c.getNom()+" "+c.getNiveau().getNom();
            cls.add(new DefaultMutableTreeNode(s));
            i++;
        }
        root.add(crs);
        root.add(cls);
        root.add(eval);
        DefaultTreeModel model = new DefaultTreeModel(root);
        add(tree=new JTree(model));
        BandeauVertical.add(tree, BorderLayout.NORTH);
        tree.addTreeSelectionListener(this);
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent event) {
       Object obj = tree.getLastSelectedPathComponent();
       if(obj.toString().equals("Mes Cours"))
       {
           System.out.println("cours");
           MainContent.add(new Cours_Panel(enseignant));
       }
       
       if(obj.toString().equals("Ajouter une evaluation"))
       {
           
       }
       
       char char_id = tree.getLastSelectedPathComponent().toString().charAt(0);
       int int_id = Character.getNumericValue(char_id);
       for(int i = 0;i<enseignant.getClasses().size();i++)
       {
           if(int_id == i)
           {
               MainContent.add(new Classe_Panel(enseignant.getClasses().get(i)));
           }
       }
       this.revalidate();
    }
    
}
