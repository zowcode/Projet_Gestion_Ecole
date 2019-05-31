/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO_Package.DAO;
import DAO_Package.DAOFactory;
import Modele.Annee;
import Modele.Bulletin;
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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author arnau
 */
public class Vue_Eleve extends Vue_Generale implements TreeSelectionListener{
    private Eleve eleve;

    public Vue_Eleve(DataManager db,CurrentUser user) {
        super(db,user,"Eleve");
        eleve = db.getEleves().get(user.getId());
        //String[] racine = {"Mes bulletins","Mes cours","Ma classe"};
        //tree = new JTree(racine);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(eleve.getPrenom()+" "+eleve.getNom());
        DefaultMutableTreeNode blts = new DefaultMutableTreeNode("Mes Bulletins");
        DefaultMutableTreeNode cls = new DefaultMutableTreeNode("Ma Classe");
        DefaultMutableTreeNode crs = new DefaultMutableTreeNode("Mes Cours");
        int i=0;
        for(Bulletin b : eleve.getBulletins())
        {
            
            String s = i+".Trimestre " + b.getTrimestre().getNumero()+ " de " +b.getTrimestre().getAnnee().getAnnee();
            blts.add(new DefaultMutableTreeNode(s));
            i++;
        }
        root.add(blts);
        root.add(cls);
        root.add(crs);
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
           MainContent.add(new Cours_Panel(eleve.getClasse()),BorderLayout.CENTER);
       }
       
       if(obj.toString().equals("Ma Classe"))
       {   
           MainContent.add(new Classe_Panel(eleve.getClasse()),BorderLayout.CENTER);
       }
       
       char char_id = tree.getLastSelectedPathComponent().toString().charAt(0);
       int int_id = Character.getNumericValue(char_id);
       for(int i = 0;i<eleve.getBulletins().size();i++)
       {
           if(int_id == i)
           {
               MainContent.add(new Bulletin_Panel(eleve.getBulletins().get(i)));
           }
       }
       
       this.revalidate();
    }
    
}
