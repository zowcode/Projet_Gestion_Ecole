
package Vue;
import Modele.*;
import java.util.Map.Entry;


/**
 *
 * @author arnau
 */
public class Vue_Console {
    private static DataManager db=new DataManager();
    
    public static void main(String[] args) { 
        db.Load_All_Data();
        
        /*System.out.println("Années :");
        for(Entry<Integer,Annee> elem : db.getAnnees().entrySet())
        {
            Display_Annee(elem.getValue());
            System.out.println();
        }*/
        
        System.out.println("Bulletins :");
        for(Entry<Integer,Bulletin> elem : db.getBulletins().entrySet())
        {
            Display_Bulletin(elem.getValue());
            System.out.println();
        }
        
        System.out.println("Classes :");
        for(Entry<Integer,Classe> elem : db.getClasses().entrySet())
        {
            Display_Classe(elem.getValue());
            System.out.println();
        }
        
        /*System.out.println("Disciplines :");
        for(Entry<Integer,Discipline> elem : db.getDisciplines().entrySet())
        {
            Display_Discipline(elem.getValue());
            System.out.println();
        }*/
        
        System.out.println("Eleves :");
        for(Entry<Integer,Eleve> elem : db.getEleves().entrySet())
        {
            Display_Eleve(elem.getValue());
            System.out.println();
        }
        
        System.out.println("Enseignants :");
        for(Entry<Integer,Enseignant > elem : db.getEnseignants().entrySet())
        {
            Display_Enseignant (elem.getValue());
            System.out.println();
        }
        
        /*System.out.println("Enseignements :");
        for(Entry<Integer,Enseignement> elem : db.getEnseignements().entrySet())
        {
            Display_Enseignement(elem.getValue());
            System.out.println();
        }
        
        System.out.println("Evaluations :");
        for(Entry<Integer,Evaluation> elem : db.getEvaluations().entrySet())
        {
            Display_Evaluation(elem.getValue());
            System.out.println();
        }
        
        /*System.out.println("Inscriptions :");
        for(Entry<Integer,Inscription> elem : db.getInscriptions().entrySet())
        {
            Display_Inscription(elem.getValue());
            System.out.println();
        }
        
        System.out.println("Niveaux :");
        for(Entry<Integer,Niveau> elem : db.getNiveaux().entrySet())
        {
            Display_Niveau(elem.getValue());
            System.out.println();
        }
        
        System.out.println("Trimestres :");
        for(Entry<Integer,Trimestre> elem : db.getTrimestres().entrySet())
        {
            Display_Trimestre(elem.getValue());
            System.out.println();
        }*/
    }
    
    public static void Display_Annee(Annee annee)
    {
        System.out.println(annee.getAnnee());
    }
    
    public static void Display_Bulletin(Bulletin bulletin)
    {
        Display_Inscription(db.getInscriptions().get(bulletin.getInscription().getId()));
        Display_Trimestre(db.getTrimestres().get(bulletin.getTrimestre().getId()));
        System.out.println("Evaluations:");
        for(Evaluation e : bulletin.getEvaluations())
        {
            Display_Evaluation(e);
        }
    }
    
    public static void Display_Classe(Classe classe)
    {
        System.out.print(classe.getNom()+" ");
        Display_Niveau(db.getNiveaux().get(classe.getNiveau().getId()));
        Display_Annee(db.getAnnees().get(classe.getAnnee().getId()));
        System.out.println("Liste des élèves :");
        for(Eleve e : classe.getEleves())
        {
            Display_Eleve(e);
        }
        System.out.println("Liste des enseignants :");
        for(Enseignant e : classe.getEnseignants())
        {
            Display_Enseignant(e);
        }
    }
    
    public static void Display_Discipline(Discipline discipline)
    {
        System.out.println(discipline.getNom());
    }
    
    public static void Display_Eleve(Eleve eleve)
    {
        System.out.println(eleve.getPrenom()+" "+eleve.getNom());
    }
    
    public  static void Display_Enseignant(Enseignant enseignant)
    {
        System.out.println(enseignant.getPrenom()+" "+enseignant.getNom());
        System.out.println("Matières enseignées:");
        for(Discipline d : enseignant.getDisciplines())
        {
            Display_Discipline(d);
        }
    }
    
    public static void Display_Enseignement(Enseignement enseignement)
    {
        Display_Classe(db.getClasses().get(enseignement.getClasse().getId()));
        Display_Enseignant(db.getEnseignants().get(enseignement.getEnseignant().getId()));
        Display_Discipline(db.getDisciplines().get(enseignement.getDiscipline().getId()));
    }
    
    public static void Display_Evaluation(Evaluation evaluation)
    {
        System.out.println(evaluation.getNote()+"/20");
        System.out.println(evaluation.getAppreciation());
        Display_Bulletin(db.getBulletins().get(evaluation.getBulletin().getId()));
        Display_Enseignant(db.getEnseignants().get(evaluation.getEnseignant().getId()));        
    }
    
    public static void Display_Inscription(Inscription inscription)
    {
        Display_Eleve(db.getEleves().get(inscription.getEleve().getId()));
        Display_Classe(db.getClasses().get(inscription.getClasse().getId()));
    }
    
    public static void Display_Niveau(Niveau niveau)
    {
        System.out.println(niveau.getNom());
    }
    
    public static void Display_Trimestre(Trimestre trimestre)
    {
        System.out.print("Trimestre n°"+trimestre.getNumero()+" ");
        Display_Annee(db.getAnnees().get(trimestre.getAnnee().getId()));
        System.out.println("début : "+trimestre.getDebut());
        System.out.println("fin : "+trimestre.getFin());
    }
}
