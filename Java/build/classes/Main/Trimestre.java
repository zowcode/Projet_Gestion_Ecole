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
public class Trimestre {
    private int id;
    private int numero;
    private int debut;
    private int fin;
    private Annee annee;

    public Trimestre(int id, int numero, int debut, int fin, Annee annee) {
        this.id = id;
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

    public int getDebut() {
        return debut;
    }

    public int getFin() {
        return fin;
    }

    public Annee getAnnee() {
        return annee;
    }
    
    
}
