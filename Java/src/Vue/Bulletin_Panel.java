package Vue;

import Modele.Bulletin;
import Modele.Evaluation;
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
public class Bulletin_Panel extends JPanel{
    private Bulletin bulletin;

    public Bulletin_Panel(Bulletin bulletin) {
        this.bulletin = bulletin;
        this.setLayout(new BoxLayout(this,Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JLabel titre_trimestre = new JLabel("Trimestre n°"+bulletin.getTrimestre().getNumero()+" de l'année " + bulletin.getTrimestre().getAnnee().getAnnee());
        JLabel periode = new JLabel("Période du "+ bulletin.getTrimestre().getDebut()+" au "+bulletin.getTrimestre().getFin());
        this.add(titre_trimestre);
        this.add(periode);
        
        JLabel eval = new JLabel("Liste des évaluations");
        this.add(eval);
        for(Evaluation e : bulletin.getEvaluations())
        {
            this.add(new JLabel("     "+"Enseignant : "+e.getEnseignant().getPrenom()+" "+e.getEnseignant().getNom()));
            this.add(new JLabel("     "+"Note : "+e.getNote()+"/20"));
            this.add(new JLabel("     "+e.getAppreciation()));
        }
    }
    
    
}
