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
public class Annee {
    private int id;
    private String annee;

    public Annee(int id,String annee) {
        this.id = id;
        this.annee = annee;
    }

    public int getId() {
        return id;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
    
}
