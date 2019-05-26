package Modele;

import DAO_Package.DAO;
import DAO_Package.DAOFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author arnau
 */
public class DataManager {
    private Map<Integer,Annee> annees = new HashMap<Integer,Annee>();
    private Map<Integer,Bulletin> bulletins = new HashMap<Integer,Bulletin>();
    private Map<Integer,Classe> classes = new HashMap<Integer,Classe>();
    private Map<Integer,Discipline> disciplines = new HashMap<Integer,Discipline>();
    private Map<Integer,Eleve> eleves = new HashMap<Integer,Eleve>();
    private Map<Integer,Enseignant> enseignants = new HashMap<Integer,Enseignant>();
    private Map<Integer,Enseignement> enseignements = new HashMap<Integer,Enseignement>();
    private Map<Integer,Evaluation> evaluations = new HashMap<Integer,Evaluation>();
    private Map<Integer,Inscription> inscriptions = new HashMap<Integer,Inscription>();
    private Map<Integer,Niveau> niveaux = new HashMap<Integer,Niveau>();
    private Map<Integer,Trimestre> trimestres = new HashMap<Integer,Trimestre>();
    

    public DataManager() {
      
    }
    
    public void Load_All_Data()
    {
        Load_Annee();
        Load_Bulletin();
        Load_Classe();
        Load_Discipline();
        Load_Eleve();
        Load_Enseignant();
        Load_Enseignement();
        Load_Evaluation();
        Load_Inscription();
        Load_Niveau();
        Load_Trimestre();
        Set_Data_Classes();
        Set_Data_Bulletins();
    }
    
