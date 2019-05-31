
package Vue;

import Modele.Classe;
import Modele.Discipline;
import Modele.Enseignant;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arnau
 */
public class Cours_Panel extends JPanel{

    public Cours_Panel(Classe classe) {
        this.setLayout(new BoxLayout(this,Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        for(Discipline d : classe.getDisciplines())
        {
            this.add(new JLabel(d.getNom()));
        }
    }
    
    public Cours_Panel(Enseignant enseignant)
    {
        this.setLayout(new BoxLayout(this,Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        for(Discipline d : enseignant.getDisciplines())
        {
            this.add(new JLabel(d.getNom()));
        }
    }
    
    
}
