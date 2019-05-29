package Modele;

/**
 *
 * @author arnaud
 */
public class CurrentUser {
    private int id;
    private String email;
    private int type;
    private String nom;
    private String prenom;

    public CurrentUser(String email, int type, String nom, String prenom,int id) {
        this.email = email;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
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

    public int getId() {
        return id;
    }
    
    
}