    public void Save_All_Data()
    {
        Save_Annee();
        Save_Bulletin();
        Save_Classe();
        Save_Discipline();
        Save_Eleve();
        Save_Enseignant();
        Save_Enseignement();
        Save_Evaluation();
        Save_Inscription();
        Save_Niveau();
        Save_Trimestre();
    }
    
    
    private void Load_Annee()
    {
        DAO<Annee> DAO= DAOFactory.getDAO_Annee();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Annee a = DAO.find(i);
                annees.put(a.getId(),a);
            }
        }
    }
    
    
    private void Load_Bulletin()
    {
        DAO<Bulletin> DAO= DAOFactory.getDAO_Bulletin();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Bulletin a = DAO.find(i);
                bulletins.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Classe()
    {
        DAO<Classe> DAO= DAOFactory.getDAO_Classe();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Classe a = DAO.find(i);
                classes.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Discipline()
    {
        DAO<Discipline> DAO= DAOFactory.getDAO_Discipline();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Discipline a = DAO.find(i);
                disciplines.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Eleve()
    {
        DAO<Eleve> DAO= DAOFactory.getDAO_Eleve();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Eleve a = DAO.find(i);
                eleves.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Enseignant()
    {
        DAO<Enseignant> DAO= DAOFactory.getDAO_Enseignant();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Enseignant a = DAO.find(i);
                enseignants.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Enseignement()
    {
        DAO<Enseignement> DAO= DAOFactory.getDAO_Enseignement();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Enseignement a = DAO.find(i);
                enseignements.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Evaluation()
    {
        DAO<Evaluation> DAO= DAOFactory.getDAO_Evaluation();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Evaluation a = DAO.find(i);
                evaluations.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Inscription()
    {
        DAO<Inscription> DAO= DAOFactory.getDAO_Inscription();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Inscription a = DAO.find(i);
                inscriptions.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Niveau()
    {
        DAO<Niveau> DAO= DAOFactory.getDAO_Niveau();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Niveau a = DAO.find(i);
                niveaux.put(a.getId(),a);
            }
        }
    }
    
    private void Load_Trimestre()
    {
        DAO<Trimestre> DAO= DAOFactory.getDAO_Trimestre();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Trimestre a = DAO.find(i);
                trimestres.put(a.getId(),a);
            }
        }
    }
    
    private void Save_Annee()
    {
        DAO<Annee> DAO= DAOFactory.getDAO_Annee();
        for(Entry<Integer, Annee> entry : annees.entrySet()) {  
            Annee a = entry.getValue();
            DAO.update(a);
        }
    }
    
    private void Save_Bulletin()
    {
        DAO<Bulletin> DAO= DAOFactory.getDAO_Bulletin();
        for(Entry<Integer, Bulletin> entry : bulletins.entrySet()) {  
            Bulletin a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Classe()
    {
        DAO<Classe> DAO= DAOFactory.getDAO_Classe();
        for(Entry<Integer, Classe> entry : classes.entrySet()) {  
            Classe a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Discipline()
    {
        DAO<Discipline> DAO= DAOFactory.getDAO_Discipline();
        for(Entry<Integer, Discipline> entry : disciplines.entrySet()) {  
            Discipline a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Eleve()
    {
        DAO<Eleve> DAO= DAOFactory.getDAO_Eleve();
        for(Entry<Integer, Eleve> entry : eleves.entrySet()) {  
            Eleve a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Enseignant()
    {
        DAO<Enseignant> DAO= DAOFactory.getDAO_Enseignant();
        for(Entry<Integer, Enseignant> entry : enseignants.entrySet()) {  
            Enseignant a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Enseignement()
    {
        DAO<Enseignement> DAO= DAOFactory.getDAO_Enseignement();
        for(Entry<Integer, Enseignement> entry : enseignements.entrySet()) {  
            Enseignement a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Evaluation()
    {
        DAO<Evaluation> DAO= DAOFactory.getDAO_Evaluation();
        for(Entry<Integer, Evaluation> entry : evaluations.entrySet()) {  
            Evaluation a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Inscription()
    {
        DAO<Inscription> DAO= DAOFactory.getDAO_Inscription();
        for(Entry<Integer, Inscription> entry : inscriptions.entrySet()) {  
            Inscription a = entry.getValue();
            DAO.update(a);
        }
    }
    private void Save_Niveau()
    {
        DAO<Niveau> DAO= DAOFactory.getDAO_Niveau();
        for(Entry<Integer, Niveau> entry : niveaux.entrySet()) {  
            Niveau a = entry.getValue();
            DAO.update(a);
        }
    }
   
    private void Save_Trimestre()
    {
        DAO<Trimestre> DAO= DAOFactory.getDAO_Trimestre();
        for(Entry<Integer, Trimestre> entry : trimestres.entrySet()) {  
            Trimestre a = entry.getValue();
            DAO.update(a);
        }
    }
    

    public Map<Integer, Annee> getAnnees() {
        return annees;
    }

    public Map<Integer, Bulletin> getBulletins() {
        return bulletins;
    }

    public Map<Integer, Classe> getClasses() {
        return classes;
    }

    public Map<Integer, Discipline> getDisciplines() {
        return disciplines;
    }

    public Map<Integer, Eleve> getEleves() {
        return eleves;
    }

    public Map<Integer, Enseignant> getEnseignants() {
        return enseignants;
    }

    public Map<Integer, Enseignement> getEnseignements() {
        return enseignements;
    }

    public Map<Integer, Evaluation> getEvaluations() {
        return evaluations;
    }

    public Map<Integer, Inscription> getInscriptions() {
        return inscriptions;
    }

    public Map<Integer, Niveau> getNiveaux() {
        return niveaux;
    }

    public Map<Integer, Trimestre> getTrimestres() {
        return trimestres;
    }
    
    public void Set_Data_Bulletins()
    {
        for(Entry<Integer,Bulletin> bull : bulletins.entrySet())
        {
            Bulletin b = bull.getValue();
            Inscription i = b.getInscription();
            Eleve e = eleves.get(i.getEleve().getId());
            e.getBulletins().add(b);
            for(Entry<Integer,Evaluation> eval : evaluations.entrySet())
            {
                Evaluation ev = eval.getValue();
                if(b.getId()==ev.getBulletin().getId())
                {
                    b.getEvaluations().add(ev);
                    
                }
            }
        }
    }
    
    public void Set_Data_Classes()
    {
        for(Entry<Integer,Inscription> inscri : inscriptions.entrySet())
        {
            Inscription i = inscri.getValue();
            Classe c = classes.get(i.getClasse().getId());
            Eleve e = eleves.get(i.getEleve().getId());
            c.getEleves().add(e);
            e.setClasse(c);
        }
        
        for(Entry<Integer,Enseignement> enseignement : enseignements.entrySet())
        {
            Enseignement m = enseignement.getValue();
            Classe c = classes.get(m.getClasse().getId());
            Enseignant p = enseignants.get(m.getEnseignant().getId());
            Discipline d = disciplines.get(m.getDiscipline().getId());
            if(!c.getEnseignants().contains(p))
            {
                c.getEnseignants().add(p);
            }
            if(!p.getClasses().contains(c))
            {
                p.getClasses().add(c);
            }
            
            if(!p.getDisciplines().contains(d))
            {
                p.getDisciplines().add(d);
            }
                
        }
    }
    
}
