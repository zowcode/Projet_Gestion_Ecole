package Modele;

/**
 *
 * @author arnaud
 */
public class CurrentUser {
    private String email;
    private int type;
    private String nom;
    private String prenom;

    public CurrentUser(String email, int type, String nom, String prenom) {
        this.email = email;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    
}
