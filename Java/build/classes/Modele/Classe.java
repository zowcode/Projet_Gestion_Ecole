/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author arnau
 */
public class Classe {
    private int id;
    private String nom;
    private Niveau niveau;
    private Annee annee;
    private ArrayList<Eleve> eleves = new ArrayList();
    private ArrayList<Enseignant> enseignants = new ArrayList();

    public Classe(int id, String nom, Niveau niveau, Annee annee) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
        this.annee = annee;
    }

    public Classe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Annee getAnnee() {
        return annee;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }

    public ArrayList<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(ArrayList<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
    
    
}
