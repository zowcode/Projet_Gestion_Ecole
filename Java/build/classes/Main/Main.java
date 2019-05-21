package Main;

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
        DAO<Eleve> eleve = factory.getDAO_Eleve();
        eleve.create(new Eleve("Arnaud","Emprin"));
        
    }
    
}
