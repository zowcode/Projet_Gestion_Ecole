package Vue;

import Modele.Classe;
import Modele.Eleve;
import Modele.Enseignant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arnaud
 */
public class MaClasse_Panel extends JPanel{
    private Classe classe;

    public MaClasse_Panel(Classe classe) {
        this.classe = classe;
        this.setLayout(new BoxLayout(this,Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JLabel intitule = new JLabel(classe.getNom() + " " + classe.getNiveau().getNom()+ " " + classe.getAnnee().getAnnee());
        this.add(intitule);

        JLabel profs = new JLabel("Liste des professeurs :");
        this.add(profs);
        for(Enseignant e : classe.getEnseignants())
        {
            this.add(new JLabel("         "+e.getPrenom()+" "+e.getNom()));
        }
        
        JLabel eleves = new JLabel("Liste des élèves :");
        this.add(eleves);
        for(Eleve e : classe.getEleves())
        {
            this.add(new JLabel("         "+e.getPrenom()+" "+e.getNom()));
        }
    }
    
    
}
