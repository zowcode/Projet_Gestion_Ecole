/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author arnau
 */
public class Evaluation {
    private int id;
    private int note;
    private String appreciation;
    private Bulletin bulletin;
    private Enseignant enseignant;

    public Evaluation(int id, int note, String appreciation, Bulletin bulletin,Enseignant enseignant) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.bulletin = bulletin;
        this.enseignant = enseignant;
    }

    public Evaluation(int id, int note,String appreciation) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
    }
    
    

    public int getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
    
    
    
}
