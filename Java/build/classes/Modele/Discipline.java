/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author arnaud
 */
public class Discipline {
    private int id;
    private String nom;

    public Discipline(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    
}
