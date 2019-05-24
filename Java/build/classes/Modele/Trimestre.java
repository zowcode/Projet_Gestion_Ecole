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
public class Trimestre {
    private int id;
    private int numero;
    private String debut;
    private String fin;
    private Annee annee;

    public Trimestre(int id, int numero, String debut, String fin, Annee annee) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.annee = annee;
    }

    public Trimestre(int id, int numero, String debut, String fin) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
    }

    public Trimestre(int numero, String debut, String fin, Annee annee) {
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.annee = annee;
    }
    
    

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public String getDebut() {
        return debut;
    }

    public String getFin() {
        return fin;
    }

    public Annee getAnnee() {
        return annee;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }
    
    
}
