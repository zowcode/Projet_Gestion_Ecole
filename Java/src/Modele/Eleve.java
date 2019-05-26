
package Modele;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class Eleve {
    private int id;
    private String nom;
    private String prenom;
    private Classe classe;
    private ArrayList<Bulletin> bulletins = new ArrayList();

    public Eleve(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Eleve(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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

    public ArrayList<Bulletin> getBulletins() {
        return bulletins;
    }
    
    
}
