package Main;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOFactory factory = new DAOFactory();
        
        //tests
        ArrayList<Eleve> studs = new ArrayList();
        
        DAO<Eleve> eleve = factory.getDAO_Eleve();
        for(int i =1;i<eleve.getMaxId()+1;i++)
        {
            studs.add(eleve.find(i));
        }
        
        for(Eleve e : studs)
        {
            System.out.println(e.getPrenom());
        }
    }
    
}
