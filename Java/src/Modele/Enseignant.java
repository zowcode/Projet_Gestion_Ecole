
package Modele;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class Enseignant {
    private int id;
    private String nom;
    private String prenom;
    private ArrayList<Discipline> disciplines = new ArrayList();
    private ArrayList<Classe> classes = new ArrayList();

    public Enseignant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }
    
    
}
