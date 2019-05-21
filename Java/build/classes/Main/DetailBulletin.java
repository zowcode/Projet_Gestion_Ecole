/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author arnau
 */
public class DetailBulletin {
    private int id;
    private Bulletin bulletin;
    private Enseignant enseignant;

    public DetailBulletin(int id, Bulletin bulletin, Enseignant enseignant) {
        this.id = id;
        this.bulletin = bulletin;
        this.enseignant = enseignant;
    }
    

    public int getId() {
        return id;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }
    
    
}
